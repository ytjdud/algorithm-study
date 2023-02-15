package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] s = new int[N];
        int[] m = new int[8001];
        ArrayList<Integer> mm = new ArrayList<>();

        int mean=0,median,mode=-1,range;
        int input;

        for(int i=0;i<N;i++){
            input = Integer.parseInt(br.readLine());
            s[i] = input;
            mean += input;
            m[input+4000]++;
        }
        Arrays.sort(s);

        mean = (int) Math.round((double)mean/N);
        System.out.println(mean);
        median = s[N/2];
        System.out.println(median);

        int mode_cnt = 0;
        for(int i=0;i<8001;i++){
            if(m[i]>0){
                if(m[i] == mode_cnt){
                    mm.add(mode);
                    mode = i-4000;
                    mm.add(mode);
                }else if(m[i]>mode_cnt){
                    mm.clear();
                    mode = i-4000;
                    mode_cnt = m[i];
                }
            }
        }
        if(mm.isEmpty()){
            System.out.println(mode);
        }else{
            mm.sort(Comparator.reverseOrder());
            mode = mm.get(mm.size()-2);
            System.out.println(mode);
        }

        range = s[N-1] - s[0];
        System.out.println(range);
    }
}
