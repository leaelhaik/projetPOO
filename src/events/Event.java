package events;

public abstract class Event
{
  public int date;


  public Event(int date)
  {
    this.date = date;
  }

  public abstract int getDate();

  public abstract void execute();




}
