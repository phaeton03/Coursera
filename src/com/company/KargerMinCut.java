package com.company;

import java.io.*;
import java.util.*;

public class KargerMinCut {
    private ArrayList <Integer> [] adjList;
    private int numOfVertex = 0;
    private int numOfEdges = 0;


    public KargerMinCut(String file) throws IOException{
        File inputFile = new File(file);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        adjList = (ArrayList <Integer> []) new ArrayList [201];
        // Create lines for our Vertices. Each line will be ArrayList.
        for (int i = 1; i < 201; i++){
            adjList[i] = new ArrayList <>();
        }
        String s = reader.readLine();
        while (s != (null)){
            String [] tokens = s.split("\t");
            int vertex = Integer.parseInt(tokens[0]);
            this.numOfVertex++;

            for (int i=0; i < tokens.length; i++){

            }
        }
    }




    public static void maint(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Nick\\Desktop\\kargerMinCut.txt"));
        ArrayList<Integer> people = new ArrayList <Integer> ();
        people.add(0);
        people.size();

    }
}
