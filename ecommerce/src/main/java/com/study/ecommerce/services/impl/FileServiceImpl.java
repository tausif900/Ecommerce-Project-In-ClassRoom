package com.study.ecommerce.services.impl;

import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

import com.study.ecommerce.services.FileService;

public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(MultipartFile file, String path) {
		
		String filename = file.getOriginalFilename();
		
//		retrieving the extention
		String extension = filename.substring(filename.lastIndexOf('.'));
		
		return null;
	}

	@Override
	public InputStream getResource(String path, String name) {

		return null;
	}

}
