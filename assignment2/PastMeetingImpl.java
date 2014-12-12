import java.util.Calendar;
import java.util.Set;


public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
//public class PastMeetingImpl implements PastMeeting {

  public PastMeetingImpl(int id, Calendar cal) {
    super(id, cal);
  }

  public PastMeetingImpl(int id, Calendar cal, Set<Contact> contacts) {
    super(id, cal, contacts);
    //this(id, cal);
    //this.contacts.addAll(contacts);
  }

  /*
  public PastMeetingImpl(int id, Calendar cal, Set<Contact> contacts, String notes) {
    super(id, cal, contacts);
    //this(id, cal, contacts);
    //this.contacts.addAll(contacts);
    this.notes = notes;
  }
  */


	public String getNotes() {
    return null;
  }

}
