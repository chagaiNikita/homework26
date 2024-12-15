package model;

public class Cast {
    private String fullName;
    private String role;

    @Override
    public String toString() {
        return String.format("%nActor: %s Role: %s", fullName, role);
    }
}
