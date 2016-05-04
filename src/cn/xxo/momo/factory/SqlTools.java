package cn.xxo.momo.factory;

/**
 *需求：有一个功能，对数据库进行操作
 *mysql和oracle：关系型数据库 SQL
 *非关系型数据库NOSQL
 *
 *前期数据是mysql
 *添加，删除
 *
 *后期要操作oracle
 *添加，删除
 * Created by Jason on 2016/3/23.
 */
public class SqlTools {

    public static void main(String[] args){
        MysqlTools mysql = (MysqlTools) Tools.getInstance("Mysql") ;
        mysql.add();
        mysql.del();
    }
}


/**
 * mysql工具类
 */
class MysqlTools extends FactorySqlTools{

    public void add(){
        System.out.println("mysql添加数据");
    }

    public void del(){
        System.out.println("mysql删除数据");
    }
}

/***
 * oracle工具类
 */
class OracleTools extends FactorySqlTools{

    public void add(){
        System.out.println("oracle添加数据");
    }

    public void del(){
        System.out.println("oracle删除数据");
    }
}

/**
 * 抽象类
 * 提取公共方法
 */
abstract class FactorySqlTools{
    public abstract void add() ;
    public abstract void del() ;
}

/**
 * 一个静态的工厂
 */
class Tools{

    /**
     * 通过传入参数
     * 工厂生产出相应的实例
     * @param name
     * @return
     */
    public static FactorySqlTools getInstance( String name ){
        if(  name != null && name.equals("Mysql") ){
            return new MysqlTools() ;
        }

        else {
            return new OracleTools() ;
        }
    }

}
