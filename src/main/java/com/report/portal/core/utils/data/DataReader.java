package com.report.portal.core.utils.data;

import com.report.portal.core.exceptions.TestConfigException;
import com.report.portal.core.exceptions.TestDataException;
import com.report.portal.core.logging.Log;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.report.portal.core.utils.data.ResourceUtils.getFile;

public class DataReader {

    private DataReader() {
        throw new IllegalStateException("Utility class");
    }

    public static Properties readPropertiesFile(String fileName) {
        Log.debug("Loading properties from '%s' file...", fileName);
        InputStream input = readFile(getFile(fileName));
        Properties prop = new Properties();

        try {
            prop.load(input);
        } catch(IOException e) {
            throw new TestConfigException("Cannot load properties from '%s' file -> %s", fileName, e.getMessage());
        }
        return prop;
    }

    public static InputStream readFile(File file) {
        InputStream input;
        try {
            input = new FileInputStream(file);
        } catch(IOException e) {
            throw new TestDataException("Cannot load content from '%s' file -> %s", file.getAbsolutePath(), e.getMessage());
        }
        return input;
    }
}
