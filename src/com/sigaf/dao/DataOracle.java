
package com.sigaf.dao;

import com.sigaf.model.SourceTable;
import com.sigaf.persistence.OracleDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franck
 */
public class DataOracle {
    
    public static boolean insertRecords(List<SourceTable> listOfRecords, String tableName) {
        Connection connect = null;
        String insertQuery = "INSERT INTO " + tableName + " (ID_PEE, FECH_PERIODO, NUM_PERIODO, "
                + "ID_VARIABLE, VAL_VALOR) VALUES(?, ?, ?, ?, ?)";
        try {
            connect = OracleDB.openConexion();
            PreparedStatement preparedStatement = connect.prepareStatement(insertQuery);
            connect.setAutoCommit(false);
            int i = getLastID(tableName, connect);
            for (SourceTable item : listOfRecords) {
                preparedStatement.setInt(1, ++i);
                preparedStatement.setTimestamp(2, item.getTimeMin());
                preparedStatement.setInt(3, 1);
                preparedStatement.setInt(4, item.getiDVariable());
                preparedStatement.setFloat(5, item.getValue());
                preparedStatement.addBatch();
            }
            System.out.println("Saliendo del for.");
            preparedStatement.executeBatch();
            System.out.println("Batch ejecutado.");
            connect.commit();
            System.out.println("Commit realizado.");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            OracleDB.closeConexion(connect);
        }
    }
    
    public static int getLastID(String tableName, Connection connect) {
        String query = "Select max(ID_PEE) as LAST_ID from " + tableName;
        try {
            int result = 0;
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery(query);
            if (rs.next()) {
                result = rs.getInt("LAST_ID");
            }
            rs.close();
            preparedStatement.close();
            return result + 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
}
