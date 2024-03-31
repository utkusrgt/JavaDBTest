package DatabaseDB;

import java.sql.*;

public class DatabaseDB {

    public static final String DB_URL = "jdbc:postgresql://localhost/university";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "portakal";

    public static void main(String[] args) {
        Connection connect = null;
        Statement st = null;
        String AllCol = "SELECT * FROM employees";

        try{
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = connect.createStatement();
            ResultSet data = st.executeQuery(AllCol);
            while (data.next()){
                System.out.println("ID : " + data.getInt("employee_id")
                        + " -  Name : " + data.getString("employee_name")
                        + " - Position : " + data.getString("employee_position")
                        + " - Salary : " + data.getInt("employee_salary"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }

    }
}
