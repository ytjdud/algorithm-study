package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
틀렸습니다! 이유
1. line 35에서 +1 이후 line37,38 조건 추가 안함
2. switch 에서 break(line 55) 추가
3. i=3 일때, amount[2] 가 가능수량 이상이어도 break 가 아닌 1을 더 채워 넣을 수 있음을 간과.
    그래서 line 58~ if-else 로 i=3 일 땐 case1 로 넘어갈 수 있도록
하나 더 있었는데 초반에..
 */


public class b2590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] amount = new int[7];
        for(int i=1;i<7;i++){
            amount[i] = Integer.parseInt(br.readLine());
        }

        int min = amount[6];
        for(int i=5;i>0;i--){
            if(amount[i]>0) {
                int sieve, sqr=0;
                int rest=0, sqr2=0; // 가능한 개수
                if (i > 3) {
                    min += amount[i];
                    rest = (36 - i * i)*amount[i];
                    sieve = 6 - i;
                    if(sieve == 2){
                        sqr2 = rest/4;
                    }
                } else {
                    sqr = 36 / (i * i);
                    min += ( amount[i] / sqr + 1 );
                    sqr = amount[i] % sqr;
                    if(sqr == 0){
                        --min; // 나누어 떨어질때는 line28 에 +1(작업할 last board 가 필요 없음)
                        continue;
                    }
                    rest = 36 - i * i * sqr;
                    sieve = i - 1;

                    if(i==3){
                        sqr2 = 7-2*sqr;
                    }
                }
                switch (sieve) {
                    case 2:
                        if (amount[2] > sqr2) { // 현재 넣을 수 있는 sqr2 보다 보유량이 더 많음
                            amount[2] -= sqr2;
                            if(i==3){
                                rest = 8-sqr;
                            }else {
                                break;
                            }
                        } else {
                            rest -= amount[2]*4; // 1로 채울 수 있는 개수 update
                            amount[2] = 0;
                        }
                    case 1:
                        if (amount[1] > rest) {
                            amount[1] -= rest;
                        } else {
                            amount[1] = 0;
                        }
                        break;
                    case 0:
                        break;
                }
            }
        }
        System.out.println(min);
    }
}
