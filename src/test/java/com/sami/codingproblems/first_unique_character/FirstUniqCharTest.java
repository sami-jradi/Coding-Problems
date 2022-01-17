package com.sami.codingproblems.first_unique_character;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FirstUniqCharTest
{

    static FirstUniqChar firstUniqChar;

    @BeforeAll
    static void setUp(){
        firstUniqChar = new FirstUniqChar();
    }

    @Test
    void noRepeatingCharTest()
    {
        String string = "aabb";

        int index = firstUniqChar.firstUniqChar(string);

        assertEquals(-1, index);
    }

    @Test
    void repeatedChartest()
    {
        String string = "leetcode";

        int index = firstUniqChar.firstUniqChar(string);

        assertEquals(0, index);
    }
}