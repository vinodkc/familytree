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

import com.gt.misc.Utils;
import com.gt.objects.FamilyMember;
import com.gt.objects.FamilyTree;

public class FamilyTreeTest {

    private static FamilyTree familyTree;

    @BeforeClass
    public static void classSetup() {
        familyTree = Utils.createFamilyTree();
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

    /*****************************
     * Start Find member Test
     *********************************************/

    @Test
    public void findIsh() {
        FamilyMember actual = familyTree.findFamilyMember("Ish");
        assertEquals("Ish exists but not found", "Ish", actual.getName());
    }

    @Test
    public void findMnu() {
        FamilyMember actual = familyTree.findFamilyMember("Mnu");
        assertEquals("Mnu exists but not found", "Mnu", actual.getName());
    }

    @Test
    public void findNonExistentMember() {
        FamilyMember actual = familyTree.findFamilyMember("X");
        assertTrue("X doesnot exis ", actual == null);
    }

    @Test
    public void findKingShan() {
        FamilyMember actual = familyTree.findFamilyMember("KingShan");
        assertEquals("kingShan could not find ", "KingShan", actual.getName());
    }

    @Test
    public void findQueenAnga() {
        FamilyMember actual = familyTree.findFamilyMember("QueenAnga");
        assertEquals("QueenAnga could not find ", "QueenAnga", actual.getName());
    }

    /***************************** End Find member Test *********************************************/
    /*****************************
     * Start Brother Test
     *********************************************/
    @Test
    public void testIshBrother() {
        List<String> actual = familyTree.findRelation("ish", "Brothers");
        List<String> expected = Arrays.asList("Chit", "Vich");
        assertEquals("Brothers of ish are incorrect", expected, actual);
    }

    @Test
    public void testAmbiBrother() {
        List<String> actual = familyTree.findRelation("Ambi", "Brothers");
        assertTrue("Ambi does not have brothers", actual.size() == 0);
    }

    @Test
    public void testChitBrother() {
        List<String> actual = familyTree.findRelation("Chit", "Brothers");
        List<String> expected = Arrays.asList("Ish", "Vich");
        assertEquals("Brothers of Chit are incorrect", expected, actual);
    }

    @Test
    public void testXBrother() {
        List<String> actual = familyTree.findRelation("X", "Brothers");
        assertTrue("X does not exist in Family, so should not have brothers",
                actual.size() == 0);
    }

    @Test
    public void testVichBrother() {
        List<String> actual = familyTree.findRelation("Vich", "Brothers");
        List<String> expected = Arrays.asList("Ish", "Chit");
        assertEquals("Brothers of Vich are incorrect", expected, actual);
    }

    @Test
    public void testDritaBrother() {
        List<String> actual = familyTree.findRelation("Drita", "Brothers");
        List<String> expected = Arrays.asList("Vrita");
        assertEquals("Brothers of Drita are incorrect", expected, actual);
    }

    @Test
    public void testJataBrother() {
        List<String> actual = familyTree.findRelation("Jata", "Brothers");
        assertTrue("Jata doesnot have brothers", actual.size() == 0);
    }

    @Test
    public void testSaayanBrother() {
        List<String> actual = familyTree.findRelation("Saayan", "Brothers");
        List<String> expected = Arrays.asList("Savya");
        assertEquals("Brothers of Saayan are incorrect", expected, actual);
    }

    @Test
    public void testSavyaBrother() {
        List<String> actual = familyTree.findRelation("Savya", "Brothers");
        List<String> expected = Arrays.asList("Saayan");
        assertEquals("Brothers of Savya are incorrect", expected, actual);
    }

    @Test
    public void testVritaBrother() {
        List<String> actual = familyTree.findRelation("Vrita", "Brothers");
        List<String> expected = Arrays.asList("Drita");
        assertEquals("Brothers of Vrita are incorrect", expected, actual);
    }

    @Test
    public void testSatvyBrother() {
        List<String> actual = familyTree.findRelation("Satvy", "Brothers");
        List<String> expected = Arrays.asList("Savya", "Saayan");
        assertEquals("Brothers of Satvy are incorrect", expected, actual);
    }

    @Test
    public void testSatyaBrother() {
        List<String> actual = familyTree.findRelation("Satya", "Brothers");
        List<String> expected = Arrays.asList("Ish", "Chit", "Vich");
        assertEquals("Brothers of Satya are incorrect", expected, actual);
    }

    /***************************** End Brother test *********************************************/

    /*****************************
     * Start Sister test
     *********************************************/
    @Test
    public void testIshSister() {
        List<String> actual = familyTree.findRelation("Ish", "Sisters");
        List<String> expected = Arrays.asList("Satya");
        assertEquals("Sisters of Ish are incorrect", expected, actual);
    }

    @Test
    public void testSatyaSister() {
        List<String> actual = familyTree.findRelation("Satya", "Sisters");
        assertTrue("Satya doesnot have sisters", actual.size() == 0);
    }

    @Test
    public void testJataSister() {
        List<String> actual = familyTree.findRelation("Jata", "Sisters");
        List<String> expected = Arrays.asList("Driya");
        assertEquals("Sisters of Jata are incorrect", expected, actual);
    }

    @Test
    public void testKpilaSister() {
        List<String> actual = familyTree.findRelation("Kpila", "Sisters");
        assertTrue("Kpila does not have sisters", actual.size() == 0);
    }

    /***************************** End Sister test *********************************************/

    /*****************************
     * Start Son test
     *********************************************/
    @Test
    public void testChitSon() {
        List<String> actual = familyTree.findRelation("Chit", "Sons");
        List<String> expected = Arrays.asList("Drita", "Vrita");
        assertEquals("Sons of Chit are incorrect", expected, actual);
    }

    @Test
    public void testKingShanSon() {
        List<String> actual = familyTree.findRelation("KingShan", "Sons");
        List<String> expected = Arrays.asList("Ish", "Chit", "Vich");
        assertEquals("Sons of Chit are incorrect", expected, actual);
    }

    @Test
    public void testQueenAngaSon() {
        List<String> actual = familyTree.findRelation("QueenAnga", "Sons");
        List<String> expected = Arrays.asList("Ish", "Chit", "Vich");
        assertEquals("Sons of Chit are incorrect", expected, actual);
    }

    @Test
    public void testIshSon() {
        List<String> actual = familyTree.findRelation("Ish", "Sons");
        assertTrue("Ish is not married, no sons", actual.size() == 0);
    }

    @Test
    public void testAmbiSon() {
        List<String> actual = familyTree.findRelation("Ambi", "Sons");
        List<String> expected = Arrays.asList("Drita", "Vrita");
        assertEquals("Sons of Ambi are incorrect", expected, actual);
    }

    @Test
    public void testJayaSon() {
        List<String> actual = familyTree.findRelation("Jaya", "Sons");
        List<String> expected = Arrays.asList("Jata");
        assertEquals("Sons of Jaya are incorrect", expected, actual);
    }

    @Test
    public void testJataSon() {
        List<String> actual = familyTree.findRelation("Jata", "Sons");
        assertTrue("Jata is not married, no sons", actual.size() == 0);
    }

    @Test
    public void testDritaSon() {
        List<String> actual = familyTree.findRelation("Drita", "Sons");
        List<String> expected = Arrays.asList("Jata");
        assertEquals("Sons of Drita are incorrect", expected, actual);
    }

    @Test
    public void testMnuSon() {
        List<String> actual = familyTree.findRelation("Mnu", "Sons");
        assertTrue("Mnu is not married, no sons", actual.size() == 0);
    }

    @Test
    public void testLikaSon() {
        List<String> actual = familyTree.findRelation("Lika", "Sons");
        List<String> expected = Arrays.asList("Vila");
        assertEquals("Sons of Lika are incorrect", expected, actual);
    }

    @Test
    public void testVichSon() {
        List<String> actual = familyTree.findRelation("Vich", "Sons");
        List<String> expected = Arrays.asList("Vila");
        assertEquals("Sons of Vich are incorrect", expected, actual);
    }

    @Test
    public void testVilaSon() {
        List<String> actual = familyTree.findRelation("Vila", "Sons");
        assertTrue("Vila does not have sons", actual.size() == 0);
    }

    @Test
    public void testJnkiSon() {
        List<String> actual = familyTree.findRelation("Jnki", "Sons");
        assertTrue("Jnki does not have sons", actual.size() == 0);
    }

    @Test
    public void testSatyaSon() {
        List<String> actual = familyTree.findRelation("Satya", "Sons");
        List<String> expected = Arrays.asList("Savya", "Saayan");
        assertEquals("Sons of Satya are incorrect", expected, actual);
    }

    @Test
    public void testVyanSon() {
        List<String> actual = familyTree.findRelation("Vyan", "Sons");
        List<String> expected = Arrays.asList("Savya", "Saayan");
        assertEquals("Sons of Vyan are incorrect", expected, actual);
    }

    @Test
    public void testKpilaSon() {
        List<String> actual = familyTree.findRelation("Kpila", "Sons");
        assertTrue("Kpila is not married, no sons", actual.size() == 0);
    }

    @Test
    public void testSavyaSon() {
        List<String> actual = familyTree.findRelation("Savya", "Sons");
        List<String> expected = Arrays.asList("Kriya");
        assertEquals("Sons of Savya are incorrect", expected, actual);
    }

    @Test
    public void testSaayanSon() {
        List<String> actual = familyTree.findRelation("Saayan", "Sons");
        List<String> expected = Arrays.asList("Misa");
        assertEquals("Sons of Saayan are incorrect", expected, actual);
    }

    @Test
    public void testMinaSon() {
        List<String> actual = familyTree.findRelation("Mina", "Sons");
        List<String> expected = Arrays.asList("Misa");
        assertEquals("Sons of Mina are incorrect", expected, actual);
    }

    /***************************** End Son test *********************************************/

    /*****************************
     * Start  Daughter test
     *********************************************/
    @Test
    public void testSatyaDaughter() {
        List<String> actual = familyTree.findRelation("Satya", "Daughters");
        List<String> expected = Arrays.asList("Satvy");
        assertEquals("Daughters of Satya are incorrect", expected, actual);
    }

    @Test
    public void testVyanDaughter() {
        List<String> actual = familyTree.findRelation("Vyan", "Daughters");
        List<String> expected = Arrays.asList("Satvy");
        assertEquals("Daughters of Satya are incorrect", expected, actual);
    }

    @Test
    public void testKingShanDaughter() {
        List<String> actual = familyTree.findRelation("KingShan", "Daughters");
        List<String> expected = Arrays.asList("Satya");
        assertEquals("Daughters of KingShan are incorrect", expected, actual);
    }

    @Test
    public void testQueenAngaDaughter() {
        List<String> actual = familyTree.findRelation("QueenAnga", "Daughters");
        List<String> expected = Arrays.asList("Satya");
        assertEquals("Daughters of KingShan are incorrect", expected, actual);
    }

    @Test
    public void testVichDaughter() {
        List<String> actual = familyTree.findRelation("Vich", "Daughters");
        List<String> expected = Arrays.asList("Chika");
        assertEquals("Daughters of Vich are incorrect", expected, actual);
    }

    @Test
    public void testLikaDaughter() {
        List<String> actual = familyTree.findRelation("Lika", "Daughters");
        List<String> expected = Arrays.asList("Chika");
        assertEquals("Daughters of Vich are incorrect", expected, actual);
    }

    @Test
    public void testIshDaughter() {
        List<String> actual = familyTree.findRelation("Ish", "Daughters");
        assertTrue("Ish  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testChitDaughter() {
        List<String> actual = familyTree.findRelation("Chit", "Daughters");
        assertTrue("Chit  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testAmbiDaughter() {
        List<String> actual = familyTree.findRelation("Ambi", "Daughters");
        assertTrue("Ambi  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testDritaDaughter() {
        List<String> actual = familyTree.findRelation("Drita", "Daughters");
        List<String> expected = Arrays.asList("Driya");
        assertEquals("Daughters of Drita are incorrect", expected, actual);
    }

    @Test
    public void testJayaDaughter() {
        List<String> actual = familyTree.findRelation("Jaya", "Daughters");
        List<String> expected = Arrays.asList("Driya");
        assertEquals("Daughters of Jaya are incorrect", expected, actual);
    }

    @Test
    public void testVritaDaughter() {
        List<String> actual = familyTree.findRelation("Vrita", "Daughters");
        assertTrue("Vrita  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testVilaDaughter() {
        List<String> actual = familyTree.findRelation("Vila", "Daughters");
        List<String> expected = Arrays.asList("Lavnya");
        assertEquals("Daughters of Vila are incorrect", expected, actual);
    }

    @Test
    public void testJnkiDaughter() {
        List<String> actual = familyTree.findRelation("Jnki", "Daughters");
        List<String> expected = Arrays.asList("Lavnya");
        assertEquals("Daughters of Vila are incorrect", expected, actual);
    }

    @Test
    public void testChikaDaughter() {
        List<String> actual = familyTree.findRelation("Chika", "Daughters");
        assertTrue("Chika  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testKpilaDaughter() {
        List<String> actual = familyTree.findRelation("Kpila", "Daughters");
        assertTrue("Kpila  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testSatvyDaughter() {
        List<String> actual = familyTree.findRelation("Satvy", "Daughters");
        assertTrue("Satvy  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testAsvaDaughter() {
        List<String> actual = familyTree.findRelation("Asva", "Daughters");
        assertTrue("Asva  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testSavyaDaughter() {
        List<String> actual = familyTree.findRelation("Savya", "Daughters");
        assertTrue("Savya  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testKrpiDaughter() {
        List<String> actual = familyTree.findRelation("Krpi", "Daughters");
        assertTrue("Krpi  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testSaayanDaughter() {
        List<String> actual = familyTree.findRelation("Saaya", "Daughters");
        assertTrue("Saayan  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testMinaDaughter() {
        List<String> actual = familyTree.findRelation("Mina", "Daughters");
        assertTrue("Mina  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testJataDaughter() {
        List<String> actual = familyTree.findRelation("Jata", "Daughters");
        assertTrue("Jata  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testDriyaDaughter() {
        List<String> actual = familyTree.findRelation("Driya", "Daughters");
        assertTrue("Driya  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testMnuDaughter() {
        List<String> actual = familyTree.findRelation("Mnu", "Daughters");
        assertTrue("Mnu  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testLavnyaDaughter() {
        List<String> actual = familyTree.findRelation("Lavnya", "Daughters");
        assertTrue("Lavnya  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testGruDaughter() {
        List<String> actual = familyTree.findRelation("Gru", "Daughters");
        assertTrue("Gru  does not have daughter", actual.size() == 0);
    }


    @Test
    public void testKriyaDaughter() {
        List<String> actual = familyTree.findRelation("Kriya", "Daughters");
        assertTrue("Kriya  does not have daughter", actual.size() == 0);
    }

    @Test
    public void testMisaDaughter() {
        List<String> actual = familyTree.findRelation("Misa", "Daughters");
        assertTrue("Misa  does not have daughter", actual.size() == 0);
    }


    /***************************** End Daughter test *********************************************/

    /*****************************
     * Start Children test
     *********************************************/
    @Test
    public void testKingSShanChildren() {
        List<String> actual = familyTree.findRelation("Kingshan", "Children");
        List<String> expected = Arrays.asList("Ish", "Chit", "Vich", "Satya");
        assertEquals("Children of Kingshan are incorrect", expected, actual);
    }

    /***************************** End Children test *********************************************/
}