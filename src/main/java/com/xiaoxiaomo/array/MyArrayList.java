package com.xiaoxiaomo.array;

/**
 * 实现数组
 * Created by xiaoxiaomo on 2012/4/4.
 */
public class MyArrayList<E> {

    private Object[] list ;//定义一个数组

    private int size ;//现有元素长度

    /**
     * 通过构造参数，初始化数组长度
     * @param initSize 初始化长度
     */
    public MyArrayList(int initSize){

        //如果小于0就抛出一个非法参数异常！
        if( initSize < 0 )
            throw new IllegalArgumentException("非法参数: "+initSize+"，必须大于0！");

        //初始化数组长度
        list = new Object[initSize] ;
    }

    /**
     * 无参构造函数
     */
    public MyArrayList(){
        //默认指定长度为20
        this(20) ;
    }


    /**
     * 添加一个元素
     * @param e
     * @return
     */
    public boolean add(E e){

        // 1. 创建一个新的数组
        size ++ ; //新增一个元素，总元素长度加1
        Object[] alter = new Object[size] ;

        // 2. 复制元素到新数组
        System.arraycopy(list, 0, alter, 0, size-1);

        // 3. 把新元素添加到新数组
        alter[size-1] = e ;

        // 4. 更新数组
        list = alter ;
        return true ;
    }

    /**
     * 移除数组元素
     * @param obj
     * @return
     */
    public Object remove(Object obj){

        // 1. 获取元素下标
        int index = indexOf( list , obj) ;

        //如果不存在该元素返回null
        if( index == -1 ) return null ;

        // 2. 创建一个新的数组
        size -- ; //移除一个元素，总元素长度减1
        Object[] alter = new Object[size] ;

        // 3. 复制数组左边到新数组
        if( index > 0 )
            System.arraycopy(list, 0, alter, 0, index);

        // 4. 复制数组右边到新数组
        if( index < size )
            System.arraycopy(list, index + 1, alter, index, size-index);

        // 5. 更新数组
        list = alter ;
        return obj ;
    }


    /**
     * 添加集合
     * @param array
     * @return
     */
    public boolean addAll(MyArrayList<? extends E> array){
        if( array.isEmpty() ){
            throw new IllegalArgumentException("非法参数: 数组为空！");
        }

        // 1. 创建一个新的数组
        int index = size ; // 之前数组长度
        size += array.size(); //总元素长度加上新长度

        Object[] alter = new Object[size] ;

        // 2. 复制之前数组到数组左边
        System.arraycopy(list, 0, alter, 0, index);

        // 3. 复制新数组到数组右边
        if( index < size )
            System.arraycopy(array.list, 0 , alter, index, size-index);

        // 4. 更新数组
        list = alter ;
        return true ;
    }

    /**
     * 获取数组元素
     * @param index
     * @return
     */
    public Object get(int index){

        //如果小于0就抛出一个非法参数异常！
        if( index < 0 )
            throw new IllegalArgumentException("非法参数: "+index+"，必须大于0！");

        //如果获取下表大于了数组长度-1，则表示数组越界
        if( index > size-1 )
            throw new ArrayIndexOutOfBoundsException("数组下标越界 "+index+"，不能大于"+(size-1));

        return list[index] ;
    }


    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0 ? true : false ;
    }

    /**
     * 数组长度
     * @return
     */
    public int size(){
        return size ;
    }

    /**
     * 获取某个对象在数组中的元素位置
     * @param obj
     * @param o
     * @return 存在返回下表，不存在返回-1
     */
    private int indexOf(Object[] obj,Object o){
        for( int i = 0; i < obj.length; i++ ){
            if(obj[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    //Test
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>() ; // 添加
        list.add("abv") ;
        list.add("aaa") ;
        list.add("cccc") ;
        list.add("123c") ;
        list.add("tfc") ;
        list.add("yhn");
        list.add("uuuu") ;

        System.out.println("==========移除元素："+list.remove("123c")); ;  // 移除

        MyArrayList<String> list2 = new MyArrayList<String>(); // 添加
        list2.add("哈哈哈哈") ;
        list2.add("嘿嘿") ;

        System.out.println("==========移除元素：" + list.remove("fsfsdfsdfsd") ); ;  // 移除

        list.addAll(list2) ;  //添加数组

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.list[i]);
        }


        System.out.println(list.get(2));  //获取元素

    }

}
