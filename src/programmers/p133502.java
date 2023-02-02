package programmers;

import java.util.*;

public class p133502 {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(a));
    }
    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();

//        // 일단 3개 먼저 넣고
//        for(int i=0; i<3; i++){
//            st.add(ingredient[i]);
//        }
        // 이거 없어야 테스트하나 런타임에러 나는거 고쳐짐

        // 4개째부터 check the lastest set
        for(int i=0; i<ingredient.length; i++){
            st.add(ingredient[i]);
            if(st.size()>=4 // 이거 추가해야 런타임에러 3개 나는거 잡혀짐
                    && st.peek() == 1
                    && st.get(st.size()-2) == 3
                    && st.get(st.size()-3) == 2
                    && st.get(st.size()-4) == 1 ){
                for(int j =0; j<4;j++){
                    st.pop();
                }
                answer ++;
            }
        }
        return answer;
    }
}
