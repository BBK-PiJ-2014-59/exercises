import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ContactManagerImpl implements ContactManager {

  private Set<Contact> contacts;
  private int nextId; 
  static final private int FIRSTCONTACTID = 100; 

  public ContactManagerImpl() {
    contacts = new HashSet<Contact>();
    nextId = FIRSTCONTACTID;
  }

	public Set<Contact> getContacts(int... ids) {
    System.out.println("Starting getContacts()");
    Set<Contact> result = new HashSet<Contact>();
    for (int argId : ids) {
      for (Contact c : contacts) {
        if (c.getId() == argId) {
          result.add(c);
        }
      }
    }
    //for (Contact c : result) {
    //  System.out.println("c.getName(): " + c.getName());
    //} 
    return result;
  }

	public void addNewContact(String name, String notes) throws NullPointerException {
    System.out.println("Starting addNewContact()");
    Contact newc = new ContactImpl(getAndIncrementNextId(), name);
    contacts.add(newc);
    for (Contact c : contacts) {
      System.out.println("c.getName(): " + c.getName());
      System.out.println("c.getId(): " + c.getId());
    } 
  }

  private int getAndIncrementNextId() {
    return nextId++;
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
	public Meeting getMeeting(int id) {
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
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
  }
	public void addMeetingNotes(int id, String text) {
  }


	public Set<Contact> getContacts(String name) {
    return null;
  }
	public void flush() {
  }

}
