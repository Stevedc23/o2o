package com.o2o.util;

public class PathUtil {

    private static String separator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")) {
            basePath = "F:/java/image/";
        } else {
            basePath = "/home/image";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String getStoreImagePath(long storeId) {
        String imagePath = "upload/item/store" + storeId + "/";
        return imagePath.replace("/", separator);
    }
}
