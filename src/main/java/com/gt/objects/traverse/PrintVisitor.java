package com.gt.objects.traverse;

import com.gt.objects.Family;
import com.gt.objects.FamilyNode;

public class PrintVisitor implements Visitor {

	@Override
	public boolean visit(FamilyNode familyNode) {
		System.out.println(familyNode);
		return false;
	}

	@Override
	public boolean visit(Family family) {
		System.out.println(family);
		return false;
	}

}
