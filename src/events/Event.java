package events;

public abstract class Event {

	private long date; 
	
	public long getDate() {
		return this.date;
	}
	
	public abstract void execute();
		
	public Event(long date) {
		this.date=date;
	}
}
