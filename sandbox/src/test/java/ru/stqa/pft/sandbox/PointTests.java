package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testPointZero(){
        Point p1=new Point(0,0);
        Point p2=new Point(0,0);

        Assert.assertEquals(p1.distance(p2),0.0);

    }

    @Test
    public void testPointInt(){
        Point p1=new Point(0,0);
        Point p2=new Point(0,3);

        Assert.assertEquals(p1.distance(p2),3.0);

        p1=new Point(0,3);
        p2=new Point(0,0);

        Assert.assertEquals(p1.distance(p2),3.0);

        p1=new Point(5,0);
        p2=new Point(0,0);

        Assert.assertEquals(p1.distance(p2),5.0);

        p1=new Point(0,0);
        p2=new Point(5,0);

        Assert.assertEquals(p1.distance(p2),5.0);

    }


    @Test
    public void testPointDoub(){
        Point p1=new Point(0,0);
        Point p2=new Point(3,3);

        Assert.assertEquals(p1.distance(p2),4.242640687119285);
    }

    //этот тест для примера сломал
    @Test
    public void testPointNegNum(){
        Point p1=new Point(-1,-1);
        Point p2=new Point(-3,-3);

        Assert.assertEquals(p1.distance(p2),5.656854249492381);
    }

}
