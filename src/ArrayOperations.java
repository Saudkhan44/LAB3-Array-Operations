import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[20]; // bigger array for demo
        int n = 10; // current size
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // initial values 1-10
        }

        int choice;
        do {
            System.out.println("\n============================");
            System.out.println("     ARRAY OPERATIONS MENU  ");
            System.out.println("============================");
            System.out.println("1. Traversal");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Search Element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Traversal
                    display(arr, n);
                    break;

                case 2: // Insertion
                    System.out.println("Insert Menu:");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At Given Position");
                    System.out.println("3. At End");
                    System.out.print("Enter your option: ");
                    int insertChoice = sc.nextInt();

                    if (isFull(arr, n)) {
                        System.out.println("Overflow! Cannot Insert...");
                        break;
                    }

                    switch (insertChoice) {
                        case 1: // Beginning
                            System.out.print("Enter element to insert: ");
                            int ele1 = sc.nextInt();
                            for (int i = n; i > 0; i--) {
                                arr[i] = arr[i - 1];
                            }
                            arr[0] = ele1;
                            n++;
                            display(arr, n);
                            break;

                        case 2: // Given Position
                            System.out.print("Enter position (1-" + (n + 1) + "): ");
                            int pos = sc.nextInt();
                            if (pos < 1 || pos > n + 1) {
                                System.out.println("Invalid position!");
                                break;
                            }
                            System.out.print("Enter element to insert: ");
                            int ele2 = sc.nextInt();
                            for (int i = n; i >= pos; i--) {
                                arr[i] = arr[i - 1];
                            }
                            arr[pos - 1] = ele2;
                            n++;
                            display(arr, n);
                            break;

                        case 3: // End
                            System.out.print("Enter element to insert: ");
                            int ele3 = sc.nextInt();
                            arr[n] = ele3;
                            n++;
                            display(arr, n);
                            break;

                        default:
                            System.out.println("Invalid Insert Choice!");
                    }
                    break;

                case 3: // Deletion
                    System.out.println("Delete Menu:");
                    System.out.println("1. From Beginning");
                    System.out.println("2. From Given Position");
                    System.out.println("3. From End");
                    System.out.print("Enter your option: ");
                    int deleteChoice = sc.nextInt();

                    if (n == 0) {
                        System.out.println("Underflow! No elements to delete.");
                        break;
                    }

                    switch (deleteChoice) {
                        case 1: // Beginning
                            for (int i = 0; i < n - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            n--;
                            display(arr, n);
                            break;

                        case 2: // Given Position
                            System.out.print("Enter position (1-" + n + "): ");
                            int delPos = sc.nextInt();
                            if (delPos < 1 || delPos > n) {
                                System.out.println("Invalid position!");
                                break;
                            }
                            for (int i = delPos - 1; i < n - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            n--;
                            display(arr, n);
                            break;

                        case 3: // End
                            n--;
                            display(arr, n);
                            break;

                        default:
                            System.out.println("Invalid Delete Choice!");
                    }
                    break;

                case 4: // Search
                    System.out.println("Search Menu:");
                    System.out.println("1. Search by Value");
                    System.out.println("2. Search by Index");
                    System.out.print("Enter your option: ");
                    int searchChoice = sc.nextInt();

                    switch (searchChoice) {
                        case 1: // By Value
                            System.out.print("Enter value to search: ");
                            int key = sc.nextInt();
                            boolean found = false;
                            for (int i = 0; i < n; i++) {
                                if (arr[i] == key) {
                                    System.out.println("Value " + key + " found at position " + (i + 1));
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Value not found!");
                            }
                            break;

                        case 2: // By Index
                            System.out.print("Enter index (1-" + n + "): ");
                            int idx = sc.nextInt();
                            if (idx < 1 || idx > n) {
                                System.out.println("Invalid index!");
                            } else {
                                System.out.println("Value at index " + idx + " is: " + arr[idx - 1]);
                            }
                            break;

                        default:
                            System.out.println("Invalid Search Choice!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    public static void display(int[] arr, int n) {
        System.out.print("Array Elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isFull(int[] arr, int n) {
        return arr.length == n;
    }
}
