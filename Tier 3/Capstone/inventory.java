import java.sql.*;
import java.util.*;

public class inventory {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Connecting to bookstore_db...");
        System.out.println("options below.\n"
                +"1.Create A Table.\n"
                +"2.New Entry.\n"
                +"3.Update.\n"
                +"4.Delete.\n"
                +"5.Search.\n"
                +"6.Show Everything.\n"
                +"0.Exit.");
        System.out.println("\nPlease enter one of the options.");

        int options = input.nextInt();
        switch(options){
            case 1:
                System.out.println("Creating new table called Books.");
                CreateTable();
                break;
            case 2:
                post();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                search();
                break;
            case 6:
                everything();
                break;
            case 0:
                System.exit(0);
                break;
             default:
                 System.out.println("The number was not defined.");
                 break;

        }

    }
    //Create new table
    public static void CreateTable() throws Exception{

        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS books(id int, title varchar(50), author varchar(50), qty int, primary key(id))");
            create.executeUpdate();
            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Function Complete.");
        }
    }
    // Add new entry
    public static void post() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("NB* ID needs to have a number value!\n"+"Please Enter ID of the book");
        String id_int = input.nextLine();
        System.out.println("If you don't know Title, Author or Qty please enter 'null'\n"+"Please Enter the Title of the book");
        String title_var = input.nextLine();
        System.out.println("Please Enter the Author of the book");
        String author_var = input.nextLine();
        System.out.println("Please Enter the QTY of the book");
        String qty_int = input.nextLine();
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO books(id,title,author,qty) VALUES ("+id_int+", '"+title_var+"', '"+author_var+"', "+qty_int+")");
            posted.executeUpdate();
            con.close();
        }catch(Exception e)
        {
            System.out.println("Missing Fields \n"+e);
        }
        finally {
            System.out.println("Insert Completed.");
        }

    }
    //Update IDS
    public static void update() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the new ID");
        int newid = input.nextInt();
        System.out.println("Please enter the old ID");
        int oldid = input.nextInt();

        try{
            Connection con = getConnection();
            String queryUpdate = "update books set id = ? where id = ?";
            PreparedStatement update = con.prepareStatement(queryUpdate);
            update.setInt(1,newid);
            update.setInt(2,oldid);

            update.executeUpdate();
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("Update Completed.");
        }
    }
    //Deletes IDS
    public static void delete() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter ID of the Row you wanna delete");
        int deleteid = input.nextInt();
        try{
            Connection con = getConnection();
            String deleteQuery = "DELETE FROM books where id = ?";
            PreparedStatement delete = con.prepareStatement(deleteQuery);
            delete.setInt(1,deleteid);
            delete.executeUpdate();
            con.close();

        }catch(Exception e){
            System.out.println(e);

        }
        finally{
            System.out.println("Delete Completed");
        }
    }
    //search IDS
    public static void search() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter ID you wanna see");
        int options_search = input.nextInt();

        try{
            Connection con = getConnection();
            String searchQuery ="SELECT id,title FROM books WHERE id = ?";
            PreparedStatement search = con.prepareStatement(searchQuery);
            search.setInt(1,options_search);
            ResultSet rset = search.executeQuery();

            while (rset.next()){
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString ("title"));
            }
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("Search Completed.");
        }
    }
    //Show everything
    public static void everything() throws Exception{
        try{
            Connection con = getConnection();
            String searchQuery ="select * from books";
            PreparedStatement everything = con.prepareStatement(searchQuery);
            ResultSet rset = everything.executeQuery();
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("title")+ ", "
                        + rset.getString ("author")+ ", "
                        + rset.getInt("qty"));
            }
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("\nEverything Completed.");
        }
    }
    //connect to the server.
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/bookstore_db?useSSL=false";
            String username = "myuser";
            String password = "Cake!@#123";

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }



}
