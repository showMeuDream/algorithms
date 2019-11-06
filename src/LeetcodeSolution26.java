//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
// 示例 1:
//
// 给定数组 nums = [1,1,2],
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//你不需要考虑数组中超出新长度后面的元素。
//
// 示例 2:
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
// Related Topics 数组 双指针

public class LeetcodeSolution26 {

    public int removeDuplicates(int[] nums) {
        // 优先判断数组是否合法
        if (nums == null || nums.length == 0){
            return 0;
        }

        // 定义一个慢指针和一个快指针

        // 因为此为一个有序数组，所以与nums[slowPointer]相等的元素必定会出现于左右相邻的位置
        int slowPointer = 0;
        int fastPointer = 1;

        // 当nums[slowPointer]和nums[fastPointer]相等时，此时没有我们想要的新元素，fastPointer继续往下
        for (;fastPointer<=nums.length-1;fastPointer++){

            // 判断nums[slowPointer]和nums[fastPointer]不相等时，也就是nums[0]，数组的第一个元素和nums[1]不相等时
            if (nums[slowPointer] != nums[fastPointer]){

                // 此时把nums[fastPointer]作为数组的第二个元素
                nums[slowPointer + 1] = nums[fastPointer];

                // 这时候让慢指针slowPointer走到元素第二位置，之后开始仅判断和第二个元素相等的元素
                slowPointer++;
            }
        }

        return slowPointer + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,1,2,3,4,4,5};

        int result = new LeetcodeSolution26().removeDuplicates(arr);
        System.out.println(result);
    }
}
