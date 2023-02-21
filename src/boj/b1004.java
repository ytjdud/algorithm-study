package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            while(n-- >0){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean startpoint = is_contained(x1,y1,cx,cy,r);
                boolean endpoint = is_contained(x2,y2,cx,cy,r);

                // XOR, startpoint 와 endpoint 가 both True 면 두 점이 한 원에 포함되어 있는 것이므로 through 하지 않음
                if((startpoint||endpoint) && !(startpoint&&endpoint))    cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean is_contained(int x, int y, int cx, int cy, int r) {
        double inter_dis = Math.sqrt(Math.pow(cx-x, 2)+Math.pow(cy-y,2));
        return (inter_dis < r);
    }
}
