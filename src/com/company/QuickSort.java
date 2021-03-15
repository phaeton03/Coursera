package com.company;

import java.io.*;
import java.util.*;
import java.math.*;

public class QuickSort {
    public static void main ( String args []) throws IOException{
    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Nick\\Desktop\\QuickSort_array.txt"));
    String st;
    int [] arrayA =new int[10_000];
    int i=0;
    while ((st = reader.readLine()) != (null)){
        arrayA[i] = Integer.parseInt(st);
        i++;
    }
    int [] A = {8,0,-99,-9,90,55};
    //swap(A,0,1);
    int comparisonCounts = toQuickSort(arrayA,0,arrayA.length - 1);
        System.out.println(comparisonCounts);
        System.out.println(arrayA.length*Math.log(arrayA.length));
    }

    public static int toQuickSort(int [] A, int leftEndpoint, int rightEndpoint){
        if (leftEndpoint >= rightEndpoint) return 0;
        else  {
            int i_pivotIndex = choosePivot(A, leftEndpoint, rightEndpoint);
            swap(A, i_pivotIndex, leftEndpoint);                            // add pivot element to the start of array
            int j_pivotIndex = Partition(A, leftEndpoint, rightEndpoint); // new number of pivot element after partition
            int comparisonCounts = 0;
            comparisonCounts += rightEndpoint - leftEndpoint;
            comparisonCounts += toQuickSort(A, leftEndpoint, j_pivotIndex - 1);
            comparisonCounts += toQuickSort(A, j_pivotIndex + 1, rightEndpoint);
            return comparisonCounts;
            }
        }


    public static int Partition(int [] A, int leftEndpoint, int rightEndpoint){
       int pivotElement = A[leftEndpoint];
       int i = leftEndpoint + 1;
       for (int j = i; j <= rightEndpoint; j++){
           if ( A[j] < pivotElement ) {
               swap(A,j,i);
               i++;
           }
       }
        swap(A, leftEndpoint, i-1);
        return i-1;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }

    public static int choosePivot(int [] a, int leftEndpoint, int rightEndpoint) {
        int middleIndex = ((rightEndpoint - leftEndpoint) / 2) + leftEndpoint;
        int first = a[leftEndpoint];
        int last = a[rightEndpoint];
        int middle = a[middleIndex];
        int max = Math.max(first,Math.max(last,middle));
        int min = Math.min(first,Math.min(last,middle));
        int medianaIndex = leftEndpoint;
        if ( last < max && last > min)  medianaIndex = rightEndpoint;
        if ( middle < max && middle > min)  medianaIndex = middleIndex;
        return medianaIndex;
    }
}
