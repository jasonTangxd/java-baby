package com.xxo.str;

import java.io.UnsupportedEncodingException;

/**
 * Created by TangXD on 2017/6/9.
 */
public class StringUtils {

    public static byte[] bytes2String(String str,String charsetName){
        try {
            return str.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
        }
        return null ;
    }


    public static byte[] bytes2String(String str){
        return str.getBytes() ;
    }



    public static String string2Bytes(byte[] bytes){
        return new String(bytes) ;
    }

    public static String string2Bytes(byte[] bytes,String charsetName){
        try {
            return new String(bytes,charsetName);
        } catch (UnsupportedEncodingException e) {
        }
        return null ;
    }

    public static void main(String[] args) {
        byte [] a1 = {55, 55, 98, 50, 53, 49, 100, 102, 97, 102, 102, 57, 98, 54, 97, 52, 102, 100, 57, 56, 101, 102, 97, 53, 51, 101, 56, 99, 98, 57, 98, 56, 0, 8, 48, 48, 48, 48};//CreditFetch
        byte [] b1 = {57, 49, 50, 57, 55, 50, 57, 98, 51, 57, 51, 48, 102, 57, 99, 52, 52, 51, 52, 54, 54, 51, 53, 49, 57, 100, 54, 55, 53, 56, 100, 97, 48, 48, 49, 50, 55, 52};//BillPageFetch
        byte [] c1 = {48, 48, 48, 48, 48, 48, 48, 49, 49, 56, 55, 50, 52, 54, 52, 49, 54, 51, 54, 49, 52, 57, 51, 49, 54, 55, 48, 53, 51, 48, 48, 48};//CarrierFetch
        byte [] c2 = {48, 48, 48, 48, 48, 48, 48, 49, 49, 51, 53, 53, 54, 51, 52, 54, 50, 49, 52, 49, 52, 56, 56, 50, 57, 56, 49, 53, 56, 48, 48, 48};//CarrierFetch
        System.out.println(string2Bytes(a1));
        System.out.println(string2Bytes(b1));
        System.out.println(string2Bytes(c1));
        System.out.println(string2Bytes(c2));
    }


}
