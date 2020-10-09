package com.cloudplush.code;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * Connect to a pgsql db, create a table, insert, select
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection c = null;
        Statement stmt = null;
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/docker", "docker", "XdccDa85_JK");

            String sqlCreate = "CREATE TABLE IF NOT EXISTS currencies(id SERIAL PRIMARY KEY, name VARCHAR(3))";
            String sqlInsert = "INSERT INTO currencies (name) VALUES (?)"; 
            String sqlQuery = "SELECT id, name FROM currencies LIMIT ?";

            stmt = c.createStatement();
            stmt.executeUpdate(sqlCreate);
            stmt.close();

            PreparedStatement pstmt = c.prepareStatement(sqlInsert);
            pstmt.setString(1, "CHF");
            pstmt.executeUpdate();
            pstmt.setString(1, "USD");
            pstmt.executeUpdate();
            pstmt.close();

            pstmt = c.prepareStatement(sqlQuery);
            pstmt.setInt(1, 3);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.print("Name: "+rs.getString("name")+", ");
                System.out.print("ID: "+rs.getInt("id"));
                System.out.println();
            }
            rs.close();
            pstmt.close();

            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
         }
    }
}
