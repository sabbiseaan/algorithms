package com.domnikl.sort.bubble_sort;

public class BubbleSort {
    private static int[] sort(int[] a) {
        int[] v = a.clone();
        int n = a.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i <= n - 1; i++) {
                if (v[i - 1] > v[i]) {
                    int b = v[i - 1];
                    int c = v[i];

                    v[i - 1] = c;
                    v[i] = b;

                    swapped = true;
                }
            }
        } while(swapped); // run until nothing was changed

        return v;
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 4, 2, 8 };
        int[] sorted = BubbleSort.sort(values);

        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
