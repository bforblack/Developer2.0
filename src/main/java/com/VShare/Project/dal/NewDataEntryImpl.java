package com.VShare.Project.dal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.VShare.Project.modal.VshareData;

@Repository
public class NewDataEntryImpl implements NewDataEntry {
private Logger logger = Logger.getLogger(NewDataEntryImpl.class); 
	
@Autowired	
private MongoTemplate mongotemplate;
	
	@Override
	public void CreateDataEntry(VshareData vsharedata) {
	mongotemplate.save(vsharedata);
	}


}
