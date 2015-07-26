
package test;

import com.sigaf.controller.Controller;
import com.sigaf.dao.DataOracle;
import com.sigaf.dao.DataPeriodic;
import com.sigaf.model.SourceTable;
import java.util.List;

/**
 *
 * @author Franck
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer idVariable = Integer.valueOf(args[0]);
        List<SourceTable> listFromSQLServer = DataPeriodic.getVariableInformation(idVariable);
        System.out.println("Se obtuvieron " + listFromSQLServer.size() + " registros de la base de datos SQL Server.");
        String tableName = Controller.getTableName(idVariable);
        if (DataOracle.insertRecords(listFromSQLServer, tableName)) {
            System.out.println("Se insertaron " + listFromSQLServer.size() + " registros en la tabla " + tableName);
        }
    }
    
}
