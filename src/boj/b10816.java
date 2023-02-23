package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// counting 정렬로도 풀 수 있지만 binary search 이용해보기
// lower bound 와 upper bound 이용 <- 여기에 쓰이는 것이 binary search

public class b10816 {
    static int[] n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            int cnt = get_upper_bound(target) - get_lower_bound(target);
            sb.append(cnt).append(' ');
        }
        System.out.println(sb);
    }

    private static int get_upper_bound(int target) {
        int start =0, end =n.length, mid;
        if(n[end-1] == target)    return end;

        while(start<end){
            mid=(start+end)/2;

            if(target < n[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }

    private static int get_lower_bound(int target) {
        int start =0, end =n.length, mid;
        if(n[0] == target)    return 0;

        while(start<end){
            mid=(start+end)/2;

            if(target <= n[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
