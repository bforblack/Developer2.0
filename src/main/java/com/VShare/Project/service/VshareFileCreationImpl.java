package com.VShare.Project.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.VShare.Project.dal.NewDataEntry;
import com.VShare.Project.modal.VshareData;
@Service
@Transactional
public class VshareFileCreationImpl implements VshareFileCreationService {
@Autowired
private NewDataEntry newDataEntry;

	
	private static final String folder ="F:\\VshareDataPath\\";
	private static final Logger logger = Logger.getLogger(VshareFileCreationImpl.class);
	
	
	@Override
	public String fileCreation(VshareData vshare) {
	
		Path path = Paths.get(folder+vshare.getUserName());
		try {
			Files.createDirectories(path);
		}catch (Exception e) {
		System.out.println(e);
		}
		newDataEntry.createDataEntry(vshare);

	return newDataEntry.lastInsetedId();
	}




}
