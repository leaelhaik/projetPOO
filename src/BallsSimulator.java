import gui.Simulable;


public class BallsSimulator extends Balls implements Simulable
{

  public Balls pointsSimulables;

  public BallsSimulator(int nb)
  {
    super(nb);
  }


@Override
public void next ()
{
  this.translate(10,10);
  System.out.println(this.toString());
}

@Override
public void restart ()
{
  this.reInit();
  System.out.println(this.toString());
}




}
