
public class Student {

    public String name;
    public String surname;
    public int age;
    public int group;
    public double averageMark;

    public Student(String name, String surname, int age, int group, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.group = group;
        this.averageMark = averageMark;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }

        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(
                    "age cannot be negative: " + age);
        }
        if (age > 150 || age < 16) {
            throw new IllegalArgumentException(
                    "a student cannot be older than 65 and younger than 16 "
            );
        }
        this.age = age;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
