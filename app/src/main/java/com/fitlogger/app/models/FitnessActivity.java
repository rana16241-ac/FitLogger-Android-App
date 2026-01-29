package com.fitlogger.app.models;

/**
 * Model class representing a Fitness Activity
 * Contains all properties of a fitness activity record
 */
public class FitnessActivity {
    private int id;
    private String activityName;
    private String duration;
    private String date;

    // Constructor for creating new activity (without ID)
    public FitnessActivity(String activityName, String duration, String date) {
        this.activityName = activityName;
        this.duration = duration;
        this.date = date;
    }

    // Constructor for retrieving activity from database (with ID)
    public FitnessActivity(int id, String activityName, String duration, String date) {
        this.id = id;
        this.activityName = activityName;
        this.duration = duration;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
