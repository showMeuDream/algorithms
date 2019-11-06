

public class LeetcodeSolution665 {

    public boolean checkPossibility(int[] nums) {

        // 存在不单调递增的目标索引数
        int targetIndex = 0;
        // 用于记录目标数字左边一个数
        int left = 0;
        //用于记录目标数字右边一个数
        int right = 0;
        for (int i = 0;i<=nums.length-2;i++){
            if (nums.length<=2){
                return true;
            }else {
                if (nums[i] > nums[i+1]){

                    // 如果从第一个数字就满足nums[i]>nums[i+1]
                    if (i == 0){
                        right = nums[i+2];
                        // 此时判断，我们的nums[i+1]已经大于nums[i]，如果此时nums[i+2]比num[i+1]小，那就永远不成立
                        if (right < nums[i+1]){
                            return false;
                        }else {
                            // 如果nums[i+2]比nums[i+1]大的话，只需要改变nums[i]即可
                            nums[i] = nums[i+1];
                        }
                    } else {

                        // 如果不是从第一个数字开始的情况
                        left = nums[i-1];
                        right = nums[i+1];
                        // 如果nums[i-1]小于nums[i+1]，那就让nums[i]等于nums[i-1]，就可以保证nums[i+1]最大了
                        if (left <= right){
                            nums[i] = left;
                        } else {

                            // 如果恰好nums[i-1]和nums[i]相等或小于nums[i]，那就让nums[i+1]和nums[i]相等以增大nums[i+1]
                            if (left <= nums[i]){
                                nums[i+1] = nums[i];
                            }else {
                                // 否则直接false
                                return false;
                            }
                        }

                    }

                    // targetIndex继续递增
                    targetIndex+=1;
                }

                if (targetIndex>1){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3};
        boolean b = new LeetcodeSolution665().checkPossibility(arr);
        System.out.println(b);
    }
}
