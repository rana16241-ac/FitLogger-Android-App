package com.fitlogger.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DatabaseHelper class extends SQLiteOpenHelper
 * Manages database creation and version management
 * 
 * EXAM NOTE: This class is responsible for:
 * 1. Creating the database
 * 2. Creating tables
 * 3. Upgrading database schema when version changes
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Information
    private static final String DATABASE_NAME = "FitLogger.db";
    private static final int DATABASE_VERSION = 1;

    // Table Name
    public static final String TABLE_ACTIVITIES = "activities";

    // Column Names
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ACTIVITY_NAME = "activity_name";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_DATE = "date";

    // Create Table SQL Query
    private static final String CREATE_TABLE_ACTIVITIES = 
        "CREATE TABLE " + TABLE_ACTIVITIES + " (" +
        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        COLUMN_ACTIVITY_NAME + " TEXT NOT NULL, " +
        COLUMN_DURATION + " TEXT NOT NULL, " +
        COLUMN_DATE + " TEXT NOT NULL" +
        ")";

    /**
     * Constructor
     * @param context Application context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when database is created for the first time
     * Creates the activities table
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute SQL to create table
        db.execSQL(CREATE_TABLE_ACTIVITIES);
    }

    /**
     * Called when database needs to be upgraded
     * Handles schema changes between versions
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIVITIES);
        // Create tables again
        onCreate(db);
    }
}
