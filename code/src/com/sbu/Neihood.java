package com.sbu;

public class Neihood{
    Point xy1;
    Point xy2;
    Point xy3;
    Point xy4;
    String Name;
    Neihood(){
        xy1=new Point();
        xy2=new Point();
        xy3=new Point();
        xy4=new Point();
    }

    private Point findmin(){
        int minx=xy1.x;
        int miny=xy1.y;
        if(xy2.x<minx)
            minx=xy2.x;
        if(xy3.x<minx)
            minx=xy3.x;
        if(xy4.x<minx)
            minx=xy4.x;
        if(xy2.y<miny)
            miny=xy2.y;
        if(xy3.y<miny)
            miny=xy3.y;
        if(xy4.y<miny)
            miny=xy4.y;
        return new Point(minx,miny);
    }
    private Point findmax(){
        int maxx=xy1.x;
        int maxy=xy1.y;
        if(xy2.x>maxx)
            maxx=xy2.x;
        if(xy3.x>maxx)
            maxx=xy3.x;
        if(xy4.x>maxx)
            maxx=xy4.x;
        if(xy2.y>maxy)
            maxy=xy2.y;
        if(xy3.y>maxy)
            maxy=xy3.y;
        if(xy4.y>maxy)
            maxy=xy4.y;
        return new Point(maxx,maxy);
    }


    public boolean findPoint(Point point){
        Point p1=this.findmin();
        Point p2=this.findmax();
        if(point.x >= p1.x && point.x <= p2.x && point.y >= p1.y && point.y <= p2.y)
            return true;
        return false;
    }
}
