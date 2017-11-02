//import gui.*;
import balls.Balls;

import java.awt.Point;

public class TestBalls
{
  public static void main(String[] args) 
  {
    Balls B = new Balls(3);
    B.getTab()[0] = new Point(0,2);
    B.getTab()[1] = new Point(1,2);
    B.getTab()[2] = new Point(2,2);
    System.out.println("B = " + B.toString());

    B.translate(2,2);
    System.out.println("B = " + B.toString());
    B.reInit();
    System.out.println("B = " + B.toString());

  }
}
