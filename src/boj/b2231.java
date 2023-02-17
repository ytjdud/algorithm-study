package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 원래수 + 각자리 더하기

public class b2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum;
        int ans =0;
        for(int i=0;i<n;i++){
            sum =i;

            String[] sp = Integer.toString(i).split("");
            int len = sp.length;
            for(int j=0;j<len;j++){
                sum += Integer.parseInt(sp[j]);
            }

            if(sum == n){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}

/*
    while(number != 0) {
		sum += number % 10;	// 각 자릿수 더하기
		number /= 10;
	}

	// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
	if(sum + i == N) {
		result = i;
		break;
	}
 */
