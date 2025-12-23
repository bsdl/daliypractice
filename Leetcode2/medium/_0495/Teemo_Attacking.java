package medium._0495;

class Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonTime = 0;
        if(timeSeries.length > 0) {
            for(int i = 1; i < timeSeries.length; i++) {
                poisonTime += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
            }
        }else {
            return poisonTime;
        }    
        return poisonTime + duration;
    }
}