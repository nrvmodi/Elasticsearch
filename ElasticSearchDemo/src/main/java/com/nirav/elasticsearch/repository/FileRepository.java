package com.nirav.elasticsearch.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nirav.elasticsearch.document.File;

public interface FileRepository extends ElasticsearchRepository<File, Serializable>{

	public List<File> findByName(String name);
}
