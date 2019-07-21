package com.VShare.Project.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.VShare.Project.Shareable.VsharePojo;
import com.VShare.Project.modal.VshareData;
import com.VShare.Project.service.VshareFileCreationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;





@RestController
@RequestMapping(value="/")
public class VshareController {
private final Logger logger = Logger.getLogger(VshareController.class);

@Autowired
VshareFileCreationService vshareFileCreationService;

@RequestMapping(value="uploadEntryProcess" , method = RequestMethod.POST  )
//public void uploadEntryProcess(@RequestParam(value="userName") String  userName,@RequestParam(value="remoteFilePath") String remoteFilePath,@RequestParam(value="fileName")String fileName,@RequestParam(value="localFilepath")String localFilepath) {
public void uploadEntryProcess(@RequestBody VshareData vshare ) {
	
	/*VshareData vshare = new VshareData();
	vshare.setFileName(fileName);
	vshare.setLocalFilepath(localFilepath);
	vshare.setRemoteFilePath(remoteFilePath);
	vshare.setUserName(userName);*/
	vshareFileCreationService.fileCreation(vshare);
}

@RequestMapping(value="communicate",method= { RequestMethod.POST,RequestMethod.GET})
public Long communicate(@RequestBody String vshare ) throws JsonParseException, JsonMappingException, IOException {
	VsharePojo vsharepojo = new VsharePojo();
	ObjectMapper mapper = new ObjectMapper();
	vsharepojo=mapper.readValue(vshare, VsharePojo.class);
	String name = vsharepojo.getUserName();
System.out.println("==========This is your Vshare PojoData===========/n"+vsharepojo.getFolderName()+"/n"+vsharepojo.getRemoteFilePath());
return 1234L;
}

}
