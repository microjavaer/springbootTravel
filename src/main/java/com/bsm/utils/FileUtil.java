package com.bsm.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.UUID;

public class FileUtil {

    public static String getFileSuffix(String path){
        if (StringUtils.isBlank(path)) {
            return "";
        }
        File file = new File(path);
        String fileName = file.getName();
        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        return fileType;
    }

    public static String getRandomFileName(String suffix)
    {
        return UUID.randomUUID() + suffix;
    }
}
