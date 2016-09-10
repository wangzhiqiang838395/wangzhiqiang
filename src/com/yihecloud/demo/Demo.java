package com.yihecloud.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Demo {
	public void readZipFile(String file) throws Exception {
        ZipFile zf = new ZipFile(file);  
        InputStream in = new BufferedInputStream(new FileInputStream(file),1);
        ZipInputStream zin = new ZipInputStream(in); 
        ZipEntry ze;  
        String regex;
    	Pattern p;
    	Matcher m;
    	String str;
        while ((ze = zin.getNextEntry()) != null) {  
            if (ze.isDirectory()) {
            } else {  
                long size = ze.getSize();  
                if (size > 0) {  
                    BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze),"GB2312"),1);  
                    String line;  
                    while ((line = br.readLine()) != null) { 
                    	String[] strs=line.split(",");
                    	//主函数        
                        TreeMap<String,Integer> treemap=new TreeMap<String,Integer>();                                                                            
                        for (int i = 0; i < strs.length;i++) {                                                                                                                                                        
                                if(treemap.containsKey(strs[i])){                                                                                                                                                        
                                        treemap.put(strs[i], treemap.get(strs[i])+1);                                                                                                                
                                }else{
                                        treemap.put(strs[i],1);                                                                                                                                                                               
                                }
                        } 
                        //下面代码是用来实现对map集合中按照值排序                                                                                                                                                                                                                                                               
                        List<Map.Entry<String, Integer>> list =new ArrayList<Map.Entry<String, Integer>>(treemap.entrySet());                                
                        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {                           
                            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
                               return (o2.getValue() - o1.getValue());                                                                                                                        
                               }
                        });                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
                        System.out.println("出现最多次数的字符串是:"+list.get(0).getKey()+",出现次数是:"+list.get(0).getValue());
                        System.out.println("出现最多次数的字符串是:"+list.get(1).getKey()+",出现次数是:"+list.get(1).getValue());
                        System.out.println("出现最多次数的字符串是:"+list.get(2).getKey()+",出现次数是:"+list.get(2).getValue());
                        System.out.println("出现最多次数的字符串是:"+list.get(3).getKey()+",出现次数是:"+list.get(3).getValue());
                        System.out.println("出现最多次数的字符串是:"+list.get(4).getKey()+",出现次数是:"+list.get(4).getValue());
                        }
                    br.close();  
                }  
            }  
        }  
        zin.closeEntry();  
    }  
}
