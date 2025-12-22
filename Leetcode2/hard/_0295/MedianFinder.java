package com.bsdl.hard._0295;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> bigP;
    PriorityQueue<Integer> smallP;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        bigP = new PriorityQueue<>((t1, t2) -> t2 - t1);
        smallP = new PriorityQueue<>();
    }

    public void addNum(int num) {
        bigP.add(num);
        if ((!(bigP.isEmpty() || smallP.isEmpty()) && bigP.peek() > smallP.peek()) || bigP.size() - smallP.size() > 1) {
            smallP.offer(bigP.poll());
        }
        if (smallP.size() - bigP.size() > 1) {
            bigP.offer(smallP.poll());
        }
    }

    public double findMedian() {
        if (bigP.size() == 0 && smallP.size() == 0) {
            return 0;
        }

        if (bigP.size() == smallP.size()) {
            return (double) (bigP.peek() + smallP.peek()) / 2;
        } else {
            return bigP.size() > smallP.size() ? bigP.peek() : smallP.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for(int i = 1; i < 10; i++) {
            medianFinder.addNum(i);
            double median = medianFinder.findMedian();
            System.out.println(median);
        }

    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */