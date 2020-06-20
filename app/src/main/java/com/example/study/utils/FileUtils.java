package com.example.study.utils;

import java.io.File;

public class FileUtils {

    /**
     * 创建文件夹 通过路径
     *
     * @param dirPath
     * @return
     */

    private static boolean createDir(final String dirPath) {
        return createDir(getFileByPath(dirPath));
    }

    /**
     * 创建文件夹
     *
     * @param file
     * @return
     */
    public static boolean createDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    /**
     * 获取文件 通过路径
     *
     * @param filePath
     * @return
     */
    public static File getFileByPath(final String filePath) {
        return isSpace(filePath) ? null : new File(filePath);
    }

    private static boolean isSpace(final String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
