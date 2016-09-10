package com.yihecloud.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DemoMain {

	public static void main(String[] args) {
        Demo dm=new Demo();
    try {
    	BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("请输入文件路径：");  
        String str = strin.readLine();
        if(str!=null){
            dm.readZipFile(str);
        }
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
}
