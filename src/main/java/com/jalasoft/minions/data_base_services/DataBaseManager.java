package com.jalasoft.minions.data_base_services;


import com.jalasoft.minions.utils.Environment;

public class DataBaseManager {

    private DataBaseManager instance = new DataBaseManager();

    private DataBaseManager() {
        DataBaseType dbType = DataBaseType.valueOf(Environment.getInstance().getDataBaseType());

    }
}
