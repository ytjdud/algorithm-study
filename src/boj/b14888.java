package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14888 {
    static int N;
    static int[] a;
    static int[] cal = new int[4];
    static int min=Integer.MAX_VALUE, max = Integer.MIN_VALUE, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        get_minmax(a[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    // 백트래킹 하는건 연산자[] 뿐이므로 a[] 인덱스관리는 따로
    private static void get_minmax(int total, int idx) {
        if(idx == N){
            if(total>max)   max = total;
            if(total<min)  min = total;
            return;
        }

        for(int i =0;i<4;i++){
            if(cal[i] > 0){
                cal[i] -= 1;
                switch (i){
                    // 매개변수 이렇게하면 total 다시 돌아오는 것도 한번에 됨
                    case 0: get_minmax(total+a[idx], idx+1); break;
                    case 1: get_minmax(total-a[idx], idx+1); break;
                    case 2: get_minmax(total*a[idx], idx+1); break;
                    case 3: get_minmax(total/a[idx], idx+1); break;
                }
                cal[i] += 1;
            }
        }
    }
}
