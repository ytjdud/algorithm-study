package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b11559 {
    static String[][] field = new String[12][6];
    static boolean[][] visitedMap;
    static boolean[][] visitedPuyo;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    static String puyo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i< 12; i++){
            String[] line = br.readLine().split("");
            for (int j = 0; j < 6; j++){
                String now = line[j];
                field[i][j] = now;
            }
        }



        int total = 0;
        while( isBombed() ){
            total++;
        }

        System.out.println(total);
    }

    private static boolean isBombed() {
        boolean isBombed = false;
        visitedMap = new boolean[12][6];

        for (int i = 0 ; i< 12; i++){
            for (int j = 0; j < 6; j++) {
                if (visitedMap[i][j] || field[i][j].equals(".")) continue;

                visitedPuyo = new boolean[12][6];
                puyo = field[i][j];
                if (bfs(new Point(i, j)) >= 4) {
                    chainReaction();
                    isBombed = true;
                }

            }
        }

        dropAll();

        return isBombed;
    }

    private static void dropAll() {
        for (int i = 0 ; i< 6; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 11; j >=0 ; j--) {
                sb.append(field[j][i]);
            }
            String dropAfter = sb.toString().replace(".","");
            if(dropAfter.isEmpty())    continue;

            String[] splitDropAfter = dropAfter.split("");
            for(int j = 0; j<splitDropAfter.length; j++){
                field[11-j][i] = splitDropAfter[j];
            }
            for(int j = splitDropAfter.length; j<12; j++){
                field[11-j][i] = ".";
            }
        }
    }

    private static void chainReaction() {
        for (int i = 0 ; i< 12; i++){
            for (int j = 0; j < 6; j++) {
                if ( puyo.equals(field[i][j]) && visitedPuyo[i][j]){
                    field[i][j] = ".";
                }

            }
        }
    }

    private static int bfs(Point point) {
        Queue<Point> q = new LinkedList<>();

        q.add(point);
        visitedMap[point.x][point.y] = visitedPuyo[point.x][point.y] = true;

        int puyoCnt = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();

            for(int i = 0; i< 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if( !(nextX >= 0 && nextX < 12 && nextY >=0 && nextY < 6) ) continue;
                if( !puyo.equals(field[nextX][nextY]) )   continue;
                if( visitedMap[nextX][nextY] ) continue;
                if( visitedPuyo[nextX][nextY] ) continue;

                q.add(new Point(nextX, nextY));
                visitedMap[nextX][nextY] = visitedPuyo[nextX][nextY] = true;
                puyoCnt ++;
            }
        }

        return puyoCnt;
    }

}
