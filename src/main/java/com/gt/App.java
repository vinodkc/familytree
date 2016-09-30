package com.gt;

import java.util.Scanner;

import com.gt.misc.Utils;
import com.gt.objects.FamilyTree;

public class App {
    public static void main(String[] args) {
        FamilyTree familyTree = Utils.createFamilyTree();
        System.out.println("Select problem");
        System.out.println("Meet the family =>1");
        System.out.println("A new born =>2");
        System.out.println("The girl child => 3");
        System.out.println("Who’s your daddy? => ");
        Scanner sc = new Scanner(System.in);
        int problemType = sc.nextInt();

        switch (problemType) {
            case 1: {
                System.out.print("Input: Person = ");
                String person = sc.next();
                System.out.print("; Relation = ");
                String relation = sc.next();
                System.out.println("Output: ");
                break;
            }
            case 2: {
                System.out.print("Input: Mother = ");
                String mother = sc.next();
                System.out.print("; Daughter = ");
                String da = sc.next();
                System.out.println("Output: ");
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            default: {
                break;
            }
        }

		/*for (String name : familyTree.findRelation("ish", "Brothers")) {
            System.out.print(name+ " ");
		}*/
    }
}
