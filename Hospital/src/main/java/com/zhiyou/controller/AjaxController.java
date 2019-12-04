package com.zhiyou.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

public class AjaxController {

	// ajax实现上传并回显
	@RequestMapping("/upload.do")
	@ResponseBody
	public String ajaxUpload(MultipartFile img, HttpServletRequest request) throws IOException {

		// 1.获得上传的对象
		// 2. 获得最终上传的目的地路径(上传至服务器中当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		// 2.1 将最终目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件是否存在
		if (file.exists()) {
			// 不存在则创建出
			file.mkdir();
		}
		// 2.2 获得文件名
		/*
		 * 文件名重复时不能重复上传文件
		 */
		String fileName = img.getOriginalFilename();
		System.out.println(fileName);
		/*
		 * 获得文件后缀名
		 */
		String[] split = fileName.split("\\.");
		System.out.println(Arrays.toString(split));
		String suffix = split[1];
		// 以当前毫秒值为文件名
		long prefix = new Date().getTime();
		// 组装文件名
		String newFileName = prefix + "." + suffix;
		System.out.println("新的文件名 : " + newFileName);
		System.out.println("文件名 : " + fileName);
		// 2.3 确定上传路径
		File newFile = new File(file, newFileName);
		// 3. 上传
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());
		/*
		 * /upload/xx.jpg
		 * 
		 * <img src="${}/upload/xx.jpg">
		 */
		// request.setAttribute("path", "/upload/"+newFileName);
		String path = "/upload/" + newFileName;

		return path;
	}

}
