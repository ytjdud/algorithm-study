package algolab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindNextPermutation {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            sb = new StringBuilder();
            char[] chars = br.readLine().split(" ")[1].toCharArray();
            System.out.println(getNext(chars));;
        }
    }

    private static StringBuilder getNext(char[] c) {
        int idx = -1;
        int lastIdx  = c.length-1;

        idx = getReverseEndpoint(c, idx, lastIdx);
        if(idx == -1){
            for(int i=lastIdx; i>=0; i--){
                sb.append(c[i]);
            }
            return sb;
        }

        swapAndReverse(c, idx, lastIdx);
        return sb;
    }

    private static void swapAndReverse(char[] c, int idx, int lastIdx) {
        for(int i = lastIdx; i> idx; i--){
            if(c[i] > c[idx]){
                swap(c, i, idx);
                break;
            }
        }
        for(int i = 0; i<= idx; i++){
            sb.append(c[i]);
        }
        for(int i = lastIdx; i> idx; i--){
            sb.append(c[i]);
        }
    }

    private static int getReverseEndpoint(char[] c, int idx, int lastIdx) {
        for(int i = lastIdx; i>0; i--){
            if(c[i - 1] < c[i]) {
                idx = i-1;
                break;
            }
        }
        return idx;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}