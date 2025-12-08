//Need to have getters and setters because I'm planning on adding an update feature, so data will change.

public class Student {

    private String name;
    private String surname;
    private int age;
    private String id;

    public Student(String name, String surname, int age, String id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    //String
    @Override
    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\nAge: " + age + "\nID: " + id;
    }
}
