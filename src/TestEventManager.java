import java.util.*;

public class TestEventManager
{
  public static void main ( String [] args ) throws InterruptedException
  {

    EventManager e = new EventManager(0);

    for (int i=2;i <= 10;i+=2) {
      e.addEvent(new MessageEvent(i,"[PING]"));
    }

      for(int i=3;i<= 9 ;i+=3){
      e.addEvent(new MessageEvent(i,"[PONG]"));
    }
    for(Event l: e.list)
    {
      System.out.println(l.getDate() + ", ");
    }
/*
    Collections.sort(e.list, new EventManager(0));

    for(Event l: e.list)
    {
      System.out.println(l.getDate() + ", ");
    }
*/

    while(!e.isFinished())
    {
      e.next();
    }
    e.restart();

    while(!e.isFinished())
    {
      e.next();
    }







/*
    for(Event l: e.list)
    {
      System.out.println(l.getDate() + ", ");
    }
*/
  }
}
