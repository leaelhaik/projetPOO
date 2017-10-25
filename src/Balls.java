import java.awt.Point;
import java.util.Random;


public class Balls extends Point
{
  private Point[] tab; //tableau de points
  private int[] direction;//La direction indique le sens suivant le quel la translation doit se faire


//-----------------------------------------------------
// Balls : Tableau de Point à nb élements, ces dernièrs ont des positions et des directions aléatoires.
  public Balls(int nb)
  {
    if (nb<0) {throw new IllegalArgumentException("Le nombre de boules ne peut pas être négatif (Balls)");}
    this.tab = new Point[nb]; this.direction = new int[nb];
    for(int i = 0;i<nb;i++)
    {
//-------------------------------------------
// Initialisation aléatoire des coordonées
      Random R = new Random();Random R1= new Random();
      this.tab[i] = new Point(R.nextInt(500),R1.nextInt(500));//initialement les balles ont des positions aléatoires dans l'écran 500*500

      this.direction[i]= R.nextInt(3); // et des directions aléatoires
    }
  }
//-------------------------------------------
// Accès à l'élement i :

  public Point gettabi(int i)
  {
       return this.tab[i];
 }
//-------------------------------------------
// Accès à la longueur :

  public int getlength()
  {
       return this.tab.length;
 }


//---------------------------------------------------
// Renvoit la position de tous les points de Balls sous forme (x,y)
  @Override
  public String toString() {
		String s = new String();
		for (int i = 0; i < this.tab.length; i++)
			s += "(" + this.tab[i].x + ", " + this.tab[i].y + ")"  ;
		return s;
	}

//---------------------------------------------------------------
// Fonction qui fait translater tous les points selon leurs direction :
  public void trans(int dx,int dy)
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
                 if (this.tab[i].getX()>=740) //740 c'est la largeur de l'écran qui est généré
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
       }
 }


 //----------------------------------------------------------
 // Translater tous les points de dx,dy
  @Override
  public void translate(int dx, int dy)
  {
    for(int i = 0;i<tab.length;i++)
    {
      this.tab[i].translate(dx,dy);
    }
  }

//----------------------------------------------------------------
// Réinitialiser le tableau avec des valeurs aléatoires
  void reInit()
  {
       for(int i = 0;i<this.tab.length;i++)
      {
        Random R = new Random();Random R1= new Random();
        this.tab[i] = new Point(R.nextInt(500),R1.nextInt(500));

        this.direction[i]= R.nextInt(3);
  }
}
}
