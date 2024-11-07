package com.example.models;

public class Request {
    private int id;
    private User user;
    private Software software;
    private String accessType;  // e.g., "Read", "Write", "Admin"
    private String reason;
    private String status;  // e.g., "Pending", "Approved", "Rejected"

    // Constructors
    public Request(int id, User user, Software software, String accessType, String reason, String status) {
        this.id = id;
        this.user = user;
        this.software = software;
        this.accessType = accessType;
        this.reason = reason;
        this.status = status;
    }

    public Request(User user, Software software, String accessType, String reason) {
        this.user = user;
        this.software = software;
        this.accessType = accessType;
        this.reason = reason;
        this.status = "Pending"; // Default status is "Pending"
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Optional: Add a toString method for debugging
    @Override
    public String toString() {
        return "Request{id=" + id + ", user=" + user.getUsername() + ", software=" + software.getName() +
               ", accessType='" + accessType + "', status='" + status + "'}";
    }
}
