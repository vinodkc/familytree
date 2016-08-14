package com.gt.objects.traverse;

import com.gt.objects.Family;
import com.gt.objects.FamilyMember;

public class PrintVisitor implements Visitor {

	@Override
	public boolean visit(FamilyMember familyMember) {
		System.out.println(familyMember);
		return false;
	}

	@Override
	public boolean visit(Family family) {
		System.out.println(family);
		return false;
	}

}
