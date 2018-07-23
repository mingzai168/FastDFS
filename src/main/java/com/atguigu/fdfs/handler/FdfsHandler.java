package com.atguigu.fdfs.handler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FdfsHandler {
	
/*	@Autowired
	private StorageClient storageClient;*/
	
	
/*	@RequestMapping("/upload")
	public String upload(@RequestParam("picture") MultipartFile picture, Model model) throws IOException, MyException {
		
		if(!picture.isEmpty()) {
			
			byte[] bytes = picture.getBytes();
			
			String originalFilename = picture.getOriginalFilename();
			
			String extName = originalFilename.substring(originalFilename.indexOf(".")+1);
			
			String[] results = storageClient.upload_file(bytes, extName, null);
			
			String groupName = results[0];
			String fileName = results[1];
			
			model.addAttribute("picturePath", "http://192.168.159.135/"+groupName+"/"+fileName);
		}
		
		return "result";
	}*/
	@RequestMapping("/upload")
	public String uploadTest(@RequestParam("picture") MultipartFile picture) throws IOException {
		
		if(!picture.isEmpty()) {
			
			InputStream inputStream = picture.getInputStream();
			
			String filename = picture.getOriginalFilename();
			
			FileOutputStream outputStream = new FileOutputStream("D:\\upload\\"+filename);
			
			byte[] buffer = new byte[1024*1024];
			
			int len = 0;
			
			while((len = inputStream.read(buffer)) != -1) {
				
				outputStream.write(buffer, 0, len);
				
			}
			
			outputStream.close();
		}
		//Ìø×ªÒ³Ãæ
		return "result";
	}

	
}
