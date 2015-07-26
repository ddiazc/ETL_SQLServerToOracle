
package com.sigaf.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Franck
 */
public class SourceTable {
    
    private Date timeMin;
    private Integer iDVariable;
    private Float value;

    public SourceTable() {
    }

    public SourceTable(Date timeMin, Integer iDVariable, Float value) {
        this.timeMin = timeMin;
        this.iDVariable = iDVariable;
        this.value = value;
    }

    public Date getTimeMin() {
        return timeMin;
    }

    public void setTimeMin(Date timeMin) {
        this.timeMin = timeMin;
    }

    public Integer getiDVariable() {
        return iDVariable;
    }

    public void setiDVariable(Integer iDVariable) {
        this.iDVariable = iDVariable;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.timeMin);
        hash = 17 * hash + Objects.hashCode(this.iDVariable);
        hash = 17 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SourceTable other = (SourceTable) obj;
        if (!Objects.equals(this.timeMin, other.timeMin)) {
            return false;
        }
        if (!Objects.equals(this.iDVariable, other.iDVariable)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
    
}
