package com.xxo.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 自定义的一个过滤器
 * name
 */
class MyFilenameFilter implements FilenameFilter {

    private String suffix ;
    private MyFilenameFilter(){}

    public MyFilenameFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
