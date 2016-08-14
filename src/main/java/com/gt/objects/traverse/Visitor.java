package com.gt.objects.traverse;

import com.gt.objects.Family;
import com.gt.objects.FamilyNode;

public interface Visitor {
	boolean visit(FamilyNode familyNode);
	boolean visit(Family family);
}
