package com.report.portal.core.utils.data;

import com.report.portal.core.exceptions.TestDataException;

import java.io.File;
import java.util.Objects;

public class ResourceUtils {

    public static String getFilePath(String fileName) {
        String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
        if (Objects.isNull(filePath)) {
            throw new TestDataException("No '%s' file in resource folder", fileName);
        }
        return filePath;
    }

    public static File getFile(String fileName) {
        return new File(getFilePath(fileName));
    }

}
