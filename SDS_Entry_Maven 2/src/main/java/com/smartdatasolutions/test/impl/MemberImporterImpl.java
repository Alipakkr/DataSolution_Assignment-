package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) throws Exception {

		List<Member> importedMembers = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Member member = createMemberFromData(data);
				importedMembers.add(member);
			}
		}

		return importedMembers;
	}

	private Member createMemberFromData(String[] data) {
		Member member = new Member();
		member.setId(data[0]);
		member.setAddress(data[1]);
		member.setCity(data[2]);
		member.setFirstName(data[3]);
		member.setLastName(data[4]);
		member.setState(data[5]);
		member.setZip(data[6]);
		return member;
	}
}
