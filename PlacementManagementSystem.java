package app;

import java.sql.*;
import java.util.Scanner;
import dao.StudentDAO;
import db.DatabaseConnection;
import model.Student;
public class PlacementManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PLACEMENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addStudent() {
        Scanner sc = new Scanner(System.in);

        try {

            Connection conn =
                    DatabaseConnection.getConnection();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            String rollNo = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();
            Student student = new Student();

            student.setName(name);
            student.setRollNo(rollNo);
            student.setEmail(email);
            student.setCourse(course);
            student.setCgpa(cgpa);
            student.setPhone(phone);
            StudentDAO dao = new StudentDAO();

            dao.addStudent(student, conn);
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewStudents() {
        try {

            Connection conn =
                    DatabaseConnection.getConnection();

            Statement stmt =
                    conn.createStatement();

            ResultSet rs =
                    stmt.executeQuery("SELECT * FROM students");

            System.out.println("\n===== STUDENT LIST =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("roll_no") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("course") + " | " +
                                rs.getDouble("cgpa") + " | " +
                                rs.getString("phone")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void searchStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        try {

            Connection conn =
                    DatabaseConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE roll_no=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, rollNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nStudent Found\n");

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Roll No: " + rs.getString("roll_no"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("CGPA: " + rs.getDouble("cgpa"));
                System.out.println("Phone: " + rs.getString("phone"));

            } else {

                System.out.println("Student Not Found");

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static void updateStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        System.out.print("New CGPA: ");
        double cgpa = sc.nextDouble();

        try {

            Connection conn =
                    DatabaseConnection.getConnection();

            String sql =
                    "UPDATE students SET cgpa=? WHERE roll_no=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setDouble(1, cgpa);
            ps.setString(2, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated Successfully!");
            else
                System.out.println("Student Not Found!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void deleteStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        try {

            Connection conn =
                    DatabaseConnection.getConnection();

            String sql =
                    "DELETE FROM students WHERE roll_no=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully!");
            else
                System.out.println("Student Not Found!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}