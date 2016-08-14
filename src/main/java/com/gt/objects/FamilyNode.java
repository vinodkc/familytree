package com.gt.objects;

import com.gt.objects.traverse.Visitor;

public interface FamilyNode {
	public enum GENDER {
		MALE, FEMALE;
	}

	void print();

	Boolean accept(Visitor visitor);

	String getName();

}
