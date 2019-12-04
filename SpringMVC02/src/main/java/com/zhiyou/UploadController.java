package com.zhiyou;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.util.FTPUtil;


@Controller
public class UploadController {
    
/*	@RequestMapping("upload.do")
	public String upload(MultipartFile file123,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//文件类型
		System.out.println(file123.getContentType());
		//文件大小
		System.out.println(file123.getSize());
		//文件名称
		System.out.println(file123.getName());
		//文件原始名称
		System.out.println(file123.getOriginalFilename());
		
		//通过文件打开一个输入流
		InputStream in = file123.getInputStream();
		
		//指定文件存放的路径及文件名称
		String name = "D:/"+System.currentTimeMillis()+file123.getOriginalFilename();
		FileOutputStream out = new FileOutputStream(name);
		//使用io工具放入输入流 输出流,让其自动实现文件copy
		IOUtils.copy(in, out);
		System.out.println("需要存放到数据库的是文件的路径和名称  "+name);
		in.close();
		out.close();
		return null;
		
	}*/
	
	
	@RequestMapping("upload.do")
	public String upload2(MultipartFile file123,HttpServletRequest req,HttpServletResponse resp) throws IllegalStateException, IOException {
		String name = "D:/"+System.currentTimeMillis()+file123.getOriginalFilename();
		file123.transferTo(new File(name));
		return null;
	}
	
	@RequestMapping("download.do")
	public String download(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		// 接收客户需要下载的图片名字,使用服务器地址拼接上名字,组成图片路径
		String n = "C:\\Users\\Administrator\\Desktop\\"+name;
		System.out.println(n);
		//根据图片路径打开一个流
		FileInputStream in = new FileInputStream(n);
		//设置响应头信息,指定为文件下载
		resp.setHeader("content-disposition","attachment;filename=11.jpg");
		
		//根据响应获得一个输出流
		ServletOutputStream outputStream = resp.getOutputStream();
	
		//拷贝图片
		IOUtils.copy(in, outputStream);
		outputStream.close();
		in.close();
		return null;
	}
	
	
	@RequestMapping("upload2.do")
	public String upload3(MultipartFile file123,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println(FTPUtil.upload2(file123.getInputStream(), file123.getOriginalFilename()));
		return null;
		
	}
}
