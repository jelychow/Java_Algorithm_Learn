public class LeetCode27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            // 定义一个 [0,p] 存放 非 val 元素

            int p = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]!=val){
                    swap(nums,p++,i);
                }
            }
            return p;
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
