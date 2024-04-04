package com.smartdatasolutions.test;

import java.io.IOException;
import java.io.Writer;

public interface MemberExporter {

	public void writeMember( Member member, Writer writer ) throws IOException;

}
