package src;

public class Student {

    private String name;
    private String surname;
    private int age;
    private String id;
    private String grade;

    public Student(String name, String surname, int age, String id, String grade) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
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

    public void setGrade(String grade) {
        this.grade = grade;
    }

    //String
    @Override
    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\nAge: " + age + "\nID: " + id;
    }
}
