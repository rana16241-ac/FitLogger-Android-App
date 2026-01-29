package com.fitlogger.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fitlogger.app.models.FitnessActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivityDAO (Data Access Object) Class
 * 
 * EXAM IMPORTANT: This class follows the DAO design pattern
 * It provides an abstract interface to the database
 * Separates business logic from database operations
 * 
 * Key Responsibilities:
 * - Insert new activities
 * - Retrieve all activities
 * - Delete activities
 * - Encapsulate all SQL operations
 */
public class ActivityDAO {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    /**
     * Constructor - Initializes DatabaseHelper
     * @param context Application context
     */
    public ActivityDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    /**
     * Opens database connection for writing
     * Must be called before any write operations
     */
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    /**
     * Closes database connection
     * Should be called when done with database operations
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * INSERT OPERATION
     * Inserts a new fitness activity into the database
     * 
     * @param activity FitnessActivity object to insert
     * @return row ID of newly inserted record, -1 if error
     * 
     * EXAM NOTE: Uses ContentValues to safely insert data
     * Prevents SQL injection attacks
     */
    public long insertActivity(FitnessActivity activity) {
        // ContentValues stores key-value pairs (column name -> value)
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ACTIVITY_NAME, activity.getActivityName());
        values.put(DatabaseHelper.COLUMN_DURATION, activity.getDuration());
        values.put(DatabaseHelper.COLUMN_DATE, activity.getDate());

        // Insert into database and return row ID
        return database.insert(DatabaseHelper.TABLE_ACTIVITIES, null, values);
    }

    /**
     * SELECT/READ OPERATION
     * Retrieves all fitness activities from database
     * 
     * @return List of all FitnessActivity objects
     * 
     * EXAM NOTE: Uses Cursor to iterate through query results
     * Cursor is like a pointer to rows in result set
     */
    public List<FitnessActivity> getAllActivities() {
        List<FitnessActivity> activities = new ArrayList<>();

        // Query all records, ordered by ID descending (newest first)
        Cursor cursor = database.query(
            DatabaseHelper.TABLE_ACTIVITIES,  // Table name
            null,                              // Columns (null = all columns)
            null,                              // WHERE clause
            null,                              // WHERE arguments
            null,                              // GROUP BY
            null,                              // HAVING
            DatabaseHelper.COLUMN_ID + " DESC" // ORDER BY (newest first)
        );

        // Move cursor to first row
        if (cursor.moveToFirst()) {
            do {
                // Extract data from cursor
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ACTIVITY_NAME));
                String duration = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DURATION));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DATE));

                // Create FitnessActivity object and add to list
                FitnessActivity activity = new FitnessActivity(id, name, duration, date);
                activities.add(activity);

            } while (cursor.moveToNext()); // Move to next row
        }

        // Close cursor to free resources
        cursor.close();

        return activities;
    }

    /**
     * DELETE OPERATION
     * Deletes a fitness activity by ID
     * 
     * @param activityId ID of activity to delete
     * @return number of rows deleted (1 if successful, 0 if not found)
     * 
     * EXAM NOTE: Uses parameterized query to prevent SQL injection
     */
    public int deleteActivity(int activityId) {
        // Delete where ID matches
        return database.delete(
            DatabaseHelper.TABLE_ACTIVITIES,
            DatabaseHelper.COLUMN_ID + " = ?",
            new String[]{String.valueOf(activityId)}
        );
    }

    /**
     * ADDITIONAL HELPER METHOD
     * Gets count of total activities
     * 
     * @return total number of activities in database
     */
    public int getActivityCount() {
        Cursor cursor = database.rawQuery(
            "SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_ACTIVITIES, 
            null
        );
        
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        
        return count;
    }
}
