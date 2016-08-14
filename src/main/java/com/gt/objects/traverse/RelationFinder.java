package com.gt.objects.traverse;

import java.util.List;



public class RelationFinder extends MemberFetcherVisitor {

	public RelationFinder(String memberName, String releationName) {
		super(memberName);
		// TODO Auto-generated constructor stub
	}

	public List<String> getBrothers() {
		List<String> names = this.getFamilyMember().getFather().getFamily()
				.getBrotherNames(this.getFamilyMember());
		return names;
		
	}

}
