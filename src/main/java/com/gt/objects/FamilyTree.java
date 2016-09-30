package com.gt.objects;

import java.util.ArrayList;
import java.util.List;

import com.gt.objects.traverse.MemberFetcherVisitor;
import com.gt.objects.traverse.PrintVisitor;
import com.gt.objects.traverse.RelationFinder;
import com.gt.objects.traverse.Visitor;

public class FamilyTree {
    private static final String BROTHERS = "BROTHERS";
    private static final String SISTERS = "SISTERS";
    private static final String SONS = "SONS";
    private static final String DAUGHTERS = "DAUGHTERS";
    private static final String CHILDREN = "CHILDREN";

    private Family root;

    public FamilyTree(Family family) {
        this.root = family;
    }

    public void addFamilyMember(FamilyMember newMem, String parentName) {
        MemberFetcherVisitor visitor = new MemberFetcherVisitor(parentName);
        if (root.accept(visitor)) {
            FamilyMember parent = visitor.getFamilyMember();
            parent.getFamily().addFamilyMember(newMem);
        }

    }

    public void printTree() {
        Visitor visitor = new PrintVisitor();
        root.accept(visitor);

    }

    public void addSpouse(FamilyMember spouse1, String spouse2Name) {
        // root.findFamilyMember(spouse2);
        MemberFetcherVisitor visitor = new MemberFetcherVisitor(spouse2Name);
        if (root.accept(visitor)) {
            FamilyMember spouse2 = visitor.getFamilyMember();
            Family family = new Family(spouse1, spouse2);
            spouse2.getFather().getFamily()
                    .replaceMemberWithFamily(spouse2, family);

        } else {
            System.out.println("Failed to add Spouse" + spouse1.getName()
                    + " on " + spouse2Name);
        }

    }

    public List<String> findRelation(String memberName, String releationName) {
        RelationFinder relVisitor = new RelationFinder(memberName);
        if (root.accept(relVisitor)) {
            switch (releationName.toUpperCase()) {
                case BROTHERS: {
                    return relVisitor.getBrotherNames();
                }
                case SISTERS: {
                    return relVisitor.getSisterNames();
                }
                case SONS: {
                    return relVisitor.getSonsNames();
                }
                case DAUGHTERS: {
                    return relVisitor.getDaughterNames();
                }
                case CHILDREN: {
                    return relVisitor.getChildrenNames();
                }
            }

        }
        return new ArrayList<String>();
    }

    public FamilyMember findFamilyMember(String name) {
        MemberFetcherVisitor visitor = new MemberFetcherVisitor(name);
        if (root.accept(visitor)) {
            return visitor.getFamilyMember();
        } else {
            return null;
        }
    }

}
