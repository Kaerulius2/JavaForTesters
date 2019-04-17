package ru.stqa.pft.sandbox;

public class MyFirstProgram
{

public static void main(String[] args){
	System.out.println("Func vs Met - distance between points");

	Point first = new Point(2,3);
	Point second = new Point(5,6);

	System.out.println("Function: " + distance(first,second));
	System.out.println("Metod: " + first.distance(second));

	}

	public static double distance(Point p1, Point p2){
	return Math.sqrt(((p2.x-p1.x)*(p2.x-p1.x))+((p2.y-p1.y)*(p2.y-p1.y)));

	}
}