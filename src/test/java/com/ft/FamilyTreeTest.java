package com.ft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gt.objects.Family;
import com.gt.objects.FamilyMember;
import com.gt.objects.FamilyNode.GENDER;
import com.gt.objects.FamilyTree;

public class FamilyTreeTest {

	private static FamilyTree familyTree;
    @BeforeClass
    public static void classSetup() {
    	Family family = new Family(new FamilyMember("kingShan", GENDER.MALE),
				new FamilyMember("queenAnga", GENDER.FEMALE));
		familyTree = new FamilyTree(family);

		fillFamily(familyTree);
    }

    @AfterClass
    public static void classTearDown() {
    }

    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testIshBrother() {
    	List<String> actual = familyTree.findRelation("ish", "Brothers");
    	List<String> expected = Arrays.asList( "Chit", "Vich" );
    	assertEquals("Brothers of ish are incorrect",expected,actual);
    }
    
    @Test
    public void testChitBrother() {
    	List<String> actual = familyTree.findRelation("Chit", "Brothers");
    	List<String> expected = Arrays.asList( "Ish", "Vich" );
    	assertEquals("Brothers of Chit are incorrect",expected,actual);
    }
    
    @Test
    public void testVichBrother() {
    	List<String> actual = familyTree.findRelation("Vich", "Brothers");
    	List<String> expected = Arrays.asList( "Ish", "Chit" );
    	assertEquals("Brothers of Vich are incorrect",expected,actual);
    }
    
    @Test
    public void testDritaBrother() {
    	List<String> actual = familyTree.findRelation("Drita", "Brothers");
    	List<String> expected = Arrays.asList( "Vrita" );
    	assertEquals("Brothers of Drita are incorrect",expected,actual);
    }
    
    @Test
    public void testJataBrother() {
    	List<String> actual = familyTree.findRelation("Jata", "Brothers");
    	assertTrue("Jata doesnot have brothers", actual.size() ==0);
    }
    
    @Test
    public void testSaayanBrother() {
    	List<String> actual = familyTree.findRelation("Saayan", "Brothers");
    	List<String> expected = Arrays.asList( "Savya" );
    	assertEquals("Brothers of Saayan are incorrect",expected,actual);
    }
    
    @Test
    public void testSavyaBrother() {
    	List<String> actual = familyTree.findRelation("Savya", "Brothers");
    	List<String> expected = Arrays.asList( "Saayan" );
    	assertEquals("Brothers of Saayan are incorrect",expected,actual);
    }
    
    @Test
    public void testVritaBrother() {
    	List<String> actual = familyTree.findRelation("Vrita", "Brothers");
    	List<String> expected = Arrays.asList( "Drita" );
    	assertEquals("Brothers of Saayan are incorrect",expected,actual);
    }
    @Test
    public void testSatvyBrother() {
    	List<String> actual = familyTree.findRelation("Satvy", "Brothers");
    	List<String> expected = Arrays.asList( "Savya", "Saayan" );
    	assertEquals("Brothers of Saayan are incorrect",expected,actual);
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