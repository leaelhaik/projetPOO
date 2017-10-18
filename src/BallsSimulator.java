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
  this.pointsSimulables.translate(10,10);
}

@Override
public void restart ()
{
  this.pointsSimulables.reInit();
}




}
