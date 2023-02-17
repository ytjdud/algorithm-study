package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// substring 사용하기

public class b11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        HashSet hs = new HashSet();

        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                hs.add(s.substring(i,j));
            }
        }

        System.out.println(hs.size());
    }
}
