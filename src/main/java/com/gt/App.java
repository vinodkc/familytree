package com.gt;

import com.gt.objects.Family;
import com.gt.objects.FamilyMember;
import com.gt.objects.FamilyNode.GENDER;
import com.gt.objects.FamilyTree;

public class App {
	public static void main(String[] args) {

		Family family = new Family(new FamilyMember("kingShan", GENDER.MALE),
				new FamilyMember("queenAnga", GENDER.FEMALE));
		FamilyTree familyTree = new FamilyTree(family);

		fillFamily(familyTree);

		//familyTree.printTree();
		//familyTree.findRelation("Ish", "Brothers");
		familyTree.findRelation("ish", "Brothers");
	}

	private static void fillFamily(FamilyTree familyTree) {
		FamilyMember ish = new FamilyMember("Ish", GENDER.MALE);
		familyTree.addFamilyMember(ish, "queenAnga");

		FamilyMember chit = new FamilyMember("Chit", GENDER.MALE);
		familyTree.addFamilyMember(chit, "kingShan");
		FamilyMember ambi = new FamilyMember("Ambi", GENDER.FEMALE);
		familyTree.addSpouse(ambi, "Chit");

		FamilyMember vich = new FamilyMember("Vich", GENDER.MALE);
		familyTree.addFamilyMember(vich, "kingShan");
		FamilyMember lika = new FamilyMember("Lika", GENDER.FEMALE);
		familyTree.addSpouse(lika, "Vich");
		
		FamilyMember chika = new FamilyMember("Chika", GENDER.FEMALE);
		familyTree.addFamilyMember(chika, "Lika");
		FamilyMember kpila = new FamilyMember("Kpila", GENDER.MALE);
		familyTree.addSpouse(kpila, "chika");

		FamilyMember satya = new FamilyMember("Satya", GENDER.FEMALE);
		familyTree.addFamilyMember(satya, "kingShan");
		FamilyMember vyan = new FamilyMember("Vyan", GENDER.MALE);
		familyTree.addSpouse(vyan, "Satya");

		FamilyMember drita = new FamilyMember("Drita", GENDER.MALE);
		familyTree.addFamilyMember(drita, "Chit");
		FamilyMember jaya = new FamilyMember("Jaya", GENDER.FEMALE);
		familyTree.addSpouse(jaya, "Drita");

		FamilyMember vrita = new FamilyMember("Vrita", GENDER.MALE);
		familyTree.addFamilyMember(vrita, "Chit");

		FamilyMember jata = new FamilyMember("Jata", GENDER.MALE);
		familyTree.addFamilyMember(jata, "Jaya");

		FamilyMember driya = new FamilyMember("Driya", GENDER.FEMALE);
		familyTree.addFamilyMember(driya, "Drita");

		FamilyMember mnu = new FamilyMember("Mnu", GENDER.MALE);
		familyTree.addSpouse(mnu, "Driya");

		FamilyMember vila = new FamilyMember("Vila", GENDER.MALE);
		familyTree.addFamilyMember(vila, "Vich");
		FamilyMember jnky = new FamilyMember("Jnky", GENDER.FEMALE);
		familyTree.addSpouse(jnky, "Vila");

		FamilyMember lavnya = new FamilyMember("Lavnya", GENDER.FEMALE);
		familyTree.addFamilyMember(lavnya, "vila");
		FamilyMember gru = new FamilyMember("Gru", GENDER.MALE);
		familyTree.addSpouse(gru, "Lavnya");

		FamilyMember satvy = new FamilyMember("Satvy", GENDER.FEMALE);
		familyTree.addFamilyMember(satvy, "Vyan");
		FamilyMember asva = new FamilyMember("Asva", GENDER.MALE);
		familyTree.addSpouse(asva, "Satvy");

		FamilyMember savya = new FamilyMember("Savya", GENDER.MALE);
		familyTree.addFamilyMember(savya, "Satya");
		FamilyMember krpi = new FamilyMember("Krpi", GENDER.FEMALE);
		familyTree.addSpouse(krpi, "Savya");

		FamilyMember kriya = new FamilyMember("Kriya", GENDER.MALE);
		familyTree.addFamilyMember(kriya, "Savya");

		FamilyMember saayan = new FamilyMember("Saayan", GENDER.MALE);
		familyTree.addFamilyMember(saayan, "Vyan");
		FamilyMember mina = new FamilyMember("Mina", GENDER.FEMALE);
		familyTree.addSpouse(mina, "Saayan");

		FamilyMember misa = new FamilyMember("Misa", GENDER.FEMALE);
		familyTree.addFamilyMember(misa, "Mina");
	}

}
