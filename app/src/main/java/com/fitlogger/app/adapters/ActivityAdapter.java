package com.fitlogger.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fitlogger.app.R;
import com.fitlogger.app.models.FitnessActivity;

import java.util.List;

/**
 * RecyclerView Adapter for displaying fitness activities
 * 
 * EXAM NOTE: Adapter pattern bridges data and UI
 * Efficiently recycles views for better performance
 */
public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private List<FitnessActivity> activities;
    private OnActivityDeleteListener deleteListener;

    /**
     * Interface for handling delete button clicks
     */
    public interface OnActivityDeleteListener {
        void onActivityDelete(FitnessActivity activity, int position);
    }

    /**
     * Constructor
     * @param activities List of fitness activities
     * @param deleteListener Listener for delete actions
     */
    public ActivityAdapter(List<FitnessActivity> activities, OnActivityDeleteListener deleteListener) {
        this.activities = activities;
        this.deleteListener = deleteListener;
    }

    /**
     * Creates new ViewHolder instances
     * Called when RecyclerView needs a new ViewHolder
     */
    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity, parent, false);
        return new ActivityViewHolder(view);
    }

    /**
     * Binds data to ViewHolder
     * Called to display data at specified position
     */
    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        FitnessActivity activity = activities.get(position);
        
        holder.tvActivityName.setText(activity.getActivityName());
        holder.tvDuration.setText("Duration: " + activity.getDuration());
        holder.tvDate.setText("Date: " + activity.getDate());

        // Handle delete button click
        holder.btnDelete.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onActivityDelete(activity, position);
            }
        });
    }

    /**
     * Returns total number of items
     */
    @Override
    public int getItemCount() {
        return activities.size();
    }

    /**
     * Updates the adapter's data and refreshes UI
     */
    public void updateActivities(List<FitnessActivity> newActivities) {
        this.activities = newActivities;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class holds references to views
     * Reduces findViewById calls for better performance
     */
    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView tvActivityName;
        TextView tvDuration;
        TextView tvDate;
        ImageButton btnDelete;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            tvActivityName = itemView.findViewById(R.id.tvActivityName);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvDate = itemView.findViewById(R.id.tvDate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
