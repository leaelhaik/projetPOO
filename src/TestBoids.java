
public class TestBoids{
  public static void main ( String[] args )
  {
    Boids n = new Boids(6);
    System.out.println( n.toString());
/*
  n.Rule1();
  System.out.println( n.toString());

  n.Rule2();
  System.out.println( n.toString());

  n.Rule3();
  System.out.println( n.toString());
*/
    for(int i =0;i<5;i++)
    {
      n.moveBoids();
      System.out.println( n.toString());
      n.resetAcceleration();
    }
  }
}
