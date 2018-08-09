package com.jalasoft.minions.utils;

import com.jalasoft.minions.custom_exceptions.CustomRuntimeException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Environment {

    public static final String DATA_BASE_TYPE = "DataBaseType";
    private static Environment instance = new Environment();
    private Properties envProperties;

    private Environment() {
        try (FileInputStream fileInputStream = new FileInputStream("gradle.properties")) {
            envProperties = new Properties();
            envProperties.load(fileInputStream);
        } catch (IOException e) {
            String message = "Not instance driver";
//            LOGGER.error(message);
//            LOGGER.info(e);
            throw new CustomRuntimeException(message, e);
        }
    }


    /**
     * This method return the singleton instance of the Environment class.
     *
     * @return the singleton instance.
     */
    public static Environment getInstance() {
        return instance;
    }


    public String getDataBaseType(){
        return envProperties.getProperty(DATA_BASE_TYPE);
    }
}
