package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;

import java.io.IOException;
import java.io.Writer;

public class MemberExporterImpl implements MemberExporter {

	@Override
	public void writeMember( Member member, Writer writer ) throws IOException {
		writer.write( member.toCSVString( ) );
		writer.write( System.lineSeparator( ) );
	}

}
