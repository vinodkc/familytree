package com.gt.objects.traverse;

import com.gt.objects.Family;
import com.gt.objects.FamilyMember;

public class MemberFetcherVisitor implements Visitor {
	private FamilyMember familyMember;
	private String memberName;

	public MemberFetcherVisitor(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public boolean visit(FamilyMember familyMember) {
		if (familyMember.getName().equalsIgnoreCase(memberName)) {
			this.familyMember = familyMember;
			return true;
		} else {
			return false;
		}

	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	@Override
	public boolean visit(Family family) {
		return false;
	}

}
