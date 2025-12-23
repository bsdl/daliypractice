package hard._0149;

import java.util.HashMap;
import java.util.Map;

class Max_Points_on_a_Line {
    public int maxPoints(int[][] points) {
        if(points.length < 3) {
            return points.length;
        }
        int maxLen = 0;
        for(int i = 0; i < points.length - 1; i++) {
            int lineLen = 0;
            int samePoints = 0;
            Map<String, Integer> sameSlope = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if(dy == 0 && dx == 0) {
                    samePoints++;
                    continue;
                }
                int gcd = getGcd(dy, dx);
                if(gcd != 0) {
                    dy /= gcd;
                    dx /= gcd;
                }
                String slope = String.valueOf(dy) + "/" + String.valueOf(dx);
                sameSlope.put(slope, sameSlope.getOrDefault(slope, 0) + 1);
                lineLen = Math.max(lineLen, sameSlope.get(slope));
            }
            maxLen = Math.max(maxLen, lineLen + samePoints + 1);
        }
        return maxLen;
    }

    private int getGcd(int x, int y) {
        if(y == 0) {
            return x;
        }else {
            return getGcd(y, x % y);
        }
    }


    public static void main(String[] args) {
        int [][] points = {{0,0}};
        Max_Points_on_a_Line m = new Max_Points_on_a_Line();
        m.maxPoints(points);
    }
}