package solvAC.class2;
import java.io.*;
import java.util.*;

public class Balance {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

        while (true) {
            String str = br.readLine(); // 사용자 입력 받기
            if (str.equals(".")) break; // "." 하나만 입력되면 종료

            Stack<Character> stack = new Stack<>(); // 매 줄마다 새로운 스택 생성
            boolean isBalanced = true; // 균형 여부를 나타내는 플래그

            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c); // 여는 괄호는 스택에 저장
                } else if (c == ')') {
                    // 닫는 소괄호인데 짝이 맞지 않으면 균형 깨짐
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break; // 더 이상 검사할 필요 없음
                    }
                    stack.pop(); // 괄호 쌍이 맞으면 pop
                } else if (c == ']') {
                    // 닫는 대괄호인데 짝이 맞지 않으면 균형 깨짐
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop(); // 괄호 쌍이 맞으면 pop
                }
            }

            // 모든 문자 검사 후 스택이 비어있지 않으면 아직 짝 안 맞은 여는 괄호가 있음
            if (!stack.isEmpty()) isBalanced = false;

            // 결과에 따라 "yes" 또는 "no" 추가
            sb.append(isBalanced ? "yes\n" : "no\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
