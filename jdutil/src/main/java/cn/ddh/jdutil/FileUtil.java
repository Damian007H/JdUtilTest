package cn.ddh.jdutil;

import android.os.Environment;

import java.io.File;

public class FileUtil {
    private static final String TAG = "FileUtil";
    /**
     * 在指定路径创建文件夹
     * @param path 指定路径
     * @return 创建成功之后的文件夹路径
     */
    public static String makedir(String path) {
        String sdPath = getSDPath();
        String[] dirs = path.replace(sdPath, "").split("/");
        StringBuilder filePath = new StringBuilder(sdPath);
        for (String dir : dirs) {
            if (!"".equals(dir) && !dir.equals(sdPath)) {
                filePath.append("/").append(dir);
                File destDir = new File(filePath.toString());
                if (!destDir.exists()) {
                    boolean b = destDir.mkdirs();
                    if (!b) {
                        return null;
                    }
                }
            }
        }
        return filePath.toString();
    }


    /**
     * 获取文件夹根目录
     *
     * @return 手机的根目录
     */
    public static String getSDPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

}
