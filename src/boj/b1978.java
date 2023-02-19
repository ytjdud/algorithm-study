package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt =0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if (is_prime(n)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean is_prime(int n) {
        if(n == 1)  return false;
        else if(n ==2) return true;
        else{
            for(int i=2; i<n-1; i++){
                if(n%i == 0)    return false;
            }
        }
        return true;
    }
}

/*
1. n/2 까지만 검사해도
2. n의 루트값 까지만 검사해도

에라토스체네스의 체
    static void primeNumber() {
        arr = new int[1001];  //n의 범위가 1000까지이므로 1000 크기의 배열 선언
        int n = 1000;
        //배열 초기화
        for (int i = 2; i <= n; i++) {
            arr[i] = 1;
        }

        //2부터 시작해서 i의 배수들을 배열에서 지워준다
        for (int i = 2; i <= n; i++) { // n 의 루트값보다 작은 수로만 지워도 충분하다.
            //이미 지워진 수는 건너뛴다
            if (arr[i] == 0) continue;
            for (int j = i+i; j <= n; j += i) {
                arr[j] = 0;
            }
        }
    }
 */
