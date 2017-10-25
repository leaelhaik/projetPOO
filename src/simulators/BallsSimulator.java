package simulators;

import gui.*;
import java.awt.Color;
import gui.Oval;
import java.util.Random;

public class BallsSimulator extends Balls implements Simulable
{


  public GUISimulator gui;


  public BallsSimulator(int nb)
  {

    super(nb);
    if (nb<0) {throw new IllegalArgumentException("Le nombre de boules ne peut pas être négatif (BallsSimulator)");}
    this.gui =  new GUISimulator (500 , 500 , Color . BLACK ) ;


  }


//---------------------------------------------------------
// Pour avoir des boules de différentes couleur :
// On génère une chaine de caractère en fonction de la valeur i qui est l'indice de la boule

  private String Couleur(int i)
  {
       String c = "#" + (String.valueOf(i%10)) + (String.valueOf((i+4)%10)) +(String.valueOf((7+i)%10)) + "D" +(String.valueOf((5+i)%10)) + "A";
       return c;
  }

@Override
public void next ()
{
  this.gui.reset(); // On enlève tous les points sur l'écran
  for(int i=0;i<this.getlength();i++)
  {
    this.trans(1,1); // On modifie les coordonées des points de Balls
    this.gui.addGraphicalElement( new Oval(this.gettabi(i).x, this.gettabi(i).y,Color.decode(Couleur(i)),Color.decode(Couleur(i)),50) );//On affiche les nouveaux points
  }

}

@Override
public void restart ()
{
  this.reInit(); // On réinitialise les points
  this.gui.reset(); // On réinitialise l'écran
}
}
