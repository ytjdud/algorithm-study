package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int distance = endPoint - startPoint;

            int sqrt = (int) Math.ceil(Math.sqrt(distance));
            int ans ;

            int close_to_odd_upper_bound = sqrt*sqrt - distance;
            int close_to_even_upper_bound = (sqrt-1)*sqrt - distance;
            if(close_to_odd_upper_bound < 0){
                ans = (sqrt-1) * 2;
            }else if(close_to_even_upper_bound < 0){
                ans = sqrt * 2 - 1;
            }else{
                int diff = close_to_odd_upper_bound - close_to_even_upper_bound;
                if(diff > 0){ //  even 에 더 가깝
                    ans = (sqrt-1) * 2;
                }else{
                    ans = sqrt * 2 - 1;
                }
            }

            System.out.println(ans);
        }
    }
}
