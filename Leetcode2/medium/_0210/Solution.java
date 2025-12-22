package com.bsdl.medium._0210;

import java.util.Stack;

public class Solution {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();
        int[][] adjacency = new int[numCourses][numCourses];
        int[] isChecked = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adjacency[prerequisite[0]][prerequisite[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(adjacency, isChecked, i, stack)) {
                return new int[0];
            }
        }
        int[] order = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; --i) {
            order[i] = stack.pop();
        }
        return order;
    }

    private boolean hasCircle(int[][] adjacency, int[] isChecked, int i, Stack<Integer> stack) {
        if (isChecked[i] == 1) {
            return true;
        }
        if (isChecked[i] == -1) {
            return false;
        }
        isChecked[i] = 1;
        for (int j = 0; j < isChecked.length; j++) {
            if (adjacency[i][j] == 1 && hasCircle(adjacency, isChecked, j, stack)) {
                return true;
            }
        }
        isChecked[i] = -1;
        stack.push(i);
        return false;
    }


}
