package com.sigaf.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Franck
 */
public class SQLServerDB {

    public static Connection openConexion() {
        Connection cn = null;
        //String url = "jdbc:sqlserver://10.206.87.44;databaseName=direct-rb4-invoice_model;user=sgaf;password=sg4fcvh";
        //String url = "jdbc:jtds:sqlserver://10.206.87.44:1433/direct-rb4-invoice_model;username=sgaf;password=sg4fcvh";
        String url = "jdbc:jtds:sqlserver://10.206.87.44:1433/diirect-rb4-invoice_model";
        String username = "sgaf";
        String password = "sg4fcvh";
        //String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String driverName = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(driverName).newInstance();
            cn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println(e);
        }
        return cn;
    }

    public static void closeConexion(Connection cn) {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
