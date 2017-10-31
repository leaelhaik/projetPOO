package events;
public class MessageEvent extends Event {
  private String message ;

  public MessageEvent ( int date , String message )
  {
    super(date) ;
    this.message = message ;
  }

  
  @Override
  public void execute ()
  {
    System.out.println(this.getDate() + this.message);
  }


@Override
public int getDate() {
	// TODO Auto-generated method stub
	return 0;
}

}
