package leetcode.editor.cn;//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {
    public static void main(String[] args){
        int m=1;
        int n=4;
        int[] nums1 = new int[]{4,0,0,0,0};
        int[] nums2 = new int[]{1,2,5,6};
        merge(nums1,m,nums2,n);
        for(int i=0;i<m+n;i++) {
            System.out.printf("%-4d",nums1[i]);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        if(m==0){
            System.arraycopy(nums2,0,nums1,0,n);
            return;
        }
        int[] temArray=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(k<m+n){
            if (nums1[i]<nums2[j] && i<m) {
                temArray[k++]=nums1[i++];
                if(i>m-1){
                    for(int a=j;a<n;a++){
                        temArray[k++]=nums2[a];
                    }
                }
            } else {
                temArray[k++]=nums2[j++];
                if(j>n-1){
                    for(int a=i;a<m;a++){
                        temArray[k++]=nums1[a];
                    }
                }
            }
        }
        System.arraycopy(temArray,0,nums1,0,m+n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
