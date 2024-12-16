package model;

public class Cast {
    private String fullName;
    private String role;

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return String.format("%nActor: %s Role: %s", fullName, role);
    }
}
