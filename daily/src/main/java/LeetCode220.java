import java.util.TreeMap;

public class LeetCode220 {

    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int left = 0,right = 0,len = nums.length;
            // 滑动窗口+二分查找树
            // 本题有3个关键 1 维护窗口合法性 2 先比较再加入窗口，与一般的窗口不同 3使用二分查找树来快速查找窗口数据
            TreeMap<Long, Integer> treeMap = new TreeMap<>();
            while (right<len){
                while (right-left>k){
                    if (treeMap.get((long)nums[left])==1){
                        treeMap.remove((long)nums[left]);
                    }else {
                        treeMap.put((long)nums[left],treeMap.get((long)nums[left])-1);
                    }
                    left++;
                }
                Long ceiling = treeMap.ceilingKey((long)nums[right]-(long)t);
                if(ceiling!=null&&ceiling<=(long)nums[right]+(long)t){
                    return true;
                }
                treeMap.put((long)nums[right],treeMap.getOrDefault((long)nums[right],0)+1);
                right++;
            }
            return false;
        }
    }
}
