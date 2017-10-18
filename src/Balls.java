import java.awt.Point;


public class Balls extends Point
{
  public Point[] tab;

  public Balls(int nb)
  {
    this.tab = new Point[nb];
    for(int i = 0;i<nb;i++)
    {
      this.tab[i] = new Point(i,i);
    }
  }


  @Override
  public String toString() {
		String s = new String();
		for (int i = 0; i < this.tab.length; i++)
			s += "(" + this.tab[i].x + ", " + this.tab[i].y + ")"  ;
		return s;
	}
  @Override
  public void translate(int dx, int dy)
  {
    for(int i = 0;i<tab.length;i++)
    {
      this.tab[i].translate(dx,dy);
    }
  }


  void reInit()
  {
    for(int i =0; i< tab.length;i++)
    {
      this.tab[i].setLocation(i,i);
    }
  }
}
