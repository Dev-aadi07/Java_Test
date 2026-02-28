package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem  {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            return;
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected Successfully!");

            while (true) {

                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Update Student Marks");
                System.out.println("3. Delete Student");
                System.out.println("4. View All Students");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // INSERT STUDENT
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO STUDENT (id, name, marks) VALUES (?, ?, ?)";

                        try (PreparedStatement psInsert =
                                     con.prepareStatement(insertQuery)) {

                            psInsert.setInt(1, id);
                            psInsert.setString(2, name);
                            psInsert.setDouble(3, marks);

                            int rows = psInsert.executeUpdate();
                            System.out.println(rows + " student added successfully.");
                        } catch (SQLException e) {
                            System.out.println("Insert Error: " + e.getMessage());
                        }
                        break;

                    // UPDATE STUDENT MARKS
                    case 2:
                        System.out.print("Enter Student ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        String updateQuery =
                                "UPDATE STUDENT SET marks = ? WHERE id = ?";

                        try (PreparedStatement psUpdate =
                                     con.prepareStatement(updateQuery)) {

                            psUpdate.setDouble(1, newMarks);
                            psUpdate.setInt(2, updateId);

                            int updatedRows = psUpdate.executeUpdate();

                            if (updatedRows > 0)
                                System.out.println("Student updated successfully.");
                            else
                                System.out.println("Student not found.");
                        } catch (SQLException e) {
                            System.out.println("Update Error: " + e.getMessage());
                        }
                        break;

                    // DELETE STUDENT
                    case 3:
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM STUDENT WHERE id = ?";

                        try (PreparedStatement psDelete =
                                     con.prepareStatement(deleteQuery)) {

                            psDelete.setInt(1, deleteId);

                            int deletedRows = psDelete.executeUpdate();

                            if (deletedRows > 0)
                                System.out.println("Student deleted successfully.");
                            else
                                System.out.println("Student not found.");
                        } catch (SQLException e) {
                            System.out.println("Delete Error: " + e.getMessage());
                        }
                        break;

                    // FETCH ALL STUDENTS
                    case 4:
                        String selectQuery = "SELECT * FROM STUDENT";

                        try (PreparedStatement psSelect =
                                     con.prepareStatement(selectQuery);
                             ResultSet rs = psSelect.executeQuery()) {

                            System.out.println("\n--- Student Records ---");

                            while (rs.next()) {
                                System.out.println(
                                        "ID: " + rs.getInt("id") +
                                        ", Name: " + rs.getString("name") +
                                        ", Marks: " + rs.getDouble("marks")
                                );
                            }

                        } catch (SQLException e) {
                            System.out.println("Fetch Error: " + e.getMessage());
                        }
                        break;

                    // ✅ EXIT
                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}