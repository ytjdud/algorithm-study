package programmers;

public class p12931 {
    public int solution(int n) {

        int answer = 0;

        while(n>9){
            answer += n%10;
            n = n/10;
        }

        answer += n;

        return answer;
    }
}
