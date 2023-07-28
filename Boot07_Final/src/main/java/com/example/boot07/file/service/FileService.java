package com.example.boot07.file.service;

import javax.servlet.http.HttpServletRequest;

import com.example.boot07.file.dto.FileDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface FileService {
	// 파일 목록 얻어오기
	public void getList(HttpServletRequest request);
	// 업로드된 파일 저장하기
	public void saveFile(FileDto dto, Model model, HttpServletRequest request);
	// 다운로드 해줄 파일 하나의 정보 얻어오기
	public ResponseEntity<InputStreamResource> getFileData(int num) throws UnsupportedEncodingException, FileNotFoundException;
	// 파일 삭제하기
	public void deleteFile(int num, HttpServletRequest request);
}
