package com.sigaf.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Franck
 */
public class OracleDB {

    public static Connection openConexion() {
        Connection cn = null;
        String url = "jdbc:oracle:thin:@201.157.49.17:1521:SIGAFV2";
        String userName = "SIGAFV2";
        String pwd = "MasterSigafV2";
        String driverName = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(driverName).newInstance();
            cn = DriverManager.getConnection(url, userName, pwd);
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
