package edu.hw1;

public class Task7 {
    protected Task7() {

    }

    public static int rotateLeft(int n, int shift) {
        int cnt = 1;
        int m = n;
        while ((m >>= 1) != 0) {
            cnt++;
        }
        return (n << (shift % cnt)) & ((1 << cnt) - 1) | (n >> (cnt - (shift % cnt)));
    }

    public static int rotateRight(int n, int shift) {
        int cnt = 1;
        int m = n;
        while ((m >>= 1) != 0) {
            cnt++;
        }
        return (n >> (shift % cnt)) | (n << (cnt - (shift % cnt))) & ((1 << cnt) - 1);
    }

    public static void main(String[] args) {
        int n1 = 8;
        int shift1 = 1;
        int result1 = rotateRight(n1, shift1);
        System.out.println(result1);

        int n2 = 16;
        int shift2 = 1;
        int result2 = rotateLeft(n2, shift2);
        System.out.println(result2);

        int n3 = 17;
        int shift3 = 2;
        int result3 = rotateLeft(n3, shift3);
        System.out.println(result3);
    }
}
