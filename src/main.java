import java.util.*;

public class main {
    static Scanner scan = new Scanner(System.in);

    static void findRelation(int arr1[], int arr2[],
                             int n, int n1) {
        System.out.print("{");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n1; j++)
                System.out.print("(" + arr1[i] + ", " + arr2[j] + "),");
        System.out.println("}");
    }

    public static void main(String[] args) {

        //Instruction Message
        System.out.println("INSTRUCTION!");
        System.out.println("You need to create 4 different sets in order to get 2 relations.");

        // First Set
        System.out.print("\nEnter the number of elements for 1st Set: ");
        int m = scan.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[m];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < m; i++){
            arr1[i]=scan.nextInt(); //Reading array elements from the user
            arr2[i]=arr1[i];
        }

        // Second Set
        System.out.print("Enter the number of elements for 2nd Set: ");
        int o = scan.nextInt();
        int arr3[] = new int[o];
        int arr4[] = new int[o];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < o; i++){
            arr3[i]=scan.nextInt(); //Reading array elements from the user
            arr4[i]= arr3[i];
        }


        int n = arr1.length, n1 = arr2.length;

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
                findRelation(arr1, arr2, n, n1); // Display Relation 1
                System.out.print("Relation 2: ");
                findRelation(arr3, arr4, n, n1); // Display Relation 2
                op = 0;

            } else if (op == 2) {
                complement(arr1, arr2, n,arr3,arr4);
                op = 0;

            } else if (op == 3) {
                System.out.print("Inverse R1: ");
                Inverse(arr1, arr2, n,n1);
                System.out.println("");
                System.out.print("Inverse R2: ");
                Inverse(arr3, arr4, n, n1);
                op = 0;

            } else if (op == 4) {
                System.out.print("Union R1 & R2= ");
                Union(arr1, arr2, n,arr3,arr4);
                op = 0;

            } else if (op == 5) {
                System.out.print("Intersection R1 & R2= {");
                Intersection(arr1, arr3, arr2, arr4);
                System.out.print("}");

                op = 0;

            }
            else {
                System.out.println("\"Invalid input please try again.\"");
            }
        }while(op > 5 || op == 0);
    }

    private static void complement(int[] arr1, int[] arr2, int n, int[] arr3, int[] arr4) {
        System.out.print("Relation R1: {");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + arr1[i] + ", " + arr3[j] + "),");
                System.out.print("(" + arr4[i] + ", " + arr2[j] + "),");
                System.out.print("(" + arr3[i] + ", " + arr4[j] + "),");
            }
        }
        System.out.println("}");
        System.out.print("Relation R2: {");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + arr3[i] + ", " + arr1[j] + "),");
                System.out.print("(" + arr2[i] + ", " + arr4[j] + "),");
                System.out.print("(" + arr1[i] + ", " + arr2[j] + "),");
            }
        }
        System.out.print("}");
    }

    private static void Inverse(int arr1[], int arr2[], int n, int n1) {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n1; j++)
                System.out.print("(" + arr2[j] + ", " + arr1[i] + "),");
        } System.out.print("}");

    }

    static void Union(int[] arr1, int[] arr2, int n1, int[] arr3, int[] arr4) { //Need to revise
        System.out.print("{");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                System.out.print("(" + arr1[i] + ", " + arr2[j] + "),");
                System.out.print("(" + arr3[i] + ", " + arr4[j] + "),");
            }
        }
        System.out.print("}");
    }


    public static void Intersection(int[] arr1, int[] arr3, int[] arr2, int[] arr4) {
        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr3.length; j++)
                for (int k = 0; k < arr2.length; k++)
                    for (int l = 0; l < arr4.length; l++)
                        if (arr1[i] == arr3[j] && arr2[k] == arr4[l])
                            System.out.print("(" + arr1[i] + ", " + arr2[k] + "),");
    }
}