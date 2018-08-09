package com.jalasoft.minions.data_base_services;

import java.util.EnumMap;
import java.util.Map;

public abstract class DataBaseFactory {
    private static Map<DataBaseType, IDataBase> dataBaseMap = new EnumMap<>(DataBaseType.class);
    private DataBaseFactory(){}

    static {

        dataBaseMap.put(DataBaseType.MONGO, new MongoDB());
        dataBaseMap.put(DataBaseType.SQL_SERVER, new SQLServerDB());
    }
    public IDataBase getDataBase(DataBaseType driverType){
        return dataBaseMap.get(driverType);
    }
}
