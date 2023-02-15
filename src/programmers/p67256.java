package programmers;

import java.util.Objects;

public class p67256 {
    static int l = 10;
    static int r = 12;

    public static String solution(int[] numbers, String hand) {
        // String answer = "";
        StringBuilder answer = new StringBuilder();

        for(int n:numbers){
            switch(n){
                case 1:
                case 4:
                case 7:
                    l = n;
                    answer.append("L");
                    break;
                case 3:
                case 6:
                case 9:
                    r = n;
                    answer.append("R");
                    break;
                case 0:
                    n = 11;
                case 2:
                case 5:
                case 8:
                    int diff = left_or_right(l, n, r);
                    if (diff > 0){ // 왼손이 더 먼거
                        r = n;
                        answer.append("R");
                    }else if(diff < 0){
                        l = n;
                        answer.append("L");
                    }else{
                        if(Objects.equals(hand, "left")){
                            l = n;
                            answer.append("L");
                        }else{
                            r = n;
                            answer.append("R");
                        }
                    }
                    break;
            }
        }

        return answer.toString();
    }

    private static int left_or_right(int l, int n, int r) {
        int ln_distance = (Math.abs(l-n)/3)+(Math.abs(l-n)%3);
        int rn_distance = (Math.abs(r-n)/3)+(Math.abs(r-n)%3);

        return ln_distance-rn_distance;
    }

    public static void main(String[] args) {
        int[] a = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        System.out.println(solution(a, "left"));
    }
}
