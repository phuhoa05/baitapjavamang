/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Baitap {

    
   public static float[] importData(float[] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }

   
    public static void printData(float[] arrays) {
        System.out.print("Mang hien tai: ");
        for (float number : arrays) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

  
    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat 2 phan tu.");
        }

        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;

        for (float number : arrays) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number > max2 && number != max1) {
                max2 = number;
            }
        }

        if (max2 == Float.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Khong co phan tu lon thu 2.");
        }

        return max2;
    }

    
    public static float[] deleteOddNumber(float[] arrays) {
        int countEven = 0;
        for (float number : arrays) {
            if ((int) number % 2 == 0) {
                countEven++;
            }
        }

        float[] newArray = new float[countEven];
        int index = 0;
        for (float number : arrays) {
            if ((int) number % 2 == 0) {
                newArray[index++] = number;
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so phan tu trong mang: ");
        int n = scanner.nextInt();
        float[] arrays = new float[n];

      
        importData(arrays);

      
        printData(arrays);

       
        try {
            float max2 = findMax2(arrays);
            System.out.println("Phan tu lon thu 2 trong mang la: " + max2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        
        float[] evenArray = deleteOddNumber(arrays);
        System.out.print("Mang sau khi xoa cac phan tu le: ");
        printData(evenArray);
    }
    
}
