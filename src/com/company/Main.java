package com.company;
import java.math.*;

public class Main {
    private static float bigOnsquare(String str) {
        long startTime,stopTime;
        int n = str.length();
        char[] array = new char[n];
        int[] arrayInt = new int[n];
        /*int priOperation= 0;
        priOperation+=2;*/
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            array[i] = str.charAt(i); /*priOperation+=3;
            priOperation+=2;*/
            for (int p = 0; p < n; p++) {
                if (array[i] == str.charAt(p)) {
                    arrayInt[i]++;
                    /*priOperation+=3;*/
                }/*riOperation+=3;
                priOperation+=3;*/

            }/*System.out.println(i);
            priOperation+=3;*/
        }

        for (int i = 0; i < n; i++) {
            if ((arrayInt[i] % 2) == 0)
                System.out.print(array[i]);
        }stopTime = System.currentTimeMillis();
        /*System.out.println(priOperation);*/
        return (float)(stopTime-startTime)/(float)1000;
    }

    private static float bigOn(String str){
        long startTime,stopTime;
        int n = str.length();
        startTime = System.currentTimeMillis();
        int[] arrayInt = new int[26];
        for (int i=0; i<n;i++){
            arrayInt[str.charAt(i)-'a']++;
        }

        for(int i=0;i<n;i++){
            if(arrayInt[str.charAt(i)-'a']%2==0){
                System.out.print(str.charAt(i));
            }
        }stopTime = System.currentTimeMillis();
        return (float)(stopTime-startTime)/(float)1000;
    }


    public static void main(String[] args) {
        int power_10_start=0;
        int power_10 = 6 + 1;
        float total_time[] = new float[50];
        for (int pwr_10 = power_10_start; pwr_10 < power_10; pwr_10++) {
            String str = "a";
            String total_str = "";
            for (int i = 0; i < Math.pow(10, pwr_10); i++) {
                total_str += str;
            }

            for (int i = 0; i < 3; i++) {
                total_time[i + pwr_10] = bigOn(total_str);
                System.out.print("\nbigOn Time: ");
                System.out.println(total_time[i + pwr_10] + " s");
                // System.out.print("\n");
                total_time[i + pwr_10 + 3] = bigOnsquare(total_str);
                System.out.print("\nbigOnsquare Time: ");
                System.out.println(total_time[i + pwr_10 + 3] + " s");
            }
        }
        for (int pwr_10 = power_10_start; pwr_10 < power_10; pwr_10++) {
            for (int i = 0; i < 3; i++) {
                System.out.print("\n" + Math.pow(10, pwr_10) + " bigOn Time: ");
                System.out.println(total_time[i + pwr_10] + " s");
            }
            for (int i = 3; i < 6; i++) {
                System.out.print("\n" + Math.pow(10, pwr_10) + " bigOnsquare Time: ");
                System.out.println(total_time[i + pwr_10] + " s");
            }
        }
    }

}


