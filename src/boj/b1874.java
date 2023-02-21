package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int last = 0;
        while(n-- >0){
            int k = Integer.parseInt(br.readLine());
            if(last<k){
                for(int i=last+1;i<=k;i++){
                    st.push(i);
                    sb.append('+').append('\n');
                }
                last = k;
//                st.pop();
//                sb.append('-');
            }else if(st.peek() != k){
                System.out.println("NO");
                return;
            }
            // st.peek()==k || last<k 의 마지막 작업
            st.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
