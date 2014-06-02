import java.util.Calendar;
import java.util.Set;

public class MeetingImpl implements Meeting {

  int id;
  Calendar cal;

  public MeetingImpl(int id, Calendar cal) {
    this.id = id;
    this.cal = cal;
  }

	public int getId() { 
    return id; 
  }
	public Calendar getDate() { 
    return cal; 
  }

	public Set<Contact> getContacts() { 
    return null;
  }
	
}

