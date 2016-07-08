package com.xxo.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * URLDecoder和URLEncoder
 * Created by xiaoxiaomo on 2012/4/13.
 */
public class URLDEENcoder {
    public static void main(String[] args) {
        try {

            String encodeStr = URLEncoder.encode("小小默", "utf-8");
            System.out.println("编码:" + encodeStr);

            String decodeStr = URLDecoder.decode(encodeStr, "utf-8");
            System.out.println("解码:" + decodeStr);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
