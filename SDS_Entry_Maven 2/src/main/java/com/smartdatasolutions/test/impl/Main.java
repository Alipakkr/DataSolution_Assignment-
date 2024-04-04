package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter() {
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter() {
		return new MemberImporterImpl();
	}

	@Override
	protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
		return membersFromFile;
	}

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
		Map<String, List<Member>> membersByState = new HashMap<>();
		for (Member member : validMembers) {
			String state = member.getState();
			if (!membersByState.containsKey(state)) {
				membersByState.put(state, new ArrayList<>());
			}
			membersByState.get(state).add(member);
		}
		return membersByState;
	}

	public static void main(String[] args) {
		Main main = new Main();
		try {
			File inputFile = new File("input.csv");
			String outputFilePath = "output";
			String outputFileName = "members.csv";
			main.convert(inputFile, outputFilePath, outputFileName);
			System.out.println("Conversion successfully done!!! .");
		} catch (Exception e) {
			System.err.println("Opps! there is an error  " + e.getMessage());
		}
	}
}