package com.pctf.annotationprocessor;

import com.pctf.annotation.*;
import com.pctf.exception.DBTableNotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MySqlTableCreator implements TableCreator {

    public String createSql(Class<?> clazz) throws DBTableNotFoundException {
        DBTable table = clazz.getAnnotation(DBTable.class);
        if (table == null || table.name() == null) {
            throw new DBTableNotFoundException("can't fount dbtable in class" + clazz.getName());
        }
        String tableName = table.name();
        Field[] fields = clazz.getDeclaredFields();
        List<String> columns = new ArrayList<>();
        for (Field f : fields) {
            SQLInteger sqlInteger = f.getDeclaredAnnotation(SQLInteger.class);
            if (sqlInteger != null) {
                String column = sqlInteger.column();
                String constraint = getConstraint(sqlInteger.constraints());
                columns.add(column + " int" + constraint);
                continue;
            }
            SQLString sqlString = f.getDeclaredAnnotation(SQLString.class);
            if (sqlString != null) {
                String column = sqlString.column();
                String constraint = getConstraint(sqlString.constraints());
                columns.add(column + " VARCHAR(" + sqlString.value() + ")" + constraint);
                continue;
            }
            SQLDate sqlDate = f.getDeclaredAnnotation(SQLDate.class);
            if (sqlDate != null) {
                String column = sqlDate.column();
                String constraint = getConstraint(sqlDate.constraints());
                columns.add(column + " DATE" + constraint);
                continue;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("create table " + tableName + "(\r\n");
        for (int i = 0; i < columns.size(); i++) {
            String column = columns.get(i);
            if (i == columns.size() - 1) {
                sb.append(column).append("\r\n);");
            } else {
                sb.append(column).append(",\r\n");
            }
        }
        return sb.toString();
    }

    private String getConstraint(Constraints constraints) {
        StringBuilder sb = new StringBuilder();
        if (!constraints.allowNull()) {
            sb.append(" NOT NULL");
        }
        if (constraints.primaryKey()) {
            sb.append(" PRIMARY KEY");
        }
        if (constraints.autoIncrement()) {
            sb.append(" AUTO_INCREMENT");
        }
        if (constraints.unique()) {
            sb.append(" UNIQUE");
        }
        return sb.toString();
    }
}
