package Lesson6;

public class Worker1 {
    int id;
    int salary;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return String.format("id:%d fn:%s ln:%s s:%d", id, firstName, lastName, salary);
    }

    @Override
    public boolean equals(Object obj) {
        var t = (Worker1) obj;
        return id == t.id && firstName == t.firstName;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
