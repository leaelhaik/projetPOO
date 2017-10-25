package events;
import java.util.*;
import java.lang.Boolean;



public class EventManager extends Event implements Comparator<Event>
{
  public long date;
  public long currentDate;
  public List<Event> list;


  public EventManager(long date)
  {
    super(date);
    this.currentDate = 0;
    this.list = new ArrayList<Event>();
  }
  public void execute()
  {
    System.out.println("lol");
  }
 

  public long getCurrentDate()
  {
    return this.currentDate;
  }

  public void restart()
  {
    this.currentDate = 0;
  }


  public boolean isFinished()
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

  public int compare(Event e,Event e1)
  {
  return (int)(e.getDate() - e1.getDate());
  }

  public void addEvent(Event e)
  {
    list.add(e);
  }

  public void next()
  {

    currentDate++;
    System.out.println("Next... currentDate:" + this.currentDate + ",\n");
    for(Event l: this.list)
    {
      if (l.getDate() == this.currentDate)
      {
        l.execute();
      }
    }
  }




}
