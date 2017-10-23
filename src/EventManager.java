import java.util.*;
import java.lang.Boolean;



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
  public void execute()
  {
    System.out.println("lol");
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
