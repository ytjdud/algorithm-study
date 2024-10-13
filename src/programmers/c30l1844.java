package programmers;

import java.util.*;
import java.awt.Point;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class c30l1844 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] visited;
    static int answer;

    public int solution(int[][] maps) {
        answer = 0;
        visited = new int[maps.length][maps[0].length];

        Point start = new Point(0,0);
        bfs(start, maps);

        int target = visited[maps.length -1][maps[0].length -1];

        return target == 0 ? -1 : ++target;
    }

    public void bfs(Point point, int[][] maps){
        Queue<Point> q = new LinkedList<>();
        q.add(point);

        while(!q.isEmpty()){
            Point current = q.poll();

            if(point.x == maps.length -1 && point.y == maps[0].length -1){
                return;
            }

            for(int i=0; i<4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                // map에서 벗어나는 경우
                if(nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length )  continue;
                // 이미 방문한 곳인 경우
                if(visited[nextX][nextY] > 0)   continue;
                // 벽인 경우
                if(maps[nextX][nextY] == 0)  continue;

                q.add(new Point(nextX, nextY));
                visited[nextX][nextY] = visited[current.x][current.y] + 1;
            }
        }
    }
}
