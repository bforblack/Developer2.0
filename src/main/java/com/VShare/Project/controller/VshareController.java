package com.VShare.Project.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.VShare.Project.modal.VshareData;
import com.VShare.Project.service.VshareFileCreationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;







@RestController
@RequestMapping(value="/")
public class VshareController {
private final Logger logger = Logger.getLogger(VshareController.class);

@Autowired
private VshareFileCreationService vshareFileCreationService;



@RequestMapping(value="uploadEntryProcess" , method = RequestMethod.POST  )
//public void uploadEntryProcess(@RequestParam(value="userName") String  userName,@RequestParam(value="remoteFilePath") String remoteFilePath,@RequestParam(value="fileName")String fileName,@RequestParam(value="localFilepath")String localFilepath) {
public void uploadEntryProcess(@RequestBody final VshareData vshare ) {
	
	vshareFileCreationService.fileCreation(vshare);
}

@RequestMapping(value="communicate",method= { RequestMethod.POST,RequestMethod.GET})
public JsonObject communicate(@RequestBody final String vshare ) throws  JSONException, JsonParseException, JsonMappingException, IOException {
	
	Gson g  = new GsonBuilder().create();
VshareData vshareData =g.fromJson(vshare,VshareData.class);
	
System.out.println("This is your Main class"+vshareData.getUserName());
JsonObject jsonObject = new JsonObject();
vshareFileCreationService.fileCreation(vshareData);
jsonObject.addProperty("vShareId", vshareFileCreationService.fileCreation(vshareData));
return jsonObject;
}

}
