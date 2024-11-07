package com.example.models;

public class Software {
    private int id;
    private String name;
    private String description;
    private String[] accessLevels; // e.g., "Read", "Write", "Admin"

    // Constructors
    public Software(int id, String name, String description, String[] accessLevels) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.accessLevels = accessLevels;
    }

    public Software(String name, String description, String[] accessLevels) {
        this.name = name;
        this.description = description;
        this.accessLevels = accessLevels;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getAccessLevels() {
        return accessLevels;
    }

    public void setAccessLevels(String[] accessLevels) {
        this.accessLevels = accessLevels;
    }

    // Optional: Add a toString method for debugging
    @Override
    public String toString() {
        return "Software{id=" + id + ", name='" + name + "', accessLevels=" + String.join(", ", accessLevels) + "}";
    }
}
