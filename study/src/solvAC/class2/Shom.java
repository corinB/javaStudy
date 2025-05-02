package solvAC.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//no.1436
public class Shom {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;

        while (count != n ) {
            if (String.valueOf(num).contains("666")) {
                count++;
            }
            num++;
        }

        System.out.println(num - 1);
    }
}
