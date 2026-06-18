package dao;

import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DatabaseConnection;

public class StudentDAO {

    public void addStudent(Student student, Connection conn) {

        try {

            String sql =
                    "INSERT INTO students(name, roll_no, email, course, cgpa, phone) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getRollNo());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setDouble(5, student.getCgpa());
            ps.setString(6, student.getPhone());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}