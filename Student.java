package model;

public class Student {

    private int id;
    private String name;
    private String rollNo;
    private String email;
    private String course;
    private double cgpa;
    private String phone;

    public Student() {
    }

    public Student(int id, String name, String rollNo,
                   String email, String course,
                   double cgpa, String phone) {

        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.course = course;
        this.cgpa = cgpa;
        this.phone = phone;
    }

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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}