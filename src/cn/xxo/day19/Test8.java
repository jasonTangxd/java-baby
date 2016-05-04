package cn.xxo.day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 文件合并、文件分割、配置文件使用
 * @author gs
 *
 */
public class Test8 {
	public static void main(String[] args) throws IOException {
		//指定需要切割的文件
		File filein = new File("D:\\aaa\\y.rmvb");
		//指定合并后的目录
		File fileout = new File("D:\\bbb");
		
		//切分
//		split_file(filein);
		
		//合并
		merge_file(new File(filein.getParent()),fileout);
	}

	/**
	 * 合并文件
	 * @param fileout :合并后的目录
	 * @param filein :合并前的目录
	 * @throws IOException 
	 */
	public static void merge_file(File filein, File fileout) throws IOException {
		/* 获取配置文件信息*/
		Properties prop = new Properties();
		File[] propFiles = filein.listFiles(new MyFilenameFilter(".properties"));
		
		/*校验部分*/
		if (propFiles.length != 1) {
			//此地默认切分生成目录中只有一个配置文件  如果有多个配置文件 不予合并
			throw new RuntimeException("配置文件不存在或者不唯一");
		}
		//将取到的唯一的配置文件加载到Properties对象中
		prop.load(new FileInputStream(propFiles[0]));
		//遍历并查找文件切分后的文件
		File[] listFiles = filein.listFiles(new MyFilenameFilter(".part"));
		//判断文件个数是否等于切分时写入配置文件中的个数
		if(listFiles.length != Integer.parseInt(prop.getProperty("filesplitnum"))){
			throw new RuntimeException("文件缺失！");
		}
		
		/*合并部分*/
		//最终输出的文件名 从配置文件中读取  合并到fileout中
		FileOutputStream fos = new FileOutputStream(new File(fileout,prop.getProperty("filename")));
		//定义一个容器
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for (File file : listFiles) {
			al.add(new FileInputStream(file));
		}
		//将ArrayList中转换为Enumeration
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		//使用序列流合并
		SequenceInputStream sis = new SequenceInputStream(en);
		//开始合并
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf)) != -1){
			fos.write(buf, 0, len);
		}
		
		/* 资源释放部分*/
		//关闭流
		sis.close();
		fos.close();
		
	}

	/**
	 * 切割文件
	 * 参数一 file： 传递进来需要切割的文件
	 * @throws IOException 
	 * 
	 */
	public static void split_file(File file) throws IOException {
		//读取原来的大文件
		FileInputStream fis = new FileInputStream(file);
		//定义输出流
		FileOutputStream fos = null;
		//获取需要切割的文件的所在路径 并将路径封装成为一个File对象
		File path = new File(file.getParent());
		
		byte[] buf = new byte[10485760 * 3];
		int len = 0;
		int count = 0;
		while((len = fis.read(buf)) != -1){
			fos = new FileOutputStream(new File(path, (count++) + ".part"));
			fos.write(buf, 0, len);
			fos.close();
		}
		
		//写配置文件
		Properties prop = new Properties();
		prop.setProperty("filename", file.getName());
		prop.setProperty("filesplitnum", count+"");
		//将配置对象存储到配置文件中       new File(new File("D:\\aaa\\"), file.getName()+".properties" = y.rmvb.properties)
		prop.store(new FileOutputStream(new File(path,file.getName()+".properties")), "file split infos");
		
		//关闭流
		fis.close();
	}
}
