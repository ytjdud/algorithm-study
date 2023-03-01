package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 내림차순 아이디어
// long -> 37892KB, 488ms
// int, min 계산 시에만 long으로 cast -> 37020KB, 420ms

public class b13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(br.readLine());
        long[] distance = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        // int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] price = new long[cities];
        StringTokenizer st = new StringTokenizer(br.readLine());
        price[0] = Long.parseLong(st.nextToken());
        for(int i=1;i<cities;i++){
            price[i] = Math.min(price[i - 1], Long.parseLong(st.nextToken()));
        }

        long min=0;
        int distances = cities-1;
        for(int i=0;i<distances;i++){
            min += distance[i]*price[i];
        }

        System.out.println(min);
    }
}
