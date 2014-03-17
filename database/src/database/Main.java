/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author ychabcho
 */
import java.sql.*;

public class Main
{
  Connection conn;

  public static void main(String[] args)
  {
    new Main();
  }

  public Main()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      String url = "jdbc:mysql://localhost:8889/coffeebreak";
      conn = DriverManager.getConnection(url, "root", "root");
      doTests();
      conn.close();
    }
    catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
    catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
    catch (InstantiationException ex) {System.err.println(ex.getMessage());}
    catch (SQLException ex)           {System.err.println(ex.getMessage());}
  }



  private void doTests()
  {
    doSelectTest();

    doInsertTest();  doSelectTest();
    /*doUpdateTest();*/  doSelectTest();
    /*Delete_Price_Sup_6();*/  doSelectTest();
    Delete_All_Coffee(); doSelectTest();
  }

  private void doSelectTest()
  {
    System.out.println("[OUTPUT FROM SELECT]");
    String query = "SELECT COF_NAME, PRICE FROM COFFEES";
    try
    {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        String s = rs.getString("COF_NAME");
        float n = rs.getFloat("PRICE");
        System.out.println(s + "   " + n);
      }
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }

  private void doInsertTest()
  {
    System.out.print("\n[Performing INSERT] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("INSERT INTO COFFEES " +
                       "VALUES ('chocolat', 5)");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }

  private void doUpdateTest()
  {
    System.out.print("\n[Performing UPDATE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("UPDATE COFFEES SET PRICE = PRICE + 1");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }

  private void Delete_Price_Sup_6()
  {
    System.out.print("\n[Performing DELETE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("DELETE FROM COFFEES WHERE PRICE > 6");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
  
    private void Delete_All_Coffee()
  {
    System.out.print("\n[Performing DELETE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("DELETE FROM COFFEES");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
}
