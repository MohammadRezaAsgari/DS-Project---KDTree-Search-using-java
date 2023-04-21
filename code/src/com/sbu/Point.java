package com.sbu;

public class Point {
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int get(int k){
        if (k%2==0)
            return x;
        else
            return y;
    }

    @Override
    public String toString() {
        return "(x=" + x +
                " y=" + y +
                ')';
    }
}
