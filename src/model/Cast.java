package model;

import java.util.Objects;

public class Cast implements Comparable<Cast> {
    private String fullName;
    private String role;

    public Cast(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cast cast = (Cast) o;
        return Objects.equals(fullName, cast.fullName) && Objects.equals(role, cast.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, role);
    }

    public String getRole() {
        return role;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return String.format("Actor: %s Role: %s", fullName, role);
    }

    @Override
    public int compareTo(Cast o) {
        if (this.getFullName().equals(o.getFullName())) {
            return this.getRole().compareTo(o.getRole());
        }
        return this.getFullName().compareTo(o.getFullName());
    }
}
