package com.sami.codingproblems.count_number_of_concurrences;

/**
 * Given a sorted array arr[] and a number x,
 * write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)
 * <p>
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3},   x = 2
 * Output: 4 // x (or 2) occurs 4 times in arr[]
 * <p>
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3},   x = 3
 * Output: 1
 * <p>
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3},   x = 4
 * Output: -1 // 4 doesn't occur in arr[]
 */
public class NumberOfConcurrences
{

    public static void main(String[] args)
    {
        int[] nums1 = {1, 1, 2, 2, 2, 2, 3};

        NumberOfConcurrences numberOfConcurrences = new NumberOfConcurrences();

        System.out.println(numberOfConcurrences.getNoOfConc(nums1, 1));
        System.out.println(numberOfConcurrences.getNoOfConc(nums1, 2));
        System.out.println(numberOfConcurrences.getNoOfConc(nums1, 4));

    }

    public int getNoOfConc(int[] input, int target)
    {
        int n = input.length;

        // get the index of the target
        int indexOfTarget = binarySearchIterative(input, target);

        if (indexOfTarget > -1)
        {
            // get the left count
            int indexOfLeft = indexOfTarget - 1;
            int leftCount = 0;
            while (indexOfLeft > -1 && input[indexOfLeft] == target)
            {
                leftCount++;
                indexOfLeft--;
            }

            // get the right count
            int indexOfRight = indexOfTarget + 1;
            int rightCount = 0;
            while (indexOfRight < n && input[indexOfRight] == target)
            {
                rightCount++;
                indexOfRight++;
            }

            return (rightCount + 1 + leftCount);
        }

        return indexOfTarget;
    }

    private int binarySearchIterative(int[] arr, int target)
    {

        int n = arr.length;

        int low = 0;
        int high = n - 1;
        int mid;

        // We want to run the loop until the lowest index is high than the highest index
        while (low <= high)
        {

            // the middle is the center of array between the lowest index
            // and the half difference between the highest and lowest indeces
            mid = low + (high - low) / 2;

            if (arr[mid] == target) // we found the target
            {
                return mid;
            }
            else if (arr[mid] < target) // we shift the lowest index to after the middle
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1; // we shift the highest index to lower than middle
            }

        }

        return -1;
    }

}
