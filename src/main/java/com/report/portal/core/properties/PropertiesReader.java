package com.report.portal.core.properties;

import com.report.portal.core.logging.Log;

import java.util.Properties;

import static com.report.portal.core.utils.data.DataReader.readPropertiesFile;

public class PropertiesReader {

    private static final Properties prop;

    private static final String RP_PROPERTIES_FILE = "reportportal.properties";

    private PropertiesReader() {
        throw new IllegalStateException("Utility class");
    }

    static {
        prop = readProperties(readPropertiesFile(RP_PROPERTIES_FILE));
    }

    private static Properties readProperties(Properties props) {
        for (String key : props.stringPropertyNames()) {
            if (props.getProperty(key).isEmpty())
                props.setProperty(key, System.getenv(key.toUpperCase().replace(".", "_")));
        }
        return props;
    }

    public static String getProperty(String key) {
        String value = prop.getProperty(key);
        Log.debug("Successfully get '%s' property", key);
        return value;
    }

}
