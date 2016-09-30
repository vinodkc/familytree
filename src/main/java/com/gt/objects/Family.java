package com.gt.objects;

import java.util.ArrayList;
import java.util.List;

import com.gt.objects.traverse.Visitor;

public class Family implements FamilyNode {
    private FamilyMember husband;
    private FamilyMember wife;
    private List<FamilyNode> subFamily = new ArrayList<FamilyNode>();

    public Family(FamilyMember spouse1, FamilyMember spouse2) {
        FamilyMember maleSpouse;
        FamilyMember femaleSpouse;
        if (spouse1.getGender() == GENDER.MALE) {
            maleSpouse = spouse1;
            femaleSpouse = spouse2;
        } else {
            maleSpouse = spouse2;
            femaleSpouse = spouse1;
        }

        this.husband = maleSpouse;
        this.husband.setSpouse(femaleSpouse);
        this.husband.setFamily(this);
        this.wife = femaleSpouse;
        this.wife.setSpouse(maleSpouse);
        this.wife.setFamily(this);
    }

    public FamilyMember getHusband() {
        return husband;
    }

    public void setHusband(FamilyMember husband) {
        this.husband = husband;
    }

    public FamilyMember getWife() {
        return wife;
    }

    public void setWife(FamilyMember wife) {
        this.wife = wife;
    }

    public void addFamily(Family family, String parentName) {
        if (husband.getName().equals(parentName)
                || wife.getName().equals(parentName)) {
            subFamily.add(family);
        }

    }

    public void replaceMemberWithFamily(FamilyMember spouse2, Family family) {
        int memberIndex = subFamily.indexOf(spouse2);
        subFamily.set(memberIndex, family);
    }

    public void addFamilyMember(FamilyMember familyMember, String parentName) {
        if (husband.getName().equals(parentName)
                || wife.getName().equals(parentName)) {
            familyMember.setFather(husband);
            familyMember.setMother(wife);
            //familyMember.setFamily(this);
            subFamily.add(familyMember);
        }

    }

    public void addFamilyMember(FamilyMember familyMember) {
        familyMember.setFather(husband);
        familyMember.setMother(wife);
        //familyMember.setFamily(this);
        subFamily.add(familyMember);

    }

    @Override
    public String toString() {
        return "Family [husband=" + husband.getName() + getFatherName(husband)
                + getMotherName(husband) + ", wife=" + wife.getName()
                + getFatherName(wife) + getMotherName(wife) + "]";
    }

    private String getFatherName(FamilyMember member) {
        FamilyMember father = member.getFather();
        if (null != father) {
            return " Father :" + father.getName();
        }

        return " NoFather";
    }

    private String getMotherName(FamilyMember member) {
        FamilyMember mother = member.getMother();
        if (null != mother) {
            return " Mother :" + mother.getName();
        }

        return " No Mother";
    }

    @Override
    public void print() {
        System.out.println(this);
        for (FamilyNode familyNode : subFamily) {
            familyNode.print();
        }
    }

    @Override
    public Boolean accept(Visitor visitor) {
        Boolean result = false;
        visitor.visit(this);
        if (visitor.visit(husband) || visitor.visit(wife)) {
            result = true;
        } else {
            for (FamilyNode familyNode : subFamily) {
                if (familyNode.accept(visitor)) {
                    result = true;
                    break;
                }
            }
        }
        return result;

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "()";
    }

    public List<String> getBrotherNames(FamilyMember familyMember) {
        List<String> childrenNames = new ArrayList<String>();
        for (FamilyNode familyNode : subFamily) {

            if (familyNode instanceof Family) {
                FamilyMember male = ((Family) familyNode).getHusband();

                fillChildren(childrenNames, male, familyMember);

            } else {
                if (((FamilyMember) familyNode).getGender() == GENDER.MALE) {
                    addFamilyMemberToList(childrenNames, familyNode,
                            familyMember);
                }
            }
        }
        return childrenNames;

    }

    private void addFamilyMemberToList(List<String> childrenNames,
                                       FamilyNode familyNode, FamilyNode excludefamilyMember) {
        if (familyNode != excludefamilyMember) {
            childrenNames.add(familyNode.getName());
        }
    }

    private void fillChildren(List<String> childrenNames, FamilyMember member,
                              FamilyNode excludefamilyMember) {
        if ((member.getFather() == husband) && (member.getMother() == wife)) {
            addFamilyMemberToList(childrenNames, member, excludefamilyMember);
        }
    }

    public List<String> getSisterNames(FamilyMember familyMember) {
        List<String> childrenNames = new ArrayList<String>();
        for (FamilyNode familyNode : subFamily) {

            if (familyNode instanceof Family) {
                FamilyMember female = ((Family) familyNode).getWife();

                fillChildren(childrenNames, female, familyMember);

            } else {
                if (((FamilyMember) familyNode).getGender() == GENDER.FEMALE) {
                    addFamilyMemberToList(childrenNames, familyNode,
                            familyMember);
                }
            }
        }
        return childrenNames;
    }

    public List<String> getSonsNames() {
        List<String> childrenNames = new ArrayList<String>();
        for (FamilyNode familyNode : subFamily) {

            if (familyNode instanceof Family) {
                FamilyMember male = ((Family) familyNode).getHusband();
                fillChildren(childrenNames, male, null);

            } else {
                if (((FamilyMember) familyNode).getGender() == GENDER.MALE) {
                    addFamilyMemberToList(childrenNames, familyNode,
                            null);
                }
            }
        }
        return childrenNames;

    }

    public List<String> getDaughtersNames() {
        List<String> childrenNames = new ArrayList<String>();
        for (FamilyNode familyNode : subFamily) {

            if (familyNode instanceof Family) {
                FamilyMember female = ((Family) familyNode).getWife();
                fillChildren(childrenNames, female, null);

            } else {
                if (((FamilyMember) familyNode).getGender() == GENDER.FEMALE) {
                    addFamilyMemberToList(childrenNames, familyNode,
                            null);
                }
            }
        }
        return childrenNames;
    }

    public List<String> getChildrensNames() {
        List<String> childrenNames = new ArrayList<String>();
        for (FamilyNode familyNode : subFamily) {

            if (familyNode instanceof Family) {
                fillChildren(childrenNames, ((Family) familyNode).getWife(), null);
                fillChildren(childrenNames, ((Family) familyNode).getHusband(), null);

            } else {
                    addFamilyMemberToList(childrenNames, familyNode,
                            null);
            }
        }
        return childrenNames;
    }

}
