package events;
import java.util.*;
import boids.*;


public class EventManager extends Event implements Comparator<Event>
{
  public int date;
  public int currentDate;
  public List<Event> list;
  private MovePreys mvPreys;
  private MovePredators mvPredators;
  public BoidsNew boids;

  public EventManager(int date, BoidsNew boids)
  {
    super(date);
    this.currentDate = 0;
    this.list = new ArrayList<Event>(); // l'event manager possede une liste d'evenements
    this.boids = boids;
    this.mvPreys = new MovePreys(0,boids);
    this.mvPredators = new MovePredators(0,boids);
    this.addEvent(mvPreys);
    this.addEvent(mvPredators);
  }

  @Override
  public String toString() // Reecriture de la methode toString, affiche la liste ainsi que la date courante
   {
     String s = new String();
     s +=  "  taille: " +this.list.size()+" \n";
     s += "Date courante" + this.getCurrenDate() + "\n";
     for(int i=0;i<this.list.size();i++)
     {
      s += "date:" + this.list.get(i).getDate() + "\n";
     }
     return s;
   }

  public void execute()
  {
    for(int i  = this.list.size()-1; i>= 0; i--)
    {
      if ( (this.list.get(i)).getDate() == currentDate)
      {
                if(this.list.get(i) instanceof MovePreys) // si l'evenement est de type MovePreys
                {
                  this.list.get(i).execute();
                  System.out.println("BoidsPrey  s'est execute");
                  this.addEvent(new MovePreys(currentDate+1,this.boids));
                }
                if(this.list.get(i) instanceof MovePredators) // si l'evenement est de type MovePredators
                {
                  this.list.get(i).execute();
                  System.out.println("BoidsPredator s'est execute");
                  this.addEvent(new MovePredators(currentDate+2,this.boids));
                }
      }
    }
  }

  public void removeObsoleteEvents() // enleve les evenements antérieurs a currentDate de la liste
  {
    for(int i  = this.list.size()-1; i>= 0; i--)
    {
      if((this.list.get(i)).getDate()< this.currentDate)
      {
        this.list.remove(i);
      }
    }
  }



  public int getCurrenDate()//Renvoie la date courante
  {
    return this.currentDate;
  }

  public void restart()//Vide la liste
  {
    this.currentDate = 0;
    for(int i  = this.list.size()-1; i>= 0; i--)
    {
      this.list.remove(i);
    }

  }
/*
  public void sort()
  {
    Collections.sort(this.list, new EventManager(0));
  }*/




  public boolean isFinished()//methode qui verifie si il reste des evenements à executer
  {
    for(Event l: this.list)
    {
      if (l.getDate() >this.currentDate)
      {
        return false;
      }
    }
    return true;
  }

  public int compare(Event e,Event e1)//permet de comprer deux event par leur date
  {
  return (int)(e.getDate() - e1.getDate());
  }

  public void addEvent(Event e)//ajoute un evenement à la liste
  {
    list.add(e);
  }



  public void next()
  {
    System.out.println("Next... currentDate:" + this.currentDate + ",\n");
    this.execute();
    this.removeObsoleteEvents();
    currentDate++;

  }




}
