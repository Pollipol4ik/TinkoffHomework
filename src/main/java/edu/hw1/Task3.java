package edu.hw1;

public class Task3 {
    protected Task3() {

    }

    public boolean isNestable(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int minArr1 = arr1[0];
        int maxArr1 = arr1[0];
        int minArr2 = arr2[0];
        int maxArr2 = arr2[0];

        for (int num : arr1) {
            minArr1 = Math.min(minArr1, num);
            maxArr1 = Math.max(maxArr1, num);
        }

        for (int num : arr2) {
            minArr2 = Math.min(minArr2, num);
            maxArr2 = Math.max(maxArr2, num);
        }

        return minArr1 > minArr2 && maxArr1 < maxArr2;
    }

}
