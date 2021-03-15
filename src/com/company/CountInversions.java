package com.company;

import java.io.*;
import java.util.Arrays;

public class CountInversions {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Nick\\Desktop\\ArrayInt3.csv"));
        long[] arrayA = new long[100_000];
        long[] arrayC = new long[100_000];
        int i = 0;
        String st;
        while ((st = reader.readLine()) != (null)) {
            arrayA[i] = Long.parseLong(st);
            arrayC[i] = arrayA[i];
            i++;
        }
        System.out.println(i);
        System.out.println(Arrays.toString(arrayC));
        reader.close();
        long[] arrayB = {5, 3, 8, 9, 1, 7, 0, 2, 6, 4 };
        long invb = getMergeSort(arrayA);
        //long testInvB = simpleInvCount(arrayC);
        System.out.println(invb);
        //System.out.println(testInvB);
        //System.out.println( (float) testInvB / invb);

    }
    public static long simpleInvCount(long [] A){
        long invCount = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < i; j++){
                if (A[i] < A[j])
                    invCount++;
            }
        }
        return invCount;
    }
// Получим от сортированный массив методом Слияния

    public static long getMergeSort(long[] A) {
        long invCount = 0;
        if (A.length == 0 || A.length == 1) return 0;
        else {
            int mid = A.length / 2 ;
            long[] left = Arrays.copyOfRange( A, 0, mid); // Левая часть массива
            long[] right = Arrays.copyOfRange( A, mid, A.length); // Правая часть массива
             invCount += getMergeSort(left);
             invCount += getMergeSort(right);

             invCount += toMerge(A,left,right);
            return invCount;

        }
    }
// Метод который непосредственно считает количество инверсий и возвращает отсортированный массив
    public static long toMerge(long [] A, long [] left, long [] right){
        long [] temp = new long [left.length + right.length];
        int i = 0, // индекс массива С
        j = 0, // индекс массива Д
        k=0, // индекс итогового массива temp
        invCount = 0; // количество перестановок

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                temp[k++] = left[i++];
            } else{
                temp[k++] = right[j++];
            invCount = invCount + (left.length - i);
            }
        }

        while (i < left.length){
            temp[k++] = left[i++];
        }

        while (j < right.length){
            temp[k++] = right[j++];
        }
        // Составляем заново переданный массив А
        for (k=0; k < temp.length; k++){
            A[k] = temp[k];
        }

        return invCount;
    }
}



