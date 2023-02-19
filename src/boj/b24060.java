package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완전 그대로 쓰는건 아님. 로직 추가와 변수 초기값 수정필요.
// 배열로 지역변수로 설정시 메모리와 시간을 차지한다.
// 리턴하는 코드를 추가한다. → why? 루프 탈출 안 할시 시간 초과 될 경우가 있다.

public class b24060 {
    static int cnt = 0;
    static int[] A, tmp;
    static int K, ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[N];
        merge_sort(A,0,N-1);

        System.out.println(ans);
    }
    public static void merge_sort(int[] A, int p, int r) { // A[p..r]을 오름차순 정렬한다.
        if(cnt >= K )    return;
        if (p < r) {
            int q = (p + r) / 2;      // q는 p, r의 중간 지점
            merge_sort(A, p, q);      // 전반부 정렬
            merge_sort(A, q + 1, r);  // 후반부 정렬
            merge(A, p, q, r);        // 병합
        }
    }

    // A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
    // A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
    public static void merge(int[] A, int p, int q, int r) { // p=i=0 q=0 r=1 j=1 t=1
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j])
                tmp[t++] = A[i++]; // tmp[t] <- A[i]; t++; i++;
            else
                tmp[t++] = A[j++]; // tmp[t] <- A[j]; t++; j++;
        }
        while (i <= q)  // 왼쪽 배열 부분이 남은 경우
            tmp[t++] = A[i++];
        while (j <= r)  // 오른쪽 배열 부분이 남은 경우
            tmp[t++] = A[j++];

        i = p;
        t = 0;
        while (i <= r) {  // 결과를 A[p..r]에 저장
            A[i] = tmp[t];
            if(++cnt == K){
                ans = tmp[t];
                break;
            }
            i++; t++;
        }
    }
}
