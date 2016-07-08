package com.xxo.pattern;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 1：针对08/Jan/2016:00:03:42 这种日期格式进行解析，最终需要这种格式的：2016-01-08 00:03:42
 *
 * 2：读取这个文件localhost_access_log.xxx
 * 把ip获取到。
 * 最终需要计算ip出现的次数，也就是统计一天之内一个用户访问网站访问了多少次。
 *
 * 3：尝试解析数据中的每一个字段
 *
 * Created by xiaoxiaomo on 2012/4/13.
 */
public class PatternDemo {

    public static void main(String[] args) throws IOException {
        String path = "H:\\chaorenxueyuan\\offline3video\\2016-04-13\\" ;
        String file = "localhost_access_log.2016-01-08.txt" ;
        //read2List(new File( path , file ));
        //read2File(new File( path , file ) , new File( path , "2016-01-08.txt" ) );

        readIP2File(new File(path, file), new File(path, "2016-01-08_ip.txt"));

    }


    /**
     * 读取信息到一个list集合
     * @param file
     * @return
     * @throws IOException
     */
    public static ArrayList<AccessLog> read2List(File file) throws IOException {
        //1. 读取数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file) ) );

        //115.159.109.163 - - [08/Jan/2016:00:00:26 +0800] "POST /sendMobileCode/13342089768 HTTP/1.1" 200 29
        String regex = "((\\d{1,3}\\.?){4}) - - \\[(.+) \\+0800\\] \"(.+) (.+) HTTP/1\\.1\" ([1-9]\\d+) (.+)";
        Pattern compile = Pattern.compile(regex);

        ArrayList<AccessLog> logs = new ArrayList<AccessLog>() ; //转为对象
        AccessLog ac = null ;
        String line  ;
        while ( ( line = reader.readLine() ) != null ){
            //2. 切割数据
            Matcher matcher = compile.matcher(line);
             if ( matcher.find() ){
                 ac = new AccessLog() ;
                 ac.ip = matcher.group(1) ;
                 ac.setDate(matcher.group(3)) ;
                 ac.method = matcher.group(4);
                 ac.url = matcher.group(5);
                 ac.status = matcher.group(6);
                 ac.time = matcher.group(7);
                 logs.add( ac ) ;
            }
        }

        reader.close();
        return logs ;
    }


    /**
     * 读取ip和统计信息到文件
     * @param file
     * @param toPath
     * @throws IOException
     */
    public static void readIP2File(File file, File toPath) throws IOException {
        ArrayList<AccessLog> logs = read2List(file);

        //1. 统计ip地址，和访问次数
        Map<String , Integer> map = new HashMap<>() ;
        for (AccessLog log : logs) {
            if( map.get(log.ip) == null ){
                map.put( log.ip,1 ) ;
            }
            map.put(log.ip , map.get(log.ip)+1) ;
        }

        //2. 存储数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( toPath ))) ;


        //1. 统计ip地址，和访问次数
        TreeSet<AccessIP> set = new TreeSet<>(new Comparator<AccessIP>() {
            @Override
            public int compare(AccessIP o1, AccessIP o2) {
                if( o1.n - o2.n == 0 ){
                    return o1.ip.compareTo(o2.ip) ;
                }
                return -(o1.n - o2.n);
            }
        });


        //迭代
        AccessIP ip  ;
        int i = 0 ;
        for (String s : map.keySet()) {
            ip = new AccessIP() ;
            ip.ip = s ;
            ip.n = map.get(s) ;
            set.add(ip) ;
            i++ ;
        }


        //存储数据

        for (AccessIP ips : set) {
            writer.write(ips.ip + " " + ips.n );
            writer.newLine();
            //i++ ;
        }

        
        System.out.println("IP地址总数："+i);
        writer.close();

    }


    /**
     * 读取全部信息到文件
     * @param file
     * @param toPath
     * @throws IOException
     */
    public static void read2File(File file, File toPath) throws IOException {
        //1. 读取数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file) ) );

        //2. 存储数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( toPath ))) ;

        //115.159.109.163 - - [08/Jan/2016:00:00:26 +0800] "POST /sendMobileCode/13342089768 HTTP/1.1" 200 29
        String regex = "((\\d{1,3}\\.?){4}) - - \\[(.+) \\+0800\\] \"(.+) (.+) HTTP/1\\.1\" ([1-9]\\d+) (\\d+)";
        Pattern compile = Pattern.compile(regex);

        String line  ;
        while ( ( line = reader.readLine() ) != null ){
            //2. 切割数据
            Matcher matcher = compile.matcher(line);
            if ( matcher.find() ){
                writer.write(matcher.group(1) + " " );
                writer.write(AccessLog.getString(matcher.group(3)) + " ") ;
                writer.write(matcher.group(4) + " ");
                writer.write(matcher.group(5) + " ");
                writer.write(matcher.group(6) + " ");
                writer.write(matcher.group(7) + " ");
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }


    static class AccessLog{
        private String ip ;
        private String date ;
        private String method;//GET/SET
        private String url ;
        private String status ;
        private String time ;

        public void setDate(String date) {
            //08/Jan/2016:00:00:26
            //2016-01-08 00:03:42
            date = getString(date);
            this.date = date;
        }

        public static String getString(String date) {
            Matcher compile = Pattern.compile("(\\d{2})/Jan/(\\d{4}):(.+)").matcher(date);
            if( compile.find() ){
                date = compile.group(2)+"-01-"+compile.group(1)+" "+compile.group(3);
            }
            return date;
        }
    }

    static class AccessIP{
        private String ip ;
        private Integer n ;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AccessIP accessIP = (AccessIP) o;

            if (ip != null ? !ip.equals(accessIP.ip) : accessIP.ip != null) return false;
            return !(n != null ? !n.equals(accessIP.n) : accessIP.n != null);

        }

        @Override
        public int hashCode() {
            int result = ip != null ? ip.hashCode() : 0;
            result = 31 * result + (n != null ? n.hashCode() : 0);
            return result;
        }
    }

}
