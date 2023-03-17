package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 팀의 수
        int S = Integer.parseInt(st.nextToken()); // 카약 손상 수
        int R = Integer.parseInt(st.nextToken()); // 카약 하나 더 가져온 팀
        int[] kayaks = new int[N+2];
        Arrays.fill(kayaks, 1);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++){
            kayaks[Integer.parseInt(st.nextToken())] = 0;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++){
            kayaks[Integer.parseInt(st.nextToken())]++;
        }

        int cnt =0;
        for(int i=0;i<=N;i++){
            if(kayaks[i] > 0){
                kayaks[i]--;
            }else{ // -1 인 경우
                if(kayaks[i-1] < 1){ // 전자에서 못빌리는 병우
                    if(kayaks[i+1] == 2){
                        kayaks[i+1]--;
                    }else{
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
