package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 순위는 중복되지 않음을 이용하여 이차원배열이 아닌 일치원(의 인덱스!!)배열을 사용할 수 있다.

public class b1946 {
//    static int[][] grade;
    static int[] g;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T-- >0){
            int cnt=1;
            int n = Integer.parseInt(br.readLine());
            g = new int[n+1];
            for(int i=0;i<n;i++){
               st = new StringTokenizer(br.readLine());
               g[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            int prev_interview_grade = g[1];
            for(int i=2;i<=n;i++){
                int now_interview_grade = g[i];
                if(now_interview_grade < prev_interview_grade){
                    cnt++;
                    if(now_interview_grade == 1) {
                        break;
                    }
                    prev_interview_grade = now_interview_grade;
                }
            }

//            grade = new int[n][2];
//            for(int i=0;i<n;i++){
//                st = new StringTokenizer(br.readLine());
//                grade[i][0] = Integer.parseInt(st.nextToken());
//                grade[i][1] = Integer.parseInt(st.nextToken());
//            }
//            Arrays.sort(grade, Comparator.comparingInt(g -> g[0]));
//
//            int prev_interview_grade = grade[0][1];
//            for(int i =1;i<n;i++){
//                int now_interview_grade = grade[i][1];
//                if(now_interview_grade < prev_interview_grade){
//                    cnt++;
//                    if(now_interview_grade == 1) {
//                        break;
//                    }
//                    prev_interview_grade = now_interview_grade;
//                }
//            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}