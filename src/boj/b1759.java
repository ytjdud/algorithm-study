package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1759 {
    static int password_len, alphabets; // 4 6 -> 6개 중 4개 선택
    static String[] a; // alphabets
    static String[] password; // 출력용
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        password_len = Integer.parseInt(st.nextToken());
        alphabets = Integer.parseInt(st.nextToken());
        password = new String[password_len];

        a = br.readLine().split(" ");
        Arrays.sort(a);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if(depth == password_len){
            if(is_possible(password)){
                for(String s: password){
                    sb.append(s);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i = start; i< alphabets; i++){
            password[depth] = a[i];
            dfs(i+1,depth + 1);
        }
    }

    private static boolean is_possible(String[] arr) {
        // 모음 1개, 자음 2개 있는지
        int v =0, c=0;
        for(int i = 0; i< password_len; i++){
            if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
                v++;
            }else{
                c++;
            }
        }

        return v > 0 && c > 1;
    }
}
