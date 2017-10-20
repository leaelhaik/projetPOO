import java.awt.Point;
import java.util.Random;


public class Balls extends Point
{
  private Point[] tab;
  private int[] direction;//La direction indique le sens suivant le quel la translation doit se faire
  public Balls(int nb)
  {
    this.tab = new Point[nb]; this.direction = new int[nb];
    for(int i = 0;i<nb;i++)
    {
      Random R = new Random();Random R1= new Random();
      this.tab[i] = new Point(R.nextInt(500),R1.nextInt(500));//initialement les balles ont des positions aléatoires

      this.direction[i]= R.nextInt(3); // et des directions aléatoires
    }
  }
  public Point gettabi(int i)
  {
       return this.tab[i];
 }

  public int getlength()
  {
       return this.tab.length;
 }
  @Override
  public String toString() { //renvoit (x,y) (position de tout les points)
		String s = new String();
		for (int i = 0; i < this.tab.length; i++)
			s += "(" + this.tab[i].x + ", " + this.tab[i].y + ")"  ;
		return s;
	}


  public void trans(int dx,int dy)//fonction translater pour qu'il reste dans l'écran
  {
       for(int i=0;i<tab.length;i++)
       {
            switch(this.direction[i])//selon la direction, on fait une certaine action
            {
                 case 0: //direction en bas droite
                 if (this.tab[i].getY()>=490)//condition de dépassement de l'écran
                 {
                      this.tab[i].translate(dx,-dy);//si ça dépasse sur Y on translate en -Y alors
                      this.direction[i]= 1;//on change la direction
                 }
                 if (this.tab[i].getX()>=740)
                 {
                      this.tab[i].translate(-dx,dy);
                      this.direction[i] = 2;
                 }
                 else
                 {
                      this.tab[i].translate(dx,dy);
                 }
                 break;

                 case 1: //en haut droite
                 if (this.tab[i].getY()<=10)
                 {
                      this.tab[i].translate(dx,dy);
                      this.direction[i]=0;
                 }
                 if (this.tab[i].getX()>=740)
                 {
                      this.tab[i].translate(-dx,-dy);
                      this.direction[i]=3;
                 }
                 else
                 {
                      this.tab[i].translate(dx,-dy);
                 }
                 break;
                 case 2: //en bas gauche
                if (this.tab[i].getY()>=490)
                {
                    this.tab[i].translate(-dx,-dy);
                    this.direction[i]=3;
                }
                if (this.tab[i].getX()<=10)
                {
                    this.tab[i].translate(dx,dy);
                    this.direction[i]=0;
                }
                else
                {
                    this.tab[i].translate(-dx,dy);
                }
                break;
                case 3 : //en haut gauche
               if (this.tab[i].getY()<=10)
               {
                   this.tab[i].translate(-dx,dy);
                   this.direction[i]=2;
               }
               if (this.tab[i].getX()<=10)
               {
                   this.tab[i].translate(dx,-dy);
                   this.direction[i]=1;
               }
               else
               {
                   this.tab[i].translate(-dx,-dy);
               }
               break;
            }
       //System.out.println(this.direction[i]);
       }
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
