package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();

        int cnt = (doc.length()-doc.replace(word,"").length())/word.length();
        System.out.println(cnt);
    }
}
