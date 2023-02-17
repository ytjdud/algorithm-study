package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//  나이 순, 나이가 같으면 가입한 순
// 정답처리되었으나 질문 미해결

public class b10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        String s[][] = new String[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            s[i][0] =st.nextToken();
            s[i][1] =st.nextToken();
        }

        Arrays.sort(s, (s1, s2) ->{
            if(s1[0].equals(s2[0])){
                return 0; // 그대로
            }else{
                return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
                /*
                s1[0].compareTo(s2[0]); 이 안되는 이유?
                *1이 리턴되면 두 객체의 자리가 바뀌며(오름차순 정렬), 0이나 -1일 경우엔 바뀌지 않는다.*

                * 예) String "10" 과 String "3" 비교
                Integer.parseInt 로 String->int 변환시, 3, 10 오름차순 정렬이된다.
                하지만 String의 compareTo 사용 시, "10"의 첫번째 "1" 과 "3" 이 비교된다. 따라서 10, 3 으로 정렬된다.

                 */
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(s[i][0]).append(" ").append(s[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
