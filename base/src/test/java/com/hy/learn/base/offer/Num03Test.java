package com.hy.learn.base.offer;

import org.junit.Test;

import static org.junit.Assert.*;

public class Num03Test {

    @Test
    public void main() {
        int[] nums = {1, 2, 3, 4 , 5, 3};
        System.out.println("findRepeatNumber(nums) = " + findRepeatNumber1(nums));
    }

    public int findRepeatNumber1(int[] nums) {
        int targetNum = -1;
        boolean hadFound = false;
        int size = nums.length;
        for (int m = 0; m < size; m++) {
            targetNum = nums[m];
            nums[m] = -1;
            for (int n = 0; n < size; n++) {
                if (targetNum == nums[n]) {
                    hadFound = true;
                    break;
                }
            }
            if (hadFound) {
                break;
            }
        }
        if (hadFound) {
            return targetNum;
        } else {
            return 0;
        }
    }

    public int findRepeatNumber2(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0;i<nums.length;i++) {
            arr[nums[i]] ++;
            if (arr[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }
}