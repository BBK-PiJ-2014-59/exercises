import java.util.Calendar;
import java.util.Set;


public class PastMeetingImpl extends MeetingImpl implements PastMeeting {

  public PastMeetingImpl(int id, Calendar cal) {
    super(id, cal);
  }

  public PastMeetingImpl(int id, Calendar cal, Set<Contact> contacts) {
    this(id, cal);
    this.contacts.addAll(contacts);
  }

	public String getNotes() {
    return null;
  }
	
}
