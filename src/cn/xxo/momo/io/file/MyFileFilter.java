package cn.xxo.momo.io.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件过滤器
 */
public class MyFileFilter implements FileFilter {

    private String suffix ;

    public MyFileFilter(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 第一个，隐藏文件
     * @param pathname
     * @return
     */
//    @Override
//    public boolean accept(File pathname) {
//        return pathname.isHidden();
//    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(suffix)
                /*&& pathname.isHidden()*/;
    }

}
