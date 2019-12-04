package com.zhiyou.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class FastDFSUtil {
	
	/*
	 * 1.依赖/ jar
	 * 2.FastDFS 配置文件:
	 * 3.javaapi
	 * 		加载配置文件
	 * 		创建Tracker客户端
	 * 		通过Tracker客户端得到tracker对象
	 * 		通过Tracker得到Storage客户端
	 * 		创建文件属性存储对象
	 * 		通过客户端执行上传
	 */
	@Test    //上传
	public  static String upload(MultipartFile img) throws IOException, MyException {
		
		// 获得文件名
		String fileName = img.getOriginalFilename();
		// 获得后缀
		String[] split = fileName.split("\\.");
		String suffix = split[1];
		
		
//		加载配置文件
		// 绝对路径
		ClientGlobal.init("D:\\java-wang2\\HIS\\src\\main\\resources\\fastdfs-client.properties");
//		创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
//		通过Tracker客户端得到tracker对象
		TrackerServer connection = trackerClient.getConnection();
//		通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
//		创建文件属性存储对象
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName",fileName);
//		通过客户端执行上传
		// 参数1 文件的地址: 绝对路径   参数2 文件类型     参数3 文件属性对象数组
		
		String fid = storageClient1.upload_file1(img.getBytes(), suffix, list);
		System.out.println("上传成功"+fid);	
		String path = "http://java2101:80/"+fid;
		
		return path;
	}
	@Test	//下载
	public void download(String path) throws IOException, MyException {
	//	String fid="group1/M00/00/00/wKhGgF2IrpmAKMg4AAyc1A2vDCg539.jpg";
//		加载配置文件
		ClientGlobal.init("D:\\java-wang2\\HIS\\src\\main\\resources\\fastdfs-client.properties");
//		创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
//		通过Tracker客户端得到tracker对象
		TrackerServer connection = trackerClient.getConnection();
//		通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		byte[] bytes = storageClient1.download_file1( path);
		OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\56.jpg");
		out.write(bytes);
		out.close();
		System.out.println("下载成功");
		
	}

}
