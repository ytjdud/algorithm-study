package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(P);

        int min =0;
        for(int p:P){
            min += N*p;
            N--;
        }
        System.out.println(min);
    }
}

// 입력 범위를 알면 counting sort 를 쓰는 것이 유용하다. -메모리 -시간
