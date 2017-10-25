package events;

public abstract class Event {

	protected long date; 
	
	public long getDate() {
		return this.date;
	}
	
	public abstract void execute();
		
	public Event() {
		this.date=0;
	}
	
	public Event(long date) {
		this.date=date;
	}
}
