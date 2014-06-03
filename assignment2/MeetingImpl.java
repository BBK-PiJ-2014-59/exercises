import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;

public class MeetingImpl implements Meeting {

  private int id;
  private Calendar cal;

  private Set contacts; // DRY: same in ContactManagerImpl.

  public MeetingImpl(int id, Calendar cal) {
    this.id = id;
    this.cal = cal;
    contacts = new HashSet<Contact>();
  }

  public MeetingImpl(int id, Calendar cal, Set<Contact> contacts) {
    this(id, cal);
    this.contacts = contacts; 
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

