package com.sami.codingproblems.first_unique_character;

import java.util.HashMap;


/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 */

public class FirstUniqChar
{
    public static void main(String[] args)
    {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        FirstUniqChar firstUniqChar = new FirstUniqChar();

        System.out.println(firstUniqChar.firstUniqChar(s1));
        System.out.println(firstUniqChar.firstUniqChar(s2));
        System.out.println(firstUniqChar.firstUniqChar(s3));
    }

    public int firstUniqChar(String input)
    {

        HashMap<Character, Integer> charMap = new HashMap<>();

        int length = input.length();

        // build hash map : character and how often it appears
        for (int index = 0; index < length; index++)
        {
            char letter = input.charAt(index);

            charMap.put(letter, charMap.getOrDefault(letter, 0) + 1);

        }

        // find the index
        for (int index = 0; index < length; index++)
        {
            if (charMap.get(input.charAt(index)) == 1)
            {
                return index;
            }
        }

        return -1;
    }
}
