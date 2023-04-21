package com.sbu;

public class Circle {
    Point center;
    int radius;

    Circle(Point p,int r){
        center=p;
        radius=r;
    }

    public boolean findPoint(Point point){
        if(dist(point,center)<=radius)
            return true;
        return false;
    }

    public static long dist(Point p0, Point p1) {
        return (long) Math.sqrt(distSquared(p0, p1));
    }


    static long distSquared(Point p1, Point p2) {
        long total = 0;

        int dist = Math.abs(p1.x - p2.x);
        total += Math.pow(dist, 2);

        int dist2 = Math.abs(p1.y - p2.y);
        total += Math.pow(dist2, 2);

        return total;
    }
}
