package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1978 {
    static boolean[] divided = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt =0;

        is_divided();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-- >0){
            int n = Integer.parseInt(st.nextToken());
            if (!divided[n]) cnt++;
        }

        System.out.println(cnt);
    }

    private static void is_divided() {
        divided[0] = true;
        divided[1] = true;

        for(int i=2; i<32;i++){
            if(divided[i])    continue;
            for(int j=i*i;j<1001;j+=i){
                divided[j] = true;
            }
        }
    }
}
