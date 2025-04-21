package solvAC.class1;


import java.util.Scanner;

public class MaxNum9 {
    public static void main(String[] args) {
        int[] arr = new int[9];
        Scanner sc = new Scanner(System.in);
        int maxNum = 0;
        int maxIndex = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
                maxIndex = i;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxIndex + 1);
    }
}
