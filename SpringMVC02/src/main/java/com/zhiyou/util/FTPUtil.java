package com.zhiyou.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUtil {
    
	public static String upload2(InputStream input,String filename) {
		filename=System.currentTimeMillis()+filename;
		
		//1:实例化ftpClient
		FTPClient ftp = new FTPClient();
		String url = "ftp://192.168.124.60/";
		//2:连接服务器
		try {
			//3:根据账号密码登录服务器
			ftp.connect("192.168.124.60");
			ftp.login("admin", "123");
			ftp.enterLocalActiveMode();
			//4:设置文件上传到服务器的位置
			ftp.changeWorkingDirectory("/");
			//5:设置文件的类型
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			//6:上传文件
			ftp.storeFile(filename, input);
			return url+filename;
			
		} catch (SocketException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ftp.logout();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
}
