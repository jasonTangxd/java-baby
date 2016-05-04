package cn.xxo.momo.work;

/**
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class Test8 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        互换前：
//        1 2 3
//        4 5 6
//        7 8 9
//        互换后
//        1 4 7
//        2 5 8
//        3 6 9
        // 00 = 1
        // 01 = 2
        // 02 = 3

        //10 = 4
        //11 = 5
        //12 = 6

        //20 = 7
        //21 = 8
        //22 = 9

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                int tem = arr[i][j] ;
                arr[i][j] = arr[j][i] ;
                arr[j][i] =tem ;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
