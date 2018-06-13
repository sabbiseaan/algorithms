package com.activeio.sort.quick_sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    private static List<Integer> sort(List<Integer> v) {
        return qsort(v, 0, v.size() - 1);
    }

    private static List<Integer> qsort(List<Integer> v, int low, int high) {
        if (low < high) {
            int p = partition(v, low, high);
            qsort(v, low, p);
            qsort(v, p + 1, high);
        }

        return v;
    }

    private static int partition(List<Integer> v, int low, int high) {
        Integer pivot = v.get(low);

        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i = i + 1;
            } while (v.get(i) < pivot);

            do {
                j = j - 1;
            } while (v.get(j) > pivot);

            if (i >= j) {
                return j;
            }

            Integer vi = v.get(i);
            Integer vj = v.get(j);

            v.set(i, vj);
            v.set(j, vi);
        }
    }

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(1);
        values.add(4);
        values.add(2);
        values.add(8);
        values.add(9);
        values.add(3);

        for (Integer i : sort(values)) {
            System.out.println(i.toString());
        }
    }
}
