package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        Arrays.sort(P);
        int[] cs = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cs[Integer.parseInt(st.nextToken())]++;
        }

        int min =0;
//        for(int p:P){
//            min += N*p;
//            N--;
//        }
        for(int i=0;i<1001;i++){
            while(cs[i]-- >0){
                min += N*i;
                N--;
            }
        }
        System.out.println(min);
    }
}

// 입력 범위를 알면 counting sort 를 쓰는 것이 유용하다. -메모리 -시간
