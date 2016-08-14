package com.gt.objects.traverse;

import com.gt.objects.Family;
import com.gt.objects.FamilyMember;

public interface Visitor {
	boolean visit(FamilyMember familyMember);
	boolean visit(Family family);
}
