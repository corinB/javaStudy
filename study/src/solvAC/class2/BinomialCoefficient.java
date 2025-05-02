package solvAC.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient {
    public static int pactorial(int n) {
        if (n == 1) return 1;
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(pactorial(n) / (pactorial(m) * pactorial(n - m)));
    }
}
