package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// y 좌표가 증가하도록 정렬하되, y 좌표가 같으면 x 좌표가 증가하도록

public class b11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] =Integer.parseInt(st.nextToken());
            arr[i][1] =Integer.parseInt(st.nextToken());
        }
        /*           0 1   <- i 줄
        arr[][] = { {3,4},
                    {1,1},
                    {1,-1},
                    {2,2},
                    {3,3} }
        ---
        arr1 arr2 비교
        예) {1,1} {1,-1} 각각은 1차원 이자나
         */

        Arrays.sort(arr, (arr1, arr2) ->{
            if(arr1[1] == arr2[1]){
                return arr1[0] - arr2[0]; // a - b 를 해서 음수가 나오면 a를 왼쪽으로 b를 오른쪽으로 남긴다.
            }else{
                return arr1[1] - arr2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
