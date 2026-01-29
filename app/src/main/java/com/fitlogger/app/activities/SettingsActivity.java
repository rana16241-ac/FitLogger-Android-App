package com.fitlogger.app.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fitlogger.app.R;

/**
 * SettingsActivity - Simple settings screen
 * 
 * EXAM NOTE: This is a placeholder settings screen
 * Can be expanded with actual settings in future
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Setup Toolbar with back button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize placeholder text
        TextView tvSettings = findViewById(R.id.tvSettings);
        tvSettings.setText("Settings Screen\n\n" +
                "This is a placeholder for application settings.\n\n" +
                "Future features could include:\n" +
                "• Notification preferences\n" +
                "• Data backup/restore\n" +
                "• Theme selection\n" +
                "• Activity categories\n" +
                "• Export data to CSV");
    }

    /**
     * Handle back button in toolbar
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
