package com.xxo.day20.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 单词  出现次数
 * hashmap
 * 
 * @author xiaoxiaomo
 *
 */
public class Demo10 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("e:\\myjava\\test.log"))));
		HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
		String line = null;
		while((line=br.readLine())!=null){
			String[] words = line.split(" ");
			for (String word : words) {
				Integer count = hashMap.get(word);
				if(count==null){
					count=0;
				}
				count++;
				hashMap.put(word, count);
			}
		}
		br.close();
		
		Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		
	}
	
	

}
