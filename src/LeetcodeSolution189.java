//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组

/**
 * @author YT.Luniaru
 *
 * 旋转数组
 */
public class LeetcodeSolution189 {

    /**
     * 方法二：当我们旋转数组 k 次， k % n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n−k 个元素，就能得到想要的结果。
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){
        k %= nums.length;

        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    /**
     * 先需要一个用于反转数组的方法
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //    /**
//     * 方法一：其实就是每次都把数组的最后一个置于第一个，然后其它的往下移动即可
//     *
//     * @param nums
//     * @param k
//     */
//    public void rotate(int[] nums, int k) {

//------------------------------------------------------------------------------------------------------------
//        // 用于记录循环过后的nums[j]
//        int previous = 0;
//
//        // 用于记录循环前的nums[j],之后会对previous进行赋值
//        int temp = 0;
//
//        // k为多少，就旋转几次
//        for (int i = 0;i < k;i++){
//            // 记录原数组的最后一个元素的值
//            previous = nums[nums.length - 1];
//
//            // 重新对数组进行赋值
//            for (int j = 0;j<nums.length;j++){
//
//                // 先把数组的每一个元素的值记录
//                temp = nums[j];
//
//                // 这里要注意，此时previous记录的是原数组最后一个元素的值
//                // 在j = 0时，新nums[0] = 原nums[nums.length - 1]
//                nums[j] = previous;
//
//                // 然后把previous设置成此次循环的nums[j]
//                // example: j = 0时，这里previous = 原num[0]
//                // 下次循环开始时，新nums[1] = 原nums[0],完成元素往下的操作
//                previous = temp;
//            }
//        }
//  ----------------------------------------------------------------------------------------------------------
//    }
}
