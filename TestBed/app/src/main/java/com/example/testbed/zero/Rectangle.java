package com.example.testbed.zero;

public class Rectangle {
    public static int getArea(int width, int height)
    {
        int result = width * height;
        return result;
    }

    public static int getPerimeter(int width, int height)
    {
        int result = 2 * (width + height);
        return result;
    }
}
