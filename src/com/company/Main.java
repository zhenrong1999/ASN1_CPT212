package com.company;

public class Main {
    private static void bigOnsquare(String str) {

        int n = str.length();
        char[] array = new char[n];
        int[] arrayInt = new int[n];
        for (int i = 0; i < n; i++) arrayInt[i] = 0;
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
    }

    private static void bigOn(String str){
        int n = str.length();
        int[] arrayInt = new int[26];

        for (int i=0; i<n;i++){
            arrayInt[str.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            if(arrayInt[str.charAt(i)-'a']%2==0){
                System.out.print(str.charAt(i));
            }
        }
    }


    public static void main(String[] args) {
        String str = "geeksforgeeks";
        bigOn(str);
        System.out.print("\n");
        bigOnsquare(str);
    }
}
