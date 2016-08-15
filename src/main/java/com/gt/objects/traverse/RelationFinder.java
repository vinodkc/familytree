package com.gt.objects.traverse;

import java.util.ArrayList;
import java.util.List;

import com.gt.objects.FamilyMember;

public class RelationFinder extends MemberFetcherVisitor {

	private final List<String> EMPTYLIST = new ArrayList<String>();

	public RelationFinder(String memberName, String releationName) {
		super(memberName);
		// TODO Auto-generated constructor stub
	}

	public List<String> getBrotherNames() {
		FamilyMember member = getFamilyMember();
		if (null != member && null != member.getFather()) {
			return member.getFather().getFamily()
					.getBrotherNames(this.getFamilyMember());
		} else {
			return EMPTYLIST;
		}

	}

	public List<String> getSisterNames() {
		FamilyMember member = getFamilyMember();
		if (null != member && null != member.getFather()) {
			return member.getFather().getFamily()
					.getSisterNames(this.getFamilyMember());
		} else {
			return EMPTYLIST;
		}
	}

	public List<String> getSonsNames() {
		FamilyMember member = getFamilyMember();
		if (null != member && null != member.getFamily()) {
			return member.getFamily().getSonsNames();
		} else {
			return EMPTYLIST;
		}
	}

	public List<String> getDaughterNames() {
		FamilyMember member = getFamilyMember();
		if (null != member && null != member.getFamily()) {
			return member.getFamily().getDaughtersNames();
		} else {
			return EMPTYLIST;
		}
	}

}
