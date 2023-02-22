package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// R 명령 -> 나올때마다 계속 뒤집는 것이 아님

public class b5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        L1:
        while(T-- >0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            LinkedList<Integer> dq = new LinkedList<>();

            // [ 와 ] 제거 후 , 로 split
            String[] s = arr.replace("[","").replace("]","").split(",");
            int len = s.length;
            for(int i=0;i<len;i++){
                if(s[i].equals("")) break; // [] 와 같이 아무 숫자도 안들어왔을때
                dq.add(Integer.parseInt(s[i]));
            }

            // update the order:p
            p = p.replaceAll("RR", ""); // 연속RR 은 처음과 같다
            p = p.replaceAll("R"," R"); // split 하기 위해
            String[] p_arr = p.split(" ");

            int p_len = p_arr.length;
            for(int i =0;i<p_len;i++){
                // 맨 처음 p가 R 이면 line 32에 의해 p_arr[0] 이 "" 가 들어감.
                if(p_arr[i].equals(""))    continue;

                int cnt_D;
                // DDDD 나 DDRD 처럼 DD만 있을때와 R포함DD 는 D의 개수가 다름
                if(p_arr[i].charAt(0) == 'R')
                    cnt_D = p_arr[i].length()-1;
                else
                    cnt_D = p_arr[i].length();

                if(i%2==0){
                    while(cnt_D-- >0){
                        if(dq.isEmpty()){
                            sb.append("error").append('\n');
                            continue L1;
                        }
                        dq.removeFirst();
                    }
                }else{
                    while(cnt_D-- >0){
                        if(dq.isEmpty()){
                            sb.append("error").append('\n');
                            continue L1;
                        }
                        dq.removeLast();
                    }
                }
            }

            sb.append('[');
            if(!dq.isEmpty()) {
                if ((p_len - 1) % 2 != 0) { // R 이 나온개수가 홀수개 -> 막판뒤집기
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast()).append(',');
                    }
                } else {
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollFirst()).append(',');
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(']').append('\n');

        }
        System.out.println(sb);
    }
}
