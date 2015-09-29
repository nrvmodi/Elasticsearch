package com.nirav.elasticsearch.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirav.elasticsearch.document.File;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;
	
	public List<File> findByName(String name){
		return fileRepository.findByName(name);
	}
	
}
