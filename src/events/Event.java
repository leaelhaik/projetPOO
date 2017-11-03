package events;

public abstract class Event
{
  private int date;


  public Event(int date)
  {
    this.date = date;
  }

  public int getDate()
  {
    return this.date;
  }

  public abstract void execute();//a ecrire dans les differents types d'events




}
