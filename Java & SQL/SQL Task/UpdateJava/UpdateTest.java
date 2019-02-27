import java.util.*;
import java.sql.*;


public class UpdateTest {
    public static void main(String[] args){
        try (
// Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager . getConnection (
                        "jdbc:mysql://localhost:3306/library_db?useSSL=false" , "myuser" , "Cake!@#123" );

                Statement stmt = conn . createStatement ();
        ) {
// which returns an int indicating the number of rows affected.
// DELETE records with id>=3000 and id<4000
            String sqlDelete = "delete from books where id>=3000 and id<4000" ;
            System . out . println ( "The SQL query is: " + sqlDelete );
            int countDeleted = stmt . executeUpdate ( sqlDelete );
            System . out . println ( countDeleted + " records deleted.\n" );
// INSERT a record
            String sqlInsert = "insert into books "
                    + "values (3001, 'Programming 101', 'Jane Doe', 1)" ;
            System . out . println ( "The SQL query is: " + sqlInsert );
            int countInserted = stmt . executeUpdate ( sqlInsert );
            System . out . println ( countInserted + " records inserted.\n" );
// INSERT multiple records
            sqlInsert = "insert into books values "
                    + "(3002, 'Programming 101 2nd Edition', 'Jane Doe', 2),"
                    + "(3003, 'Programming 101 3rd Edition', 'Jane Doe', 3)" ;
            System . out . println ( "The SQL query is: " + sqlInsert );
            countInserted = stmt . executeUpdate ( sqlInsert );
            System . out . println ( countInserted + " records inserted.\n" );
// INSERT a partial record
            sqlInsert = "insert into books (id, title, author, qty) "
                    + "values (3004, 'Java is Fun!', 'Kevin Peters',0)" ;
            System . out . println ( "The SQL query is: " + sqlInsert );
            countInserted = stmt . executeUpdate ( sqlInsert );
            System . out . println ( countInserted + " records inserted.\n" );
// Issue a SELECT to check the changes
            String strSelect = "select * from books" ;
            System . out . println ( "The SQL query is: " + strSelect );
            ResultSet rset = stmt . executeQuery ( strSelect );
// Update Introduction to Java Line 45 - 47
            String queryUpdate = "update books set qty = 0 where title = 'Introduction to Java'";
            PreparedStatement preparedStmt = conn.prepareStatement(queryUpdate);
            preparedStmt.executeUpdate();


// Move the cursor to the next row
            while ( rset . next ()) {
                System . out . println ( rset . getInt ( "id" ) + ", "
                        + rset . getString ( "author" ) + ", "
                        + rset . getString ( "title" ) + ", "
                        + rset . getInt ( "qty" ));
            }
        } catch ( SQLException ex ) {
            ex . printStackTrace ();
        }
// Step 5: Close the resources - Done automatically by try-with-resources
    }
}
