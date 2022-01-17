package com.sami.codingproblems.sub_array_sum_equals;

import java.util.HashMap;


/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */

public class SubarraySum
{
    public static void main(String[] args)
    {
        int[] nums1 = new int[] {1, 1, 1};
        int[] nums2 = new int[] {1, 2, 3};

        SubarraySum subarraySum = new SubarraySum();

        System.out.println(subarraySum.subarraySum(nums1, 2));
        System.out.println(subarraySum.subarraySum(nums2, 2));
    }

    public int subarraySum(int[] nums, int k)
    {
        int n = nums.length;

        int numOfSubarrays = 0;

        int sum = 0;

        HashMap<Integer, Integer> sumMap = new HashMap<>();

        sumMap.put(0, 1);

        for (int i = 0; i < n; i++)
        {
            sum += nums[i];

            if (sumMap.containsKey(sum - k))
            {
                numOfSubarrays++;
            }

            sumMap.put(sum, sumMap.getOrDefault(sum, 1) + 1);
        }

        return numOfSubarrays;
    }
}
