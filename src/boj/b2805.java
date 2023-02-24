package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// upper bound

public class b2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        int max =0;
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(max< trees[i])   max = trees[i];
        }

        int min=0, mid;
        while(min<max){
            mid = (min+max)/2;

            long total =0; // 한 나무당 최대 10억 -> sum 계산 과정에서 overflow 발생 가능 (int: 21억..)
            for(int i=0;i<N;i++){
                int rest = trees[i]-mid;
                if(rest>0)  total+=rest;
            }

            if(total<M){ // 원하는 나무 높이에 못미칠때 == 높이를 낮춰서 더 길게 잘리도록
                max = mid;
            }else{ // 원하는 나무 높이보다 넘거나 같을때 == 높이를 올려서 더 짧게 짤리도록
                min = mid+1;
            }

        }
        System.out.println(min-1); // upper bound 방식을 사용하므로(더이상 이분탐색을 하지 않을때 종료), 최종 결과는 -1 이 되어야한다.
    }
}
