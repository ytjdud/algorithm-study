package programmers;

import java.util.ArrayList;

public class p150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //int[] answer = {}; 가 주어졌지만 .add 해야므로 ArrayList 를 사용한다.
        ArrayList<Integer> answer = new ArrayList<>();

        Date tday = get_Date(today);

        for(int i = 0; i < privacies.length; i++){ // result 숫자때매 for i 써야함
            Date privacy_date = get_Date(privacies[i].split(" ")[0]);
            String privacy_terms = privacies[i].split(" ")[1];

            // 해당 약관 몇달인지 확인()
            int month = get_month(terms, privacy_terms);
            // 약관 달수 계산()
            privacy_date = calculate(privacy_date, month);
            // 반환값이랑 오늘 날짜 비교(), T 면 answer 에 i 넣기
            if (compare_date(privacy_date, tday)){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    // 약관 달수 계산()
    public Date calculate(Date date, int months){
        int years = months/12;
        months = months%12;

        date.y += years;
        date.m += months;

        if(date.m > 12){
            date.y ++;
            date.m -= 12;
        }
        return date;
    }

    // 해당 약관 몇달인지 확인()
    public static int get_month(String[] terms, String kinds){
        int month = 0;

        for(int i =0; i< terms.length; i++){
            if( terms[i].startsWith(kinds)){
                month = Integer.parseInt(terms[i].split(" ")[1]);
                break;
            }
        }

        return month;
    }

    // 계산된 날짜랑 오늘 날짜 비교 (파기 해야하면 T)
    public boolean compare_date(Date privacy, Date tday){
        boolean b = false;

        if(privacy.y < tday.y){ // 오늘자 년도가 더 크면 (이미 해 지남)
            b = true;
        } else if(privacy.y == tday.y){
            if(privacy.m < tday.m){ // 오늘자 달이 더 크면 (이미 달 지남)
                b = true;
            } else if(privacy.m == tday.m){
                if(privacy.d <= tday.d){
                    b = true;
                }
            }
        }

        return b;
    }

    public Date get_Date(String date){
        String[] split_date = date.split("[.]"); // 이번 문제 포인트인듯함

        return new Date(Integer.parseInt(split_date[0]), Integer.parseInt(split_date[1]), Integer.parseInt(split_date[2]));
    }

}

class Date{
    public int y, m, d;

    public Date(int y, int m , int d){
        this.y = y;
        this.m = m;
        this.d = d;
    }
}
