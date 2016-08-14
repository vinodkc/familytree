package com.gt.objects;

import com.gt.objects.traverse.Visitor;

public class FamilyMember implements FamilyNode {
	private String name;
	private GENDER gender;
	private FamilyMember mother;
	private FamilyMember father;
	private Family family;

	public FamilyMember getMother() {
		return mother;
	}

	public void setMother(FamilyMember mother) {
		this.mother = mother;
	}

	public FamilyMember getFather() {
		return father;
	}

	public void setFather(FamilyMember father) {
		this.father = father;
	}

	private FamilyMember spouse;

	public FamilyMember(String name, GENDER gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "FamilyMember [name=" + name + ", gender=" + gender + ", "
				+ getMotherName() + "," + getFatherName() + ","
				+ getSpouseName() + family + "]";
	}

	private String getMotherName() {
		if (null != mother) {
			return "mother =" + mother.getName();
		}
		return "";
	}

	private String getFatherName() {
		if (null != father) {
			return "father =" + father.getName();
		}
		return "";
	}

	private String getSpouseName() {
		if (null != spouse) {
			return "spouse =" + spouse.getName();
		}
		return "";
	}

	public void setName(String name) {
		this.name = name;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	@Override
	public void print() {
		System.out.println(this);

	}

	public FamilyMember getSpouse() {
		return spouse;
	}

	public void setSpouse(FamilyMember spouse) {
		this.spouse = spouse;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	@Override
	public Boolean accept(Visitor visitor) {
		return visitor.visit(this);

	}

}
