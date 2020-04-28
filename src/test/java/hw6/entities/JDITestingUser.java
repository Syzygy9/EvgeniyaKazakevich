package hw6.entities;

import java.util.Objects;

public class JDITestingUser {

    private final String number;
    private final String user;
    private final String description;

    public JDITestingUser(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JDITestingUser JDITestingUser = (JDITestingUser) o;
        return Objects.equals(number, JDITestingUser.number) &&
                Objects.equals(user, JDITestingUser.user) &&
                Objects.equals(description, JDITestingUser.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }
}