package events;
import java.util.*;



public class EventManager extends Event implements Comparator<Event>
{
  public int date;
  public int currentDate;
  public List<Event> list;


  public EventManager(int date)
  {
    super(date);
    this.currentDate = 0;
    this.list = new ArrayList<Event>();
  }

  @Override
  public String toString()
   {
     String s = new String();

     for(int i=0;i<this.list.size();i++)
     {
       s +=  "  taille: "
       +this.list.size()+" \n";
     }
     return s;
   }

  public void execute()
  {
    for(int i  = this.list.size()-1; i>= 0; i--)
    {
      if ( (this.list.get(i)).date == currentDate)
      {
        this.list.get(i).execute();
        (this.list.get(i)).date ++;
        this.addEvent(this.list.get(i));
      }
    }
  }
  public int getDate()
  {
    return this.date;
  }


  public int getCurrenDate()
  {
    return this.currentDate;
  }

  public void restart()
  {
    this.currentDate = 0;
  }


  public void sort()
  {
    Collections.sort(this.list, new EventManager(0));
  }



  public boolean isFinished()
  {
    for(Event l: this.list)
    {
      if (l.date >this.currentDate)
      {
        return false;
      }
    }
    return true;
  }

  public int compare(Event e,Event e1)
  {
  return (int)(e.date - e1.date);
  }

  public void addEvent(Event e)
  {
    e.date ++;
    list.add(e);
  }



  public void next()
  {

    System.out.println("Next... currentDate:" + this.currentDate + ",\n");
    this.execute();
    currentDate++;
  }





}
