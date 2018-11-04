package com.pctf.annotationprocessor;

import com.pctf.exception.DBTableNotFoundException;

public interface TableCreator {
    String createSql(Class<?> clazz) throws DBTableNotFoundException;
}
