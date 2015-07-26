package com.sigaf.dao;

import com.sigaf.model.SourceTable;
import com.sigaf.persistence.SQLServerDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franck
 */
public class DataPeriodic {

    private static final String QUERY;

    static {
        QUERY = "Select TimeMin, IDVariable, Value from DIIRECT_REPORTS_CFE_DataPeriodic where IDVariable = ?";
    }

    public static List<SourceTable> getVariableInformation(Integer idVariable) {
        Connection connect = null;
        try {
            connect = SQLServerDB.openConexion();
            //PreparedStatement preparedStatement = connect.prepareStatement(QUERY);
            //preparedStatement.setInt(1, idVariable);
            //ResultSet rs = preparedStatement.executeQuery(QUERY);
            Statement stm = connect.createStatement();
            ResultSet rs = stm.executeQuery(
                    "Select TimeMin, IDVariable, Value from DIIRECT_REPORTS_CFE_DataPeriodic where IDVariable = " + idVariable + " and Value is not null");
            List<SourceTable> listOfRecords = new ArrayList<SourceTable>();
            while (rs.next()) {
                listOfRecords.add(new SourceTable(rs.getDate("TimeMin"), rs.getInt("IDVariable"), rs.getFloat("Value")));
            }
            return listOfRecords;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            SQLServerDB.closeConexion(connect);
        }
    }

}
