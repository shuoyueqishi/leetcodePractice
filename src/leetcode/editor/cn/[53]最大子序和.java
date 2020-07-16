package leetcode.editor.cn;//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public static void main(String [] args) {
        //int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int [] nums = new int[]{1,2};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
    public static int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int max = nums[0];
        int subMax = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(subMax>0) { // 子序列的和大于0
                subMax += nums[i];
            } else { // 子序列的和小于0
                subMax = nums[i];
            }
            // 更新全局最大值
            max = Math.max(max,subMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
