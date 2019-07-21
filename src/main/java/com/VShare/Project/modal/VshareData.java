package com.VShare.Project.modal;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VshareData implements Serializable {

private static final Long serializableId = 1L;
@Id
private String id;
private String userName;
private String remoteFilePath;
private String fileName;
private String localFilepath;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getRemoteFilePath() {
	return remoteFilePath;
}
public String getLocalFilepath() {
	return localFilepath;
}
public void setLocalFilepath(String localFilepath) {
	this.localFilepath = localFilepath;
}
public void setRemoteFilePath(String remoteFilePath) {
	this.remoteFilePath = remoteFilePath;
}

}
