
package com.sigaf.controller;

/**
 *
 * @author Franck
 */
public class Controller {
    
    public static String getTableName(Integer idVariable) {
        if (idVariable.equals(200002002) || idVariable.equals(200002003) || idVariable.equals(200002004)) {
            return "HT_CINCAMBIENTAL";
        } else if (idVariable.equals(200002018) || idVariable.equals(200002019) || idVariable.equals(200002020)
                || idVariable.equals(200002021) || idVariable.equals(200002035) || idVariable.equals(200002036)) {
            return "HT_CINCCROMATOGRAFO";
        } else if (idVariable.equals(280002006) || idVariable.equals(200002010) || idVariable.equals(200002011)
                || idVariable.equals(200002012) || idVariable.equals(200002013) || idVariable.equals(200002014)
                || idVariable.equals(200002015) || idVariable.equals(200002016) || idVariable.equals(200002017)
                || idVariable.equals(200002023) || idVariable.equals(200002024) || idVariable.equals(200002025)
                || idVariable.equals(200002026) || idVariable.equals(200002027) || idVariable.equals(200002028)
                || idVariable.equals(200002029) || idVariable.equals(200002030)) {
            return "HT_CINCENERGIA";
        }
        return null;
    }
    
}
