package medium._0207;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        for (int[] prere : prerequisites) {
            adjacency[prere[0]][prere[1]] = 1;
        }
        int[] isChecked = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(adjacency, isChecked, i)) {
                return false;
            }
        }
        return true;
    }

    // dfs
    private boolean hasCircle(int[][] adjacency, int[] isChecked, int i) {
        if(isChecked[i] == 1) {
            return true;
        }
        if(isChecked[i] == -1) {
            return false;
        }
        isChecked[i] = 1;
        for(int j = 0; j < isChecked.length; j++) {
            if(adjacency[i][j] == 1 && hasCircle(adjacency, isChecked, j)) {
                return true;
            }
        }
        isChecked[i] = -1;
        return false;
    }
}
