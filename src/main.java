import java.util.*;
import java.util.Set;

public class main {
    static Scanner scan = new Scanner(System.in);

    static void findRelation(int arr1[], int arr2[],
                             int n, int n1) {
        System.out.print("{");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n1; j++)
                System.out.print("(" + arr1[i] + ", " + arr2[j] + "), ");
        System.out.println("}");
    }

    public static void main(String[] args) {

        //Instruction Message
        System.out.println("INSTRUCTION!");
        System.out.println("You need to create 2 different sets in order to get the relation.");

        // First Set
        System.out.print("\nEnter the number of elements for 1st Set: ");
        int m = scan.nextInt();
        int arr1[] = new int[m];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < m; i++){
            arr1[i]=scan.nextInt(); //Reading array elements from the user
        }

        // Second Set
        System.out.print("Enter the number of elements for 2nd Set: ");
        int n = scan.nextInt();
        int arr2[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++) {
            arr2[i] = scan.nextInt(); //Reading array elements from the user
        }

        int n1 = arr1.length;
        int n2 = arr2.length;

        int op = 0;
        do {
            System.out.println("");
            System.out.println("[Main Menu] \n1. Relation Statement | 2. Show Complementary |" +
                    " 3. Show Inverse | 4. Show Union | 5. Show Intersection | 0. Exit");
            System.out.println("Please choose a number: ");
            op = scan.nextInt();

            if (op == 0) {
                System.out.println("Goodbye have a nice day!");
                System.exit(0);
            } else if (op == 1) {
                System.out.println("The Relation Statement");
                System.out.print("Relation 1: ");
                findRelation(arr1, arr2, n1, n2);
                System.out.println("");
                op = 0;
            } else if (op == 2) {
                System.out.println("Both relations no complementary because it already a complete relation.");
                op = 0;
            } else if (op == 3) {
                Inverse(arr1, arr2, n,n1);
                op = 0;
            } else if (op == 4) {
                System.out.println("The Union Relation");
                Union();
                op = 0;
            } else if (op == 5) {
                System.out.println("The Intersection Relation");
                Intersection();
                op = 0;
            }
            else {
                System.out.println("\"Invalid input please try again.\"");
            }
        }while(op > 5 || op == 0);
    }

    private static void Inverse(int arr1[], int arr2[],
                                int n, int n1) {
        System.out.print("Inverse R1 = {");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n1; j++)
                System.out.print("(" + arr2[j] + ", " + arr1[i] + "), ");
        System.out.println("}");
    }

    static void Union(){

        // Create the first set
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Total number in set 1 : ");
        int tnum= scan.nextInt();
        System.out.println("Enter Set 1 numbers: ");
        for (int i = 0; i < tnum; i++) {
            Integer a = scan.nextInt();
            // Integer b = scan.nextInt();

            set1.addAll(Collections.singleton(a));

        }


        System.out.println("Set1: " + set1);

        // create second set
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Total number in set 2 : ");
        int tnum2= scan.nextInt();
        System.out.println("Enter Set 2 numbers: ");

        for (int i = 0; i < tnum2; i++) {
            Integer b = scan.nextInt();
            // Integer b = scan.nextInt();

            set2.addAll(Collections.singleton(b));

        }

        System.out.println("Set2: " + set2);
        System.out.println("\n Set 1 "+set1+" + Set 2: " + set2);


        // Union of two sets
        set2.addAll(set1);
        System.out.println("Union is: " + set2);
    }

    static void Intersection(){
        // create first set
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Total number in set 1 : ");
        int tnum= scan.nextInt();
        System.out.println("Enter Set 1 numbers: ");

        for (int i = 0; i < tnum; i++) {
            Integer a = scan.nextInt();
            // Integer b = scan.nextInt();

            set1.addAll(Collections.singleton(a));

        }
        System.out.println("Set 1: " + set1);

        // create second set
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Total number in set 2 : ");
        int tnum2= scan.nextInt();
        System.out.println("Enter Set 2 numbers: ");

        for (int i = 0; i < tnum2; i++) {
            Integer b = scan.nextInt();
            // Integer b = scan.nextInt();

            set2.addAll(Collections.singleton(b));

        }
        System.out.println("Set 2: " + set1+"\n");

        System.out.println("Set 1 "+set1+" + Set 2: " + set2);

        // Intersection of two sets
        set2.retainAll(set1);
        System.out.println("Intersection: " + set2);
    }
}