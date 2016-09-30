package com.gt.objects.traverse;

import java.util.ArrayList;
import java.util.List;

import com.gt.objects.Family;
import com.gt.objects.FamilyMember;

public class RelationFinder extends MemberFetcherVisitor {

	private final List<String> EMPTYLIST = new ArrayList<String>();

	public RelationFinder(String memberName) {
		super(memberName);
	}

	public List<String> getBrotherNames() {
		FamilyMember member = getFamilyMember();
        FamilyMember father;
		if (null != member && null != (father = member.getFather())) {
			return father.getFamily()
					.getBrotherNames(this.getFamilyMember());
		} else {
			return EMPTYLIST;
		}

	}

	public List<String> getSisterNames() {
		FamilyMember member = getFamilyMember();
        FamilyMember father;
		if (null != member && null != (father = member.getFather())) {
			return father.getFamily()
					.getSisterNames(this.getFamilyMember());
		} else {
			return EMPTYLIST;
		}
	}

	public List<String> getSonsNames() {
        FamilyMember member = getFamilyMember();
        Family family ;
        if (null != member && null != (family = member.getFamily())) {
            return family.getSonsNames();
        } else {
            return EMPTYLIST;
        }
	}

	public List<String> getDaughterNames() {
        FamilyMember member = getFamilyMember();
        Family family ;
        if (null != member && null != (family = member.getFamily())) {
            return family.getDaughtersNames();
        } else {
            return EMPTYLIST;
        }
	}

	public List<String> getChildrenNames() {
		FamilyMember member = getFamilyMember();
        Family family ;
		if (null != member && null != (family = member.getFamily())) {
			return family.getChildrensNames();
		} else {
			return EMPTYLIST;
		}
	}
}
