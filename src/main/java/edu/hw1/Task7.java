package edu.hw1;

public class Task7 {
    protected Task7() {

    }

    public static int rotateLeft(int n, int shift) {
        if (n < 0 || shift < 0) {
            return -1;
        }
        int cnt = 1;
        int m = n;
        while ((m >>= 1) != 0) {
            cnt++;
        }
        if (n < 0 || shift < 0) {
            return -1;
        }
        return (n << (shift % cnt)) & ((1 << cnt) - 1) | (n >> (cnt - (shift % cnt)));
    }

    public static int rotateRight(int n, int shift) {
        if (n < 0 || shift < 0) {
            return -1;
        }
        int cnt = 1;
        int m = n;
        while ((m >>= 1) != 0) {
            cnt++;
        }
        return (n >> (shift % cnt)) | (n << (cnt - (shift % cnt))) & ((1 << cnt) - 1);
    }

}
