package ru.stqa.pft.sandbox;

public class MyFirstProgram
{

public static void main(String[] args){
	System.out.println("Func vs Met - расстояние между точками");

	Point first = new Point(2,3);
	Point second = new Point(5,6);

	System.out.println("Функция: " + distance(first,second));
	System.out.println("Метод: " + first.distance(second));

	}

	public static double distance(Point p1, Point p2){
	return Math.sqrt(((p2.x-p1.x)*(p2.x-p1.x))+((p2.y-p1.y)*(p2.y-p1.y)));

	}
}