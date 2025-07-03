import java.sql.*;
class Select {
    public Select() {}
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/javaLab";
        final String uname = "root";
        final String pwd = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cn = DriverManager.getConnection(url, uname, pwd);
        Statement stmt = cn.createStatement();
        String query = "`";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("Details Table:");
        while(rs.next()){
            System.out.println("ID: "+rs.getInt(1)+" Name: "+rs.getString(2)+" Roll: "+rs.getInt(3)+" Marks: "+rs.getFloat(4));
        }
        cn.close();
    }
}
