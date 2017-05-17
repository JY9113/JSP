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
	
	// servelt-context.xml 파일에 설정된 문자열 리소스를 주입(inject)
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/upload", 	method = RequestMethod.GET)
	public void uploadGet() {
		logger.info("uploadGet() 호출");
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadPost(MultipartFile file, Model model) {
		logger.info("uploadPost() 호출");
		logger.info("파일 이름: " + file.getOriginalFilename());
		logger.info("파일 크기: " + file.getSize());
		
		String savedFile = saveUploadFile(file);
		model.addAttribute("savedFile", savedFile);
	} // end uploadPost()
	
	private String saveUploadFile(MultipartFile source) {
		// UUID: 업로드하는 파일 이름이 중복되지 않도록 
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "_" + source.getOriginalFilename();
		File target = new File(uploadPath, savedName);
		try {
			FileCopyUtils.copy(source.getBytes(), target);
			logger.info("파일 저장 성공: " + savedName);
			
			return savedName;
		} catch (IOException e) {
			logger.error("파일 저장 실패");
			
			return null;
		}
		
	} // end saveUploadFile()
	
	@RequestMapping(value="/upload2", method = RequestMethod.POST)
	public String uploadPost2(MultipartFile[] files, Model model){
		logger.info("uploadPost2() 호출, 파일 개수 = " + files.length);
		
		String result = "";
		for(MultipartFile f : files) {
			result += saveUploadFile(f) + " ";
		}
		model.addAttribute("savedFile", result);
		return "upload";
	}
	
	  
	@RequestMapping(value="upload-ajax", method=RequestMethod.GET)
	public void uploadAjaxGet() {
		logger.info("uploadAjaxGet(); 호출");
		
	}
	
	@RequestMapping(value="upload-ajax", method=RequestMethod.POST)
	@ResponseBody 
	// ResponseBody : view를 거치지 않고, 내가 만든 object를 바로 client로 보내겠다
	public ResponseEntity<String> uploadAjaxPost(MultipartFile[] files) {
		logger.info("uploadAjaxPost(); 호출");
		/*
		String result = "";
		for(MultipartFile f : files) {
			logger.info(f.getOriginalFilename());
			result += saveUploadFile(f) + " ";
		}
		*/		
		// file은 하나만 저장
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
		logger.info("display(); 호출");
		
		// ResponseEntity : 리턴 타입
		ResponseEntity<byte[]> entity = null;
		
		// header 채우기
		// InputStream : 저장된 파일 스트림
		InputStream in = null;
		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);
		
		// 파일 확장자 가져오기 : response를 보낼 때, response Header에 contentType(ex. image/jpeg...)을 설정해야 하기 때문
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));
		
		// ResponseEntity 객체 생성
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), httpHeaders, HttpStatus.OK);
		// IOUtisl.toByteArray(in) : 파일에서 읽은 데이터
		// httpHeaders : 응답 헤더
		// HttpStatus.OK : 응답 코드
		return entity;
	}
} // end class FileUploadController