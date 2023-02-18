package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt =0;
        int num =666;
        String itos;
        while(N!=cnt){
            itos = Integer.toString(num++);
            if(itos.contains("666")) {
                cnt++;
            };
        }
        System.out.println(num-1);
    }
}
