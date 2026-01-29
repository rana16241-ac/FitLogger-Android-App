package com.fitlogger.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fitlogger.app.R;
import com.fitlogger.app.adapters.ActivityAdapter;
import com.fitlogger.app.database.ActivityDAO;
import com.fitlogger.app.models.FitnessActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * DashboardActivity - Main screen of the application
 * 
 * LIFECYCLE EXPLANATION:
 * - onCreate(): Called when activity is first created
 * - onResume(): Called when activity becomes visible to user
 * 
 * WHY onResume() IS USED:
 * When user returns from AddActivityActivity, onCreate() is NOT called again
 * onResume() is called every time activity comes to foreground
 * This ensures RecyclerView is refreshed with newly added activities
 */
public class DashboardActivity extends AppCompatActivity implements ActivityAdapter.OnActivityDeleteListener {

    private RecyclerView recyclerView;
    private ActivityAdapter adapter;
    private List<FitnessActivity> activityList;
    private ActivityDAO activityDAO;
    private TextView tvEmptyState;
    private FloatingActionButton fabAddActivity;

    /**
     * onCreate() - Called when activity is first created
     * Initializes UI components and sets up RecyclerView
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Setup Toolbar (Top App Bar)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FitLogger Dashboard");

        // Initialize DAO
        activityDAO = new ActivityDAO(this);

        // Initialize views
        recyclerView = findViewById(R.id.recyclerView);
        tvEmptyState = findViewById(R.id.tvEmptyState);
        fabAddActivity = findViewById(R.id.fabAddActivity);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityList = new ArrayList<>();
        adapter = new ActivityAdapter(activityList, this);
        recyclerView.setAdapter(adapter);

        // FAB click listener - Navigate to AddActivityActivity
        fabAddActivity.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, AddActivityActivity.class);
            startActivity(intent);
        });

        // Load activities
        loadActivities();
    }

    /**
     * onResume() - Called when activity comes to foreground
     * 
     * EXAM IMPORTANT: This is called EVERY TIME user returns to this activity
     * Including when returning from AddActivityActivity
     * This ensures the RecyclerView is always up-to-date
     */
    @Override
    protected void onResume() {
        super.onResume();
        // Refresh activities list when returning to dashboard
        loadActivities();
    }

    /**
     * Loads all activities from database and updates RecyclerView
     */
    private void loadActivities() {
        activityDAO.open();
        activityList = activityDAO.getAllActivities();
        activityDAO.close();

        // Update adapter with new data
        adapter.updateActivities(activityList);

        // Show/hide empty state
        if (activityList.isEmpty()) {
            tvEmptyState.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            tvEmptyState.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Creates options menu in toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    /**
     * Handles options menu item clicks
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            // Navigate to Settings
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles delete button clicks from adapter
     */
    @Override
    public void onActivityDelete(FitnessActivity activity, int position) {
        // Show confirmation dialog
        new AlertDialog.Builder(this)
            .setTitle("Delete Activity")
            .setMessage("Are you sure you want to delete this activity?")
            .setPositiveButton("Delete", (dialog, which) -> {
                // Delete from database
                activityDAO.open();
                int result = activityDAO.deleteActivity(activity.getId());
                activityDAO.close();

                if (result > 0) {
                    // Remove from list and update adapter
                    activityList.remove(position);
                    adapter.notifyItemRemoved(position);
                    Toast.makeText(this, "Activity deleted", Toast.LENGTH_SHORT).show();

                    // Check if list is empty
                    if (activityList.isEmpty()) {
                        tvEmptyState.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(this, "Failed to delete activity", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    /**
     * Clean up resources when activity is destroyed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (activityDAO != null) {
            activityDAO.close();
        }
    }
}
