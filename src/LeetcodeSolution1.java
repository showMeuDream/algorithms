//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表

/**
 * @author YT.Luniaru
 */
public class LeetcodeSolution1 {

    public int[] twoSum(int[] nums, int target) {

        // 用于存放结果数组
        int[] arr = new int[2];

        // 进行目标数组遍历
        for (int i = 0;i<=nums.length-1;i++){

            // 用于记录target-nums[i]的变量
            int reduce = target - nums[i];

            for (int j = i+1;j<=nums.length-1;j++){
                if (nums[j] == reduce){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }

        return arr;
    }
}
