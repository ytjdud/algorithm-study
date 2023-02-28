package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("-");
        int len = S.length;

        int sum=0;
        if(S[0].contains("+")){
            String[] s = S[0].split("\\+");
            for(String ss:s){
                sum+=Integer.parseInt(ss);
            }
        }else{
            if(S[0].charAt(0) == '0'){
                while(S[0].charAt(0) == '0'){
                    S[0] = S[0].replaceFirst("0","");
                }
            }
            sum += Integer.parseInt(S[0]);
        }

        for(int i=1;i<len;i++){
            if(S[i].contains("+")){
                String[] s = S[i].split("\\+");
                int tmp=0;
                for(String ss:s){
                    tmp+=Integer.parseInt(ss);
                }
                sum -= tmp;
            }else{
                if(S[i].charAt(0) == '0'){
                    while(S[i].charAt(0) == '0'){
                        S[i] = S[i].replaceFirst("0","");
                    }
                }
                sum -= Integer.parseInt(S[i]);
            }
        }

        System.out.println(sum);
    }
}
