package solvAC.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MySet {
    private int[] set;

    public MySet() {
        this.set = new int[20];
    }

    public void add(int num) {
        set[num-1] = num;
    }

    public void remove(int num) {
        set[num-1] = 0;
    }

    public int check(int num) {
        if (set[num-1] == 0)
            return 0;
        else
            return 1;
    }

    public void toggle(int num) {
        if (set[num-1] == 0)
            set[num-1] = num;
        else
            set[num-1] = 0;
    }

    public void all() {
        for (int i = 1; i <= 20; i++) {
            set[i-1] = i;
        }
    }

    public void empty() {
        for (int i = 0; i < 20; i++) {
            set[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        MySet s = new MySet();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    s.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    s.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(s.check(Integer.parseInt(st.nextToken()))).append('\n');
                    break;
                case "toggle":
                    s.toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    s.all();
                    break;
                case "empty":
                    s.empty();
                    break;
            }
        }
        System.out.println(sb);
    }
}



