package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 5
        int M = Integer.parseInt(st.nextToken()); // 8
        String[][] DNAs = new String[M][N];
        for(int i=0;i<N;i++){ // 5
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){ // 8
                DNAs[j][i] = st.nextToken();
            }
        }

    }
}
