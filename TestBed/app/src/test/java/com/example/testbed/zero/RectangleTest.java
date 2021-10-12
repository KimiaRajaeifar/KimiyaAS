package com.example.testbed.zero;

import org.junit.Test;

import ca.roumani.i2c.Utility;

public class RectangleTest {
    @Test
    public void getAreaTest()
    {
        int w, h;
        System.out.println("Testing getArea:");
        //=====================================
        w = 4; h = 3;
        System.out.println(w + "," + h);
        System.out.println(Rectangle.getArea(w, h));
        System.out.println("---------------------");
        System.out.println(Utility.repeat(21, '-'));
        w = 2; h = 7;
        System.out.println(w + "," + h);
        System.out.println(Rectangle.getArea(w, h));
    }
}
