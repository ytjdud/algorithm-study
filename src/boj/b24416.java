package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b24416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fib(n) + ' ' + fibonacci(n));
    }

    private static int fibonacci(int n) {
        return 0;
    }

    private static int fib(int n) {
        if (n == 1 || n == 2)   return 1;
        else return (fib(n - 1) + fib(n - 2));
    }
}
