import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;

public class MeetingImpl implements Meeting {

  private int id;
  private Calendar cal;
  private String notes;
  private static final String USERNAME = "USERNAME";
  private static final int USERID = 100;
  private static final Contact USER = new ContactImpl(USERID, USERNAME);

  //private Set contacts; // DRY: same in ContactManagerImpl.
  protected Set<Contact> contacts; // DRY: same in ContactManagerImpl. SMELL: should stay private but inherited by PastMeetingImpl

  public MeetingImpl(int id, Calendar cal) { 
    this.id = id;
    this.cal = cal;
    contacts = new HashSet<Contact>();
    contacts.add(USER);
  }

  public MeetingImpl(int id, Calendar cal, Set<Contact> contacts) {
    this(id, cal);
    this.contacts.addAll(contacts); 
  }

	public int getId() { 
    return id; 
  }

	public Calendar getDate() { 
    return cal; 
  }

	public Set<Contact> getContacts() { 
    return contacts;
  }
	
}

