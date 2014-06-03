import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class ContactManagerImpl implements ContactManager {

  private Set<Contact> contacts;
  private int nextContactId; 

  private List<Meeting> mtgs;
  private int nextMtgId; 

  static final private int FIRSTCONTACTID = 100; 
  static final private int FIRSTMTGID = 1000; 

  public ContactManagerImpl() {
    contacts = new HashSet<Contact>();
    nextContactId = FIRSTCONTACTID;
    mtgs = new ArrayList<Meeting>();
    nextMtgId = FIRSTMTGID;
  }

	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
    int newMtgId = getNextMtgId();
    Meeting mtg = new MeetingImpl(newMtgId, date, contacts);
    mtgs.add(mtg);
  }

  private int getNextMtgId() {
    return nextMtgId++;
  }

	public Meeting getMeeting(int id) {
    Meeting result;
    if (mtgs.isEmpty()) {
      result = null;
    } else {
      try {
        result = mtgs.get(id-FIRSTMTGID); // TODO: Add check: only return if Meeting.getId() == id-FIRSTMTGID else throw some exception.  
      } catch (IndexOutOfBoundsException ex) {
        result = null;
      } 
    }
    return result;
  }

	public Set<Contact> getContacts(int... ids) {
    //System.out.println("Starting getContacts()");
    Set<Contact> result = new HashSet<Contact>();
    for (int argId : ids) {
      boolean foundId = false;
      for (Contact c : contacts) {
        if (c.getId() == argId) {
          result.add(c);
          foundId = true;
        }
      }
      if (foundId == false) {
        throw new IllegalArgumentException("Could not find requested ID " + argId);
      }
    }
    return result;
  }

	public void addNewContact(String name, String notes) throws NullPointerException {
    //System.out.println("Starting addNewContact()");
    if (name == null) {
      throw new NullPointerException("name cannot be null.");
    }
    if (notes == null) {
      throw new NullPointerException("notes cannot be null.");
    }
    Contact newc = new ContactImpl(getAndIncrementNextId(), name);
    contacts.add(newc);
    //for (Contact c : contacts) {
      //System.out.println("c.getName(): " + c.getName());
      //System.out.println("c.getId(): " + c.getId());
    //} 
  }

  private int getAndIncrementNextId() {
    return nextContactId++;
  }

	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
    return 0;
  }
	public PastMeeting getPastMeeting(int id) {
    return null;
  }
	public FutureMeeting getFutureMeeting(int id) {
    return null;
  }
	public List<Meeting> getFutureMeetingList(Contact contact) {
    return null;
  }
	public List<Meeting> getFutureMeetingList(Calendar date) {
    return null;
  }
	public List<PastMeeting> getPastMeetingList(Contact contact) {
    return null;
  }
	public void addMeetingNotes(int id, String text) {
  }


	public Set<Contact> getContacts(String name) {
    return null;
  }
	public void flush() {
  }

}
