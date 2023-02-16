package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class b1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");
        Arrays.sort(s, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String st:s){
            sb.append(st);
        }
        System.out.println(sb.toString());
    }
}
