package jm.task.core.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
   private static final String URL = "jdbc:mysql://localhost:3306/sys";
   private static final String USER = "root";
   private static final String PASSWORD = "24081999Nastya";


   public static Connection getConnection(){
      try {
         return DriverManager.getConnection(URL, USER, PASSWORD);
      }  catch (SQLException e) {
          throw new RuntimeException("Ошибка подключение к базе данных" , e);
      }
   }

   public static void closeConnection(Connection connection){
      if (connection != null){
         try {
            connection.close();
         } catch (SQLException e) {
            System.out.println("Ошибка при закрытии соединения");
         }
      }
   }
}
