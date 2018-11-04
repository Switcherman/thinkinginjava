package com.pctf.annotion;

import com.pctf.annotationprocessor.MySqlTableCreator;
import com.pctf.entity.Employee;
import com.pctf.exception.DBTableNotFoundException;
import org.junit.Test;

public class TableCreatorTest {

    @Test
    public void tableCreatorTest() throws DBTableNotFoundException {
        Class<Employee> clazz = Employee.class;
        String createSql = new MySqlTableCreator().createSql(clazz);
        System.out.println(createSql);
    }
}
