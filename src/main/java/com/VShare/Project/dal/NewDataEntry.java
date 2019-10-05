package com.VShare.Project.dal;

import com.VShare.Project.modal.VshareData;

public interface NewDataEntry {
void createDataEntry(VshareData vsharedata);
String lastInsetedId();
}