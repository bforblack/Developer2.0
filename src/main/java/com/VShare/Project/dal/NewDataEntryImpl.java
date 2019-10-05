package com.VShare.Project.dal;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.VShare.Project.modal.VshareData;
import com.mongodb.BasicDBObject;

@Repository
public class NewDataEntryImpl implements NewDataEntry {
private Logger logger = Logger.getLogger(NewDataEntryImpl.class); 
	
@Autowired	
private MongoTemplate mongotemplate;

private String id;

@Override
public void createDataEntry(VshareData vsharedata) {
	
		BasicDBObject obj = new BasicDBObject("userName",vsharedata.getUserName());
	mongotemplate.save(vsharedata);
	 //ObjectId id = (ObjectId)doc.get( "_id" );
	final ObjectId objectid =obj.getObjectId("_id");
	this.id=objectid.toString();
	}

	@Override
	public String lastInsetedId() {
		
		return id;
	}


}
