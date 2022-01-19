package com.sami.codingproblems.maxinmum_subarray;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */
public class MaxSubarray
{
    public static void main(String[] args)
    {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // output = 6, [4,-1,2,1] has the largest sum = 6
        int[] nums2 = {1}; // output = 1
        int[] nums3 = {5, 4, -1, 7, 8}; // output = 23
        int[] nums4 = {-2, 1}; // output = 1
        int[] nums5 = {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}; // output = 6

        MaxSubarray maxSubarray = new MaxSubarray();

        System.out.println(maxSubarray.getMaxSum(nums1));
        System.out.println(maxSubarray.getMaxSum(nums2));
        System.out.println(maxSubarray.getMaxSum(nums3));
        System.out.println(maxSubarray.getMaxSum(nums4));
        System.out.println(maxSubarray.getMaxSum(nums5));
    }

    // using kadane's algorithm
    public int getMaxSum(int[] input)
    {
        int n = input.length;

        int maxSum = input[0];
        int currentSum = input[0];

        for (int i = 1; i < n; i++)
        {
            if (input[i] >= currentSum + input[i])
            {
                currentSum = input[i];
            }
            else if (input[i] < currentSum + input[i])
            {
                currentSum += input[i];
            }

            if (currentSum > maxSum)
            {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
