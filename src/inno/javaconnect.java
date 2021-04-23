
package inno;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class javaconnect {
  Connection conn=null;
  public static Connection ConnectDb(){
      try{
          Class.forName("org.sqlite.JDBC");
          Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Nathan Jays Clerkson\\Desktop\\J projects\\Parking\\Reelex.db");
          return conn;
      }
      catch(Exception e){JOptionPane.showMessageDialog(null, e);}
      return null;
  }
  
}
