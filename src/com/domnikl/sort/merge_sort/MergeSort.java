package com.domnikl.sort.merge_sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static List<Integer> sort(List<Integer> v) {
        if (v.size() <= 1) {
            return v;
        }

        int countLeft = v.size() / 2;

        // split into two lists, left and right
        List<Integer> left = v.subList(0, countLeft);
        List<Integer> right = v.subList(countLeft, v.size());

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();

        // consume the same amount of elements from both left and right, if one is longer, it will be handled below
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left = left.subList(1, left.size());
            } else {
                result.add(right.get(0));
                right = right.subList(1, right.size());
            }
        }

        while (left.size() > 0) {
            result.add(left.get(0));
            left = left.subList(1, left.size());
        }

        while (right.size() > 0) {
            result.add(right.get(0));
            right = right.subList(1, right.size());
        }

        return result;
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

        List<Integer> sorted = MergeSort.sort(values);

        for (Integer i : sorted) {
            System.out.println(i.toString());
        }
    }
}
