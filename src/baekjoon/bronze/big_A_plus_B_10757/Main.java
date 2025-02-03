package baekjoon.bronze.big_A_plus_B_10757;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

//        System.out.println("A = " + A);
//        System.out.println("B = " + B);
        System.out.println(A.add(B));
    }
}