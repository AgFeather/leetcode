

//不能使用动态规划，因为当前num值是否加入会改变之前的状态
public int rob(int[] nums){
    if (nums.length == 2)
        return Math.max(nums[0], nums[1]);
    else if (nums.length == 1) {
        return nums[0];
    }
    int[] temp = new int[nums.length];
    temp[0] = nums[0];
    temp[1] = nums[1];
    for (int i = 2; i<nums.length; i++) {
        if (nums[i]+temp[i-2] > temp[i-1]) {
            temp[i] = nums[i] + temp[i-2];
        }else
            temp[i] = temp[i-1];
    }
    return temp[temp.length-1];
}
