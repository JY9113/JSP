package edu.spring.ex05.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.ex05.util.FileUploadUtil;
import edu.spring.ex05.util.MediaUtil;

@Controller
public class FileUploadController {

	private static final Logger logger =
			LoggerFactory.getLogger(FileUploadController.class);
	
	// servelt-context.xml ���Ͽ� ������ ���ڿ� ���ҽ��� ����(inject)
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/upload", 	method = RequestMethod.GET)
	public void uploadGet() {
		logger.info("uploadGet() ȣ��");
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadPost(MultipartFile file, Model model) {
		logger.info("uploadPost() ȣ��");
		logger.info("���� �̸�: " + file.getOriginalFilename());
		logger.info("���� ũ��: " + file.getSize());
		
		String savedFile = saveUploadFile(file);
		model.addAttribute("savedFile", savedFile);
	} // end uploadPost()
	
	private String saveUploadFile(MultipartFile source) {
		// UUID: ���ε��ϴ� ���� �̸��� �ߺ����� �ʵ��� 
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "_" + source.getOriginalFilename();
		File target = new File(uploadPath, savedName);
		try {
			FileCopyUtils.copy(source.getBytes(), target);
			logger.info("���� ���� ����: " + savedName);
			
			return savedName;
		} catch (IOException e) {
			logger.error("���� ���� ����");
			
			return null;
		}
		
	} // end saveUploadFile()
	
	@RequestMapping(value="/upload2", method = RequestMethod.POST)
	public String uploadPost2(MultipartFile[] files, Model model){
		logger.info("uploadPost2() ȣ��, ���� ���� = " + files.length);
		
		String result = "";
		for(MultipartFile f : files) {
			result += saveUploadFile(f) + " ";
		}
		model.addAttribute("savedFile", result);
		return "upload";
	}
	
	  
	@RequestMapping(value="upload-ajax", method=RequestMethod.GET)
	public void uploadAjaxGet() {
		logger.info("uploadAjaxGet(); ȣ��");
		
	}
	
	@RequestMapping(value="upload-ajax", method=RequestMethod.POST)
	@ResponseBody 
	// ResponseBody : view�� ��ġ�� �ʰ�, ���� ���� object�� �ٷ� client�� �����ڴ�
	public ResponseEntity<String> uploadAjaxPost(MultipartFile[] files) {
		logger.info("uploadAjaxPost(); ȣ��");
		/*
		String result = "";
		for(MultipartFile f : files) {
			logger.info(f.getOriginalFilename());
			result += saveUploadFile(f) + " ";
		}
		*/		
		// file�� �ϳ��� ����
		String result = "";
		try {
			result = FileUploadUtil.saveUploadedFile(uploadPath, files[0].getOriginalFilename(), files[0].getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value="display", method=RequestMethod.GET)
	public ResponseEntity<byte[]> display(String fileName) throws IOException{
		logger.info("display(); ȣ��");
		
		// ResponseEntity : ���� Ÿ��
		ResponseEntity<byte[]> entity = null;
		
		// header ä���
		// InputStream : ����� ���� ��Ʈ��
		InputStream in = null;
		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);
		
		// ���� Ȯ���� �������� : response�� ���� ��, response Header�� contentType(ex. image/jpeg...)�� �����ؾ� �ϱ� ����
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));
		
		// ResponseEntity ��ü ����
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), httpHeaders, HttpStatus.OK);
		// IOUtisl.toByteArray(in) : ���Ͽ��� ���� ������
		// httpHeaders : ���� ���
		// HttpStatus.OK : ���� �ڵ�
		return entity;
	}
} // end class FileUploadController