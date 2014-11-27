package ayd.managment.store.persistencia.clase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MyDataAcces {
 
 private String _usuario="root";
 private String _pwd= "";
 private static String _bd="managment";
 //static String _url = "jdbc:mysql://localhost/"+_bd;
 static String _url ="jdbc:mysql://localhost:3306/"+_bd;
 //jdbc:mysql://localhost:3306/managment
 private Connection conn = null;
  
 public MyDataAcces() {
   
	 try{
		 Class.forName("com.mysql.jdbc.Connection");
		 conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
		 if(conn != null)
		 {
			 System.out.println("entreee ");
			 System.out.println("Conexi-n a base de datos "+_url+" . . . Ok");
		 }
	 }
	 catch(SQLException ex)
	 {
		 System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
	 }
	 catch(ClassNotFoundException ex)
	 {
		 System.out.println(ex);
	 } 
 }
  
 public ResultSet getQuery(String _query)
 {
	 Statement state = null;
	 ResultSet resultado = null;
	 try{
		 state = (Statement) conn.createStatement();
		 resultado = state.executeQuery(_query);
	 }
	 catch(SQLException e)
	 {
		 e.printStackTrace();
   
	 }
	 return resultado;
 }
  
 public boolean setQuery(String _query){
	 Statement state = null;
   
	 try{  
		 state=(Statement) conn.createStatement();
		 state.execute(_query);
		 return true;
     } catch (SQLException e){
         e.printStackTrace();
         return false;
     }
 }
}