import java.util.*;
import java.sql.*;

public class InsertTest {
    public static void main(String[] args) {
        System.out.println("Modify the Java program\n");
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/library_db?useSSL=false", "myuser", "Cake!@#123");
                Statement stmt = conn.createStatement();
        ) {
            // Deleted the kines so the new lines can be added.
            String sql_delete = "delete from books where id > 8000";
            System.out.println("What will be done: "+sql_delete);
            int countDelete = stmt.executeUpdate(sql_delete);
            System.out.println(countDelete + " Records deleted.\n");
            // Inserted new Lines
            String sql_Insert  = "insert into books values"
                                +"(8001, 'Java ABC', 'Kevin Jones', 3),"
                                +"(8002, 'Java XYZ', 'Kevin Jones', 5)";
            System.out.println("The new records are : " + sql_Insert);
            int countInserted = stmt.executeUpdate(sql_Insert);
            System.out.println(countInserted + " Records inserted\n");


            String strSelect = "select * from books" ;
            System.out.println ( "The SQL query is: " + strSelect);
            ResultSet rset = stmt.executeQuery (strSelect);
            while (rset.next()) {
                System.out.println (rset.getInt("id") + ", "
                        + rset.getString("author") + ", "
                        + rset.getString("title") + ", "
                        + rset.getInt("qty"));
            }
        } catch ( SQLException ex ) {
            ex . printStackTrace ();
        }

    }
}

