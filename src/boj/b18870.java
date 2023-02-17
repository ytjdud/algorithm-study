package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class b18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer,Integer> hm = new HashMap<>();
        int rank =0;
        for(int srt:sorted){
            if(!hm.containsKey(srt)){
                hm.put(srt,rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a:arr){
            sb.append(hm.get(a)).append(' ');
        }
        System.out.println(sb);
    }
}
