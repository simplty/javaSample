package net.simplty.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 读取文件
 * @author zhaohan
 *
 */
public class FileReaderUtil {

	/**
	 * 读classpath下的文件
	 * @param fileName 文件名
	 * @param encode 编码格式 eg.UTF-8   GBK   ....
	 */
	public static void fileInClasspath(String fileName, String encode){
		 StringBuffer sb = new StringBuffer();
	        
        BufferedReader br = null;
        try {
        	InputStream is = FileReaderUtil.class.getClassLoader().getResourceAsStream(fileName);
        	br = new BufferedReader(new InputStreamReader(is, encode));

            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
                System.out.println(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        System.out.println("union string:"+sb.toString());
	}
	
	/**
	 * 如果程序最终达成jar包运行，根据相对路径读取文件
	 * eg.
	 * ----bin
	 * 		|---XXX.jar
	 * 		|---config
	 * 		
	 * 比如文件在jar包同级的文件夹里面
	 * 
	 * @param name
	 */
	public static void fileInPositvepath(){
		
		File confFile = new File("./config/IATA.json");
		String encode = "UTF-8";
		
		StringBuffer sb = new StringBuffer();
        
        BufferedReader br = null;
        try {
        	br = new BufferedReader(new InputStreamReader(new FileInputStream(confFile), encode));

            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
                System.out.println(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("union string:"+sb.toString());
	}
	
	
}
