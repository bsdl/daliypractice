package medium._0457;

class Circular_Array_Loop {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            int slow = i, fast = i;
            int lastSlow = slow, lastfast = fast;
            while(true) {
                if(nums[i] == 0) {
                    break;
                }
                lastSlow = slow;
                slow = (slow + nums[slow] + 5000 * len) % len;
                if(lastSlow == slow || nums[slow] * nums[i] < 0 || nums[slow] == 0) {
                    setZero(nums, i);
                    break;
                }
                lastfast = fast;
                fast = (fast + nums[fast] + 5000 * len) % len;
                if(lastfast == fast || nums[fast] * nums[i] < 0 || nums[fast] == 0) {
                    setZero(nums, i);
                    break;
                }
                lastfast = fast;
                fast = (fast + nums[fast] + 5000 * len) % len;
                if(lastfast == fast || nums[fast] * nums[i] < 0 || nums[fast] == 0) {
                    setZero(nums, i);
                    break;
                }
                if(slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setZero(int[] nums, int cur) {
        int last;
        while(true) {
            last = cur;
            cur = (cur + nums[cur] + 5000 * nums.length) % nums.length;
            if(nums[cur] == 0 || nums[last] * nums[cur] < 0) {
                nums[last] = 0;
                break;
            }
            nums[last] = 0;
        }
    }

    public static void main(String[] args) {
        Circular_Array_Loop c = new Circular_Array_Loop();
        c.circularArrayLoop(new int[] {-2,1,-1,-2,-2});
    }
}