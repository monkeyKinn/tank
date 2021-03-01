package com.jinshengcong.dp.strategy;

/**
 * 选择排序的算法
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Sorter {
    public void sort(Cat[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < a.length; j++) {
                minPos = a[j].compareToCat(a[minPos]) == -1 ? j : minPos;
            }
            swap(a, i, minPos);
        }
    }

    private void swap(Cat[] a, int i, int minPos) {
        Cat temp = a[i];
        a[i] = a[minPos];
        a[minPos] = temp;
    }
}
