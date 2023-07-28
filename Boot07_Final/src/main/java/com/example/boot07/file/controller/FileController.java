package com.example.boot07.file.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.boot07.file.dto.FileDto;
import com.example.boot07.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Controller
public class FileController {

	@Autowired
	private FileService service;
	
	@GetMapping("/file/list")
	public String list(HttpServletRequest request) {
		
		service.getList(request);
		
		return "file/list";
	}
	
	@GetMapping("/file/upload_form")
	public String uploadForm() {
		
		return "file/upload_form";
	}
	
	// 파일 업로드 요청처리 
	@PostMapping("/file/upload")
	public String upload(FileDto dto, Model model, HttpServletRequest request) {
		// FileDto 에는  폼전송되는 title 과 myFile 이 들어 있다.
		service.saveFile(dto, model, request);
		return "file/upload";
	}

	// 다운로드 해줄 파일의 번호가 요청 파라미터로 전달된다.
	@GetMapping("/file/download")
	public ResponseEntity<InputStreamResource> download(int num) throws FileNotFoundException, UnsupportedEncodingException {
		// 다운로드 해줄 파일의 번호를 서비스에 전달을 해서 ResponseEntity 객체를 얻어내서 리턴해준다.
		return service.getFileData(num);
	}
	
	@GetMapping("/file/delete")
	public String delete(int num, Model model, HttpServletRequest request) {
		service.deleteFile(num, request);
		return "redirect:/file/list";
	}	
}






