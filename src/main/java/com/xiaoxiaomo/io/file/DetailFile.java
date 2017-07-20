package com.xiaoxiaomo.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 文件或文件夹的创建和删除
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class DetailFile {

    public static void main(String[] args) throws IOException {
        File f = new File("d:\\test2.txt") ;

        //1. 创建文件,如果存在则不创建
        //System.out.println(f.createNewFile());
        //System.out.println(f.delete());  //删除目录，里面需要没有内容
        //System.out.println(f.delete());  //删除文件

        //2. 创建文件夹
        //System.out.println(f.mkdir());
        //2.1 创建多级目录
        //System.out.println(f.mkdirs());

        //3. 虚拟机推出后任然会删除
        f.deleteOnExit() ;
        System.out.println(f.createNewFile());

    }
}
