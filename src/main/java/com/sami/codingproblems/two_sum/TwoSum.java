package com.sami.codingproblems.two_sum;

import java.util.HashMap;


/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum
{
    public static void main(String[] args)
    {
        int[] nums1 = {2, 7, 11, 15}; // target = 9, output: [0, 1], explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        int[] nums2 = {3, 2, 4}; // target = 6, output: [1, 2]
        int[] nums3 = {3, 3}; // target = 6, output: [0, 1]

        TwoSum twoSum = new TwoSum();

        System.out.println(twoSum.getTwoSum(nums1, 9));
        System.out.println(twoSum.getTwoSum(nums2, 6));
        System.out.println(twoSum.getTwoSum(nums3, 6));
    }

    public int[] getTwoSum(int[] input, int target)
    {
        int length = input.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++)
        {
            int required = target - input[i];

            if (map.containsKey(required))
            {
                int[] result = {map.get(required), i};

                return result;
            }

            map.put(input[i], i);
        }

        return new int[0];
    }
}
