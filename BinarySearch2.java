
package binarysearch2;


import java.util.Scanner;

public class binarySearch2 {

    public static void main(String[] args) {
        Scanner Azwie = new Scanner(System.in);

        int[] productIDs = {104, 105, 106, 107, 101, 102, 103};

        System.out.print("Enter the product ID to search for: ");
        int targetID = Azwie.nextInt();

        int index = findProduct(productIDs, targetID);

        if (index != -1) {
            System.out.println("Product found at index: " + index);
        } else {
            System.out.println("Product not found.");
        }

        Azwie.close();
    }

    public static int findProduct(int[] productIDs, int targetID) {
        int left = 0;
        int right = productIDs.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (productIDs[mid] == targetID) {
                return mid;
            }

            if (productIDs[left] <= productIDs[mid]) {
                if (targetID >= productIDs[left] && targetID < productIDs[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (targetID > productIDs[mid] && targetID <= productIDs[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}