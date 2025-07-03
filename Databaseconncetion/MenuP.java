import java.util.*;
import java.sql.*;

class Menup {
    Connection cn;
    PreparedStatement stmt;
    static Scanner scan = new Scanner(System.in);

    public Menup() throws Exception {
        String url = "jdbc:mysql://localhost:3306/javaLab";
        String uname = "root";
        String pwd = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn = DriverManager.getConnection(url, uname, pwd);
    }

    public void insertRecord() throws Exception {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Roll: ");
        int roll = scan.nextInt();
        System.out.print("Enter Marks: ");
        float marks = scan.nextFloat();
        scan.nextLine();

        stmt = cn.prepareStatement("INSERT INTO students (name, roll, marks) VALUES (?, ?, ?)");
        stmt.setString(1, name);
        stmt.setInt(2, roll);
        stmt.setFloat(3, marks);
        stmt.executeUpdate();
        System.out.println("Student record inserted.");
    }

    public void showRecord() throws Exception {
        System.out.print("Enter Roll No: ");
        int roll = scan.nextInt();

        stmt = cn.prepareStatement("SELECT * FROM students WHERE roll = ?");
        stmt.setInt(1, roll);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                               ", Roll: " + rs.getInt("roll") + ", Marks: " + rs.getFloat("marks"));
        } else {
            System.out.println("No student found with this roll.");
        }
    }

    public void updateMarks() throws Exception {
        System.out.print("Enter Roll No to update marks: ");
        int roll = scan.nextInt();
        System.out.print("Enter New Marks: ");
        float marks = scan.nextFloat();

        stmt = cn.prepareStatement("UPDATE students SET marks = ? WHERE roll = ?");
        stmt.setFloat(1, marks);
        stmt.setInt(2, roll);
        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Marks updated.");
        } else {
            System.out.println("Roll number not found.");
        }
    }

    public void deleteRecord() throws Exception {
        System.out.print("Enter Roll No to delete: ");
        int roll = scan.nextInt();

        stmt = cn.prepareStatement("DELETE FROM students WHERE roll = ?");
        stmt.setInt(1, roll);
        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Record deleted.");
        } else {
            System.out.println("Roll number not found.");
        }
    }

    public static void main(String[] args) throws Exception {
        Menup obj = new Menup();
        while (true) {
            System.out.println("\n1. Insert\n2. Show\n3. Update Marks\n4. Delete\n5. Exit");
            System.out.print("Enter choice: ");
            int ch = scan.nextInt();
            scan.nextLine(); 

            if (ch == 1)
                obj.insertRecord();
            else if (ch == 2)
                obj.showRecord();
            else if (ch == 3)
                obj.updateMarks();
            else if (ch == 4)
                obj.deleteRecord();
            else if (ch == 5)
                break;
            else
                System.out.println("Invalid Choice!");
        }
    }
}
