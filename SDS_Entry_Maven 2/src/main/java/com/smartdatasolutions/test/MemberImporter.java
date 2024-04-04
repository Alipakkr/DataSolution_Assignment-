package com.smartdatasolutions.test;

import java.io.File;
import java.util.List;

public interface MemberImporter {

	public List< Member > importMembers( File inputFile ) throws Exception;

}
