package com.dabolink;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int prisms = 0;
	    int[] Essences = new int[9];
        Essences[0] = 101;
        Essences[1] = 36;
        Essences[2] = 38;
        Essences[3] = 0;
        Essences[4] = 3;
        Essences[5] = 1;
        Essences[6] = 0;
        Essences[7] = 1;
        Essences[8] = 0;

        Scanner c = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            System.out.println("Enter" + i + ": ");
            int num = c.nextInt();
            Essences[i] = num;
        }
        printEssences(Essences);
/*        Essences = breakUp(Essences);
        printEssences(Essences);*/
        prisms = construct(Essences);
        printEssences(Essences, prisms);
/*      prisms = construct(Essences,3);
        printEssences(Essences,prisms);*/


    }
    public static int[] breakUp(int[] Essences){
        for(int i = 8; i > 0 ; i--){
            Essences[i-1] += Essences[i]*3;
            Essences[i] = 0;
        }
        return Essences;
    }
    public static int construct(int[] Essences){
        int prisms = 0;
        for(int i = 0; i < 8 ; i++){
            prisms += Essences[i]/3;
            Essences[i+1] += Essences[i]/3;
            Essences[i] = Essences[i]%3;

        }
        return prisms;
    }
    public static int construct(int[] Essences, int maxIndex){
        int prisms = 0;
        Essences = breakUp(Essences);
        for(int i = 0; i < maxIndex ; i++){
            prisms += Essences[i]/3;
            Essences[i+1] += Essences[i]/3;
            Essences[i] = Essences[i]%3;

        }
        return prisms;
    }
    public static void printEssences(int[] Essences){
        for(int i = 0; i < 9; i++){
            System.out.print(Essences[i] + " ");
        }
        System.out.println("\n");
    }
    public static void printEssences(int[] Essences,int prisms){
        for(int i = 0; i < 9; i++){
            System.out.print(Essences[i] + " ");
        }
        System.out.println();
        System.out.println("Prisms used: " + prisms + " which costs: " + prisms * 500 + "\n");

    }
}
