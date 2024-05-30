package com.example.SistemaHotelaria.config;

import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

  private static final String USER = "postgres";

  private static final String PASSWORD = "123";

  public static Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

    public DB(){};

    public static void createTables(){};


 
  
}
