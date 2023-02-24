package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// upper bound (최대로 가질 수 있는 최소)

public class b2110 {
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for(int i=0;i<N;i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int min=1, max=houses[N-1]-houses[0]+1, mid; // 가장 인접한 공유기간의 거리
        while(min<max){
            mid = (max+min)/2;

            int cnt=1; // 첫번째 집은 무조건 설치
            int prev = houses[0];
            for(int i=1; i<N;i++){
                int now = houses[i];
                if(now-prev>=mid){
                    cnt++;
                    if(cnt>C)  break;
                    prev= now;
                }
            }

            if(cnt<C){ // 설치한 공유기 수가 적음 == 거리를 좁혀서 더 많이 설치하도록
                max = mid;
            }else{ // 설치한 공유기 수가 많거나 적음 == 거리를 넓혀서 덜 설치되도록
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
