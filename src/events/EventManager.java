package events;
import java.util.Comparator;
import java.util.ArrayList;
import boids.*;


public class EventManager extends Event
{
  public int date;
  public ArrayList<Event> list;
  private MovePreys mvPreys;
  private MovePredators mvPredators;
  private MoveMiddle mvMiddle;
  public Boids boids;

  public EventManager(int date)
  {
	  super(date);
  }

  public EventManager(int date, Boids boids)
  {
    super(date);
    this.date = 0;
    this.list = new ArrayList<Event>(); // l'event manager possede une liste d'evenements
    this.boids = boids;
    this.mvPreys = new MovePreys(0,boids);
    this.mvPredators = new MovePredators(0,boids);
    this.mvMiddle = new MoveMiddle(0,boids);
    this.addEvent(mvPreys);
    this.addEvent(mvPredators);
    this.addEvent(mvMiddle);
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
      if ( (this.list.get(i)).getDate() == this.date)
      {
                if(this.list.get(i) instanceof MovePreys) // si l'evenement est de type MovePreys
                {
                  this.list.get(i).execute();
                  System.out.println("BoidsPrey  s'est execute");
                  this.addEvent(new MovePreys(this.date+1,this.boids));
                }
                if(this.list.get(i) instanceof MovePredators) // si l'evenement est de type MovePredators
                {
                  this.list.get(i).execute();
                  System.out.println("BoidsPredator s'est execute");
                  this.addEvent(new MovePredators(this.date+5,this.boids));
                }
                if(this.list.get(i) instanceof MoveMiddle) // si l'evenement est de type MovePredators
                {
                  this.list.get(i).execute();
                  System.out.println("BoidsPredator s'est execute");
                  this.addEvent(new MoveMiddle(this.date+2,this.boids));
                }
      }
    }
  }

  public void removeObsoleteEvents() // enleve les evenements antérieurs a this.date de la liste
  {
    for(int i  = this.list.size()-1; i>= 0; i--)
    {
      if((this.list.get(i)).getDate()< this.date)
      {
        this.list.remove(i);
      }
    }
  }



  public int getCurrenDate()//Renvoie la date courante
  {
    return this.date;
  }

  public void restart()//Vide la liste
  {
    this.date = 0;
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


  public void addEvent(Event e)//ajoute un evenement à la liste
  {
    list.add(e);
  }



  public void next()
  {
    System.out.println("Next... this.date:" + this.date + ",\n");
    this.execute();
    this.removeObsoleteEvents();
    this.date++;

  }




}
