package com.sami.codingproblems.zigzag_array;

/**
 * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
 * <p>
 * An array A is a zigzag array if either:
 * - Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * - OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * <p>
 * Return the minimum number of moves to transform the given array nums into a zigzag array.
 */
public class ZigzagArray
{
    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3}; // expected output = 2
        int[] nums2 = {9, 6, 1, 6, 2}; // expected output = 4
        int[] nums3 = {2, 7, 10, 9, 8, 9}; // expected output = 4

        ZigzagArray zigzagArray = new ZigzagArray();

        System.out.println(zigzagArray.movesToMakeZigzag(nums1));
        System.out.println(zigzagArray.movesToMakeZigzag(nums2));
        System.out.println(zigzagArray.movesToMakeZigzag(nums3));
    }

    public int movesToMakeZigzag(int[] input)
    {
        int n = input.length;

        if (n < 2)
        {
            return 0;
        }

        int evenMoves = 0;
        int oddMoves = 0;

        // elements on Even indexes are greater
        for (int i = 1; i < n; i += 2)
        {
            int minVal;

            if (i == n - 1)
            {
                minVal = input[i - 1];
            }
            else
            {
                minVal = Math.min(input[i - 1], input[i + 1]);
            }

            if (input[i] >= minVal)
            {
                evenMoves += input[i] - minVal + 1;
            }

        }

        // elements on Odd indexes are greater
        for (int i = 0; i < n; i += 2)
        {
            int minVal;

            if (i == n - 1)
            {
                minVal = input[i - 1];
            }
            else if (i == 0)
            {
                minVal = input[i + 1];
            }
            else
            {
                minVal = Math.min(input[i - 1], input[i + 1]);
            }

            if (input[i] >= minVal)
            {
                oddMoves += input[i] - minVal + 1;
            }
        }

        return Math.min(evenMoves, oddMoves);
    }
}
