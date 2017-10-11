package com.activeio.bubble_sort;

public class BubbleSort {
    private static int[] sort(int[] a) {
        int n = a.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i <= n - 1; i++) {
                if (a[i - 1] > a[i]) {
                    int b = a[i - 1];
                    int c = a[i];

                    a[i - 1] = c;
                    a[i] = b;

                    swapped = true;
                }
            }

        } while(swapped);

        return a;
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 4, 2, 8 };
        int[] sorted = BubbleSort.sort(values);

        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
