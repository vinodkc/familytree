package com.gt;

import com.gt.misc.Utils;
import com.gt.objects.Family;
import com.gt.objects.FamilyMember;
import com.gt.objects.FamilyNode.GENDER;
import com.gt.objects.FamilyTree;

public class App {
	public static void main(String[] args) {
		FamilyTree familyTree = Utils.createFamilyTree();

		for (String name : familyTree.findRelation("ish", "Brothers")) {
			System.out.print(name+ " ");
		}
	}
}
