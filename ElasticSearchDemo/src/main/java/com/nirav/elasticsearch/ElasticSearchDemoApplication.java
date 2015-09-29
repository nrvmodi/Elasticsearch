package com.nirav.elasticsearch;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nirav.elasticsearch.document.File;
import com.nirav.elasticsearch.repository.FileRepository;

@SpringBootApplication
public class ElasticSearchDemoApplication implements CommandLineRunner {

	@Autowired
	private FileRepository fileRepository;

	private java.io.File dir = new java.io.File("/media/nimo/Professional");

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Collection<java.io.File> files = FileUtils.listFiles(dir, new RegexFileFilter("^(.*?)"),
				DirectoryFileFilter.DIRECTORY);

		fileRepository.deleteAll();
		if (CollectionUtils.isNotEmpty(files)) {
			Collection<File> fileList = new ArrayList<>();
			for (java.io.File file : files) {
				System.out.println(file.getName());
				File f = new File();
				f.setName(file.getName());
				f.setPath(file.getAbsolutePath());
				f.setSize(file.getTotalSpace());
				fileList.add(f);
			}
			fileRepository.save(fileList);
		}
	}
}
