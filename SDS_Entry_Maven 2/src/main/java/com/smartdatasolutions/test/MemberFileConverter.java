package com.smartdatasolutions.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public abstract class MemberFileConverter {
	/*
	 * NOTE: Do not modify this class
	 */
	protected abstract MemberExporter getMemberExporter( );

	protected abstract MemberImporter getMemberImporter( );

	protected abstract List< Member > getNonDuplicateMembers( List< Member > membersFromFile );

	protected abstract Map< String, List< Member >> splitMembersByState( List< Member > validMembers );

	public void convert( File inputMemberFile, String outputFilePath, String outputFileName ) throws Exception {

		/*
		 * Read :
		 */
		MemberImporter memberImporter = getMemberImporter( );
		List< Member > membersFromFile = memberImporter.importMembers( inputMemberFile );

		/*
		 * Filter :
		 */

		List< Member > validMembers = getNonDuplicateMembers( membersFromFile );
		Map< String, List< Member >> membersFilteredByState = splitMembersByState( validMembers );

		/*
		 * Write :
		 */
		for ( Map.Entry< String, List< Member >> map: membersFilteredByState.entrySet( ) ) {
			

			String state = map.getKey( );
			List< Member > membersPerState = map.getValue( );

			File outputFile = new File( outputFilePath + File.separator + state + "_" + outputFileName );

			MemberExporter exporter = getMemberExporter( );
			writeMembers( outputFile, exporter, membersPerState );

		}

	}

	private void writeMembers( File outputFile, MemberExporter exporter, List< Member > members ) throws IOException {
		Writer writer = new FileWriter( outputFile ,true);

		for ( Member member: members ) {
			exporter.writeMember( member, writer );
		}

		writer.flush( );
		writer.close( );
	}

}
