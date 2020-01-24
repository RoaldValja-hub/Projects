package TimetablePlanning.Domain;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Room {

	private static final AtomicLong count = new AtomicLong(0); 
	private long id;
	private int capacity;
	
	public Room() {
		id = count.incrementAndGet();
    }

    public Room(long id) {
        this.id = id;
    }
	
	public int getCapacity(){
		return capacity;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
}
