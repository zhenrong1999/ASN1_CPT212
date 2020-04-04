package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    private static BigInteger bigOnsquare_steps(String str) {
        int n = str.length();
        char[] array = new char[n];
        int[] arrayInt = new int[n];
        BigInteger priOperation = BigInteger.ZERO;
        priOperation = priOperation.add(BigInteger.valueOf(2));
        for (int i = 0; i < n; i++) {
            array[i] = str.charAt(i);
            priOperation = priOperation.add(BigInteger.valueOf(3));
            priOperation = priOperation.add(BigInteger.valueOf(2));
            for (int p = 0; p < n; p++) {
                priOperation = priOperation.add(BigInteger.valueOf(3));
                if (array[i] == str.charAt(p)) {
                    arrayInt[i]++;
                    priOperation = priOperation.add(BigInteger.valueOf(3));
                }
                priOperation = priOperation.add(BigInteger.valueOf(3));
            }
            priOperation = priOperation.add(BigInteger.valueOf(3));
        }
        priOperation = priOperation.add(BigInteger.valueOf(2));
        for (int i = 0; i < n; i++) {
            priOperation = priOperation.add(BigInteger.valueOf(3));
            if ((arrayInt[i] % 2) == 0) {
                System.out.print(array[i]);
                priOperation = priOperation.add(BigInteger.valueOf(2));
            }
            priOperation = priOperation.add(BigInteger.valueOf(3));
        }
        return priOperation;
    }

    private static BigInteger bigOn_steps(String str) {
        int n = str.length();
        int[] arrayInt = new int[26];
        BigInteger priOperation = BigInteger.ZERO;
        priOperation = priOperation.add(BigInteger.valueOf(2));
        for (int i = 0; i < n; i++) {
            arrayInt[str.charAt(i) - 'a']++;
            priOperation = priOperation.add(BigInteger.valueOf(5));
            priOperation = priOperation.add(BigInteger.valueOf(3));
        }
        priOperation = priOperation.add(BigInteger.valueOf(2));
        for (int i = 0; i < n; i++) {
            priOperation = priOperation.add(BigInteger.valueOf(5));
            if (arrayInt[str.charAt(i) - 'a'] % 2 == 0) {
                System.out.print(str.charAt(i));
                priOperation = priOperation.add(BigInteger.valueOf(2));
            }
            priOperation = priOperation.add(BigInteger.valueOf(3));
        }
        return priOperation;
    }

    private static float bigOnsquare(String str) {
        long startTime, stopTime;
        int n = str.length();
        char[] array = new char[n];
        int[] arrayInt = new int[n];
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            array[i] = str.charAt(i);
            for (int p = 0; p < n; p++) {
                if (array[i] == str.charAt(p)) {
                    arrayInt[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if ((arrayInt[i] % 2) == 0) System.out.print(array[i]);
        }
        stopTime = System.currentTimeMillis();
        return (float) (stopTime - startTime) / (float) 1000;
    }

    private static float bigOn(String str) {
        long startTime, stopTime;
        int n = str.length();
        startTime = System.currentTimeMillis();
        int[] arrayInt = new int[26];
        for (int i = 0; i < n; i++) {
            arrayInt[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arrayInt[str.charAt(i) - 'a'] % 2 == 0) {
                System.out.print(str.charAt(i));
            }
        }
        stopTime = System.currentTimeMillis();
        return (float) (stopTime - startTime) / (float) 1000;
    }


    public static void main(String[] args) {
        int power_10_start = 0;
        int power_10 = 7 + 1;
        float[] total_time = new float[(power_10) * 6];
        BigInteger[] total_step = new BigInteger[(power_10) * 6];

        for (int pwr_10 = power_10_start; pwr_10 < power_10; pwr_10++) {
            String str = "a";
            String total_str = "";
            for (int i = 0; i < Math.pow(10, pwr_10); i++) {
                total_str += str;
            }
            System.out.println(Math.pow(10, pwr_10) + " init finish");
            for (int i = 0; i < 3; i++) {
                //total time used
                total_time[i + pwr_10 * 6] = bigOn(total_str);
                System.out.print("\nbigOn Time: ");
                System.out.println(total_time[i + pwr_10 * 6] + " s");
                total_time[i + pwr_10 * 6 + 3] = bigOnsquare(total_str);
                System.out.print("\nbigOnsquare Time: ");
                System.out.println(total_time[i + pwr_10 * 6 + 3] + " s");
                //primitive steps
                total_step[i + pwr_10 * 6] = bigOn_steps(total_str);
                System.out.print("\nbigOn step: ");
                System.out.println(total_step[i + pwr_10 * 6] + " steps");
                total_step[i + pwr_10 * 6 + 3] = bigOnsquare_steps(total_str);
                System.out.print("\nbigOnsquare step: ");
                System.out.println(total_step[i + pwr_10 * 6 + 3] + " steps");
            }
        }
        try {
            FileWriter myWriter_time = new FileWriter("result_time.txt");
            FileWriter myWriter_step = new FileWriter("result_steps.txt");
            for (int pwr_10 = power_10_start; pwr_10 < power_10; pwr_10++) {
                for (int i = 0; i < 3; i++) {
                    //O(n)
                    //time used
                    System.out.print(Math.pow(10, pwr_10) + " bigOn Time: ");
                    System.out.println(total_time[i + pwr_10 * 6] + " s\n" );
                    myWriter_time.write( Math.pow(10, pwr_10) + " bigOn Time: " + total_time[i + pwr_10 * 6] + " s\n" );
                    //primitive steps
                    System.out.print(Math.pow(10, pwr_10) + " bigOn steps: ");
                    System.out.println(total_step[i + pwr_10 * 6] + " steps\n" );
                    myWriter_step.write(Math.pow(10, pwr_10) + " bigOn steps: " + total_step[i + pwr_10 * 6] + " steps\n");
                }
                for (int i = 3; i < 6; i++) {
                    //O(n^2)
                    //time used
                    System.out.print(Math.pow(10, pwr_10) + " bigOnsquare Time: ");
                    System.out.println(total_time[i + pwr_10 * 6] + " s\n");
                    myWriter_time.write(Math.pow(10, pwr_10) + " bigOnsquare Time: " + total_time[i + pwr_10 * 6] + " s\n");
                    //primitive step
                    System.out.print(Math.pow(10, pwr_10) + " bigOnsquare steps: ");
                    System.out.println(total_step[i + pwr_10 * 6] + " steps\n");
                    myWriter_step.write(Math.pow(10, pwr_10) + " bigOnsquare steps: " + total_step[i + pwr_10 * 6] + " steps\n");
                }
            }
            myWriter_time.close();
            myWriter_step.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


