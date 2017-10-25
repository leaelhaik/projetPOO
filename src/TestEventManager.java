import java.util.*;

public class TestEventManager
{
  public static void main ( String [] args ) throws InterruptedException
  {

    EventManager e = new EventManager(0);

    e.addEvent(new MessageEvent(1,"[PONG]"));

    System.out.println(e.toString());
/*
    Collections.sort(e.list, new EventManager(0));

    for(Event l: e.list)
    {
      System.out.println(l.getDate() + ", ");
    }
*/

    while(e.currentDate < 21)
    {
      e.next();
    }
    e.restart();
/*
    while(!e.isFinished())
    {
      e.next();
    }
    System.out.println(e.toString());
*/





/*
    for(Event l: e.list)
    {
      System.out.println(l.getDate() + ", ");
    }
*/
  }
}
