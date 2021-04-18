public class LeetCode26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length<=1){
                return nums.length;
            }
            int p = 0;
            // 定义一个闭区间 [0,p] 存放不重复元素
            for(int i = 1;i<nums.length;i++){
                if(nums[i]!=nums[p]){
                    swap(nums,++p,i);
                }
            }
            return p+1;
        }

        void swap(int nums[],int p,int q){
            if (p==q){
                return;
            }
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
        }
    }
}
