package events;

public abstract class Event // classe abstraite sur-classe de différents types d'evenements
{
  protected int date;


  public Event(int date)
  {
    this.date = date;
  }

  public int getDate()// renvoie la date de l'evenement
  {
    return this.date;
  }

  public abstract void execute();//a ecrire dans les differents types d'events




}
