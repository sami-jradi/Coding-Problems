package com.sami.codingproblems.subarray_with_zero_sum;

import java.util.HashSet;
import java.util.Set;


/**
 * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
 * Input: {4, 2, -3, 1, 6}
 * Output: true
 * <p>
 * Input: {4, 2, 0, 1, 6}
 * Output: true
 * <p>
 * Input: {-3, 2, 3, 1, 6}
 * Output: false
 */
public class ZeroSum
{
    public static void main(String[] args)
    {
        int[] nums1 = {4, 2, -3, 1, 6}; // output = true
        int[] nums2 = {4, 2, 0, 1, 6}; // output = true
        int[] nums3 = {-3, 2, 3, 1, 6}; // output = false

        ZeroSum zeroSum = new ZeroSum();

        System.out.println(zeroSum.zeroSum(nums1));
        System.out.println(zeroSum.zeroSum(nums2));
        System.out.println(zeroSum.zeroSum(nums3));
    }

    public boolean zeroSum(int[] input)
    {
        int n = input.length;

        Set<Integer> sumSet = new HashSet<>();

        int sum = 0;

        for (int i = 0; i < n; i++)
        {

            // Add current element to sum
            sum += input[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (sum == 0 || input[i] == 0 || sumSet.contains(sum))
            {
                return true;
            }

            // Add sum to hash set
            sumSet.add(sum);
        }

        return false;
    }
}
