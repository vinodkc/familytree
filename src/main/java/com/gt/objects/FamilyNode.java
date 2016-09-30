package com.gt.objects;

import com.gt.objects.traverse.Visitor;

public interface FamilyNode {
	enum GENDER {
		MALE, FEMALE;
	}

	void print();

	Boolean accept(Visitor visitor);

	String getName();

}
