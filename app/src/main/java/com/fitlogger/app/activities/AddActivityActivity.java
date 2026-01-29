package com.fitlogger.app.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fitlogger.app.R;
import com.fitlogger.app.database.ActivityDAO;
import com.fitlogger.app.models.FitnessActivity;

import java.util.Calendar;

/**
 * AddActivityActivity - Screen for adding new fitness activities
 * 
 * Validates user input and saves to database
 */
public class AddActivityActivity extends AppCompatActivity {

    private EditText etActivityName;
    private EditText etDuration;
    private DatePicker datePicker;
    private Button btnSave;
    private ActivityDAO activityDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);

        // Setup Toolbar with back button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize DAO
        activityDAO = new ActivityDAO(this);

        // Initialize views
        etActivityName = findViewById(R.id.etActivityName);
        etDuration = findViewById(R.id.etDuration);
        datePicker = findViewById(R.id.datePicker);
        btnSave = findViewById(R.id.btnSave);

        // Set DatePicker to current date
        Calendar calendar = Calendar.getInstance();
        datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            null
        );

        // Save button click listener
        btnSave.setOnClickListener(v -> saveActivity());
    }

    /**
     * Validates input and saves activity to database
     */
    private void saveActivity() {
        // Get input values
        String activityName = etActivityName.getText().toString().trim();
        String duration = etDuration.getText().toString().trim();

        // Validate inputs
        if (activityName.isEmpty()) {
            etActivityName.setError("Activity name is required");
            etActivityName.requestFocus();
            return;
        }

        if (duration.isEmpty()) {
            etDuration.setError("Duration is required");
            etDuration.requestFocus();
            return;
        }

        // Get selected date from DatePicker
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // Month is 0-indexed
        int year = datePicker.getYear();
        String date = day + "/" + month + "/" + year;

        // Create FitnessActivity object
        FitnessActivity activity = new FitnessActivity(activityName, duration, date);

        // Save to database
        activityDAO.open();
        long result = activityDAO.insertActivity(activity);
        activityDAO.close();

        // Check if save was successful
        if (result != -1) {
            Toast.makeText(this, "Activity saved successfully!", Toast.LENGTH_SHORT).show();
            // Navigate back to Dashboard
            finish(); // This triggers onResume() in DashboardActivity
        } else {
            Toast.makeText(this, "Failed to save activity", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Handle back button in toolbar
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    /**
     * Clean up resources
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (activityDAO != null) {
            activityDAO.close();
        }
    }
}
