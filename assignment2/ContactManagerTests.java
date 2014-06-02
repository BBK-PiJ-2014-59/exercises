import org.junit.*;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Calendar;

public class ContactManagerTests {

  private int myId;
  private String myName;
  private Contact c;
  private Meeting m;
  private ContactManager cm;
  private Calendar cal = Calendar.getInstance();
  private String myMtgNote; 

  static private final int CONTACTIDMIN = 100;

  static private final String CONTACTNAME1 = "Bill";
  static private final String CONTACTNOTES1 = "such generous";
  static private final int CONTACTID1 = 100;

  static private final String CONTACTNAME2 = "Jane";
  static private final String CONTACTNOTES2 = "Wow";
  static private final int CONTACTID2 = 101;

  static private final String CONTACTNAME3 = "Fred";
  static private final String CONTACTNOTES3 = "amazing";
  static private final int CONTACTID3 = 102;

  static private final int MTGIDMIN = 1000;
  static private final int MTGID1 = 1001;

  @Before
  public void buildUp() {
    myId = 101; 
    myName = "Jane"; 
    myMtgNote = "Wow. So meeting."; 
    c = new ContactImpl(myId, myName); // TODO: what if you try to create a Contact without both id and name?
    m = new MeetingImpl(MTGID1, cal); 
    cm = new ContactManagerImpl(); 
  }

  @Test
  public void test_Contact_getId() {
    System.out.println("TEST 1");
    assertEquals(myId, c.getId());
  }

  @Test
  public void test_Meeting_getId() {
    System.out.println("TEST 1.1");
    assertEquals(MTGID1, m.getId());
  }

  @Test
  public void test_Meeting_getDate() {
    System.out.println("TEST 1.2");
    assertEquals(cal, m.getDate());
  }

  @Test
  public void test_Meeting_getContacts_noContacts() {
    System.out.println("TEST 1.3");
    Set<Contact> mtgcons = m.getContacts();
    assertNull(mtgcons);
  }

  @Test
  public void test_getMeeting_noMeetingsYet() {
    System.out.println("TEST 1.3.1");
    int fakeMtgId = 1000;
    assertNull(cm.getMeeting(1000));
  }

  @Test
  public void test_getMeeting_meetingExists() {
    System.out.println("TEST 1.3.2");
    Set<Contact> contacts = new HashSet<Contact>(); 
    contacts.add(c);
    cm.addNewPastMeeting(contacts, cal, myMtgNote);
    Meeting mtg = cm.getMeeting(MTGIDMIN); 
    assertEquals(MTGIDMIN,mtg.getId());
  }

  //@Test
  public void test_Meeting_getContacts_1contact() {
    System.out.println("TEST 1.4");
    //int addFutureMeeting(Set<Contact> contacts, Calendar date)
  }

  @Test
  public void test_Contact_getName() {
    System.out.println("TEST 2");
    assertEquals(myName, c.getName());
  }

  @Test
  public void test_Contact_getNotes_nothingAddedYet() {
    System.out.println("TEST 3");
    assertEquals("",c.getNotes());
  }

  @Test
  public void test_Contact_getNotes_hasNotes() {
    System.out.println("TEST 4");
    String note = "note text";
    c.addNotes(note);
    assertEquals(note,c.getNotes());
  }

  // TODO: Contact specification says id should be unique. But the interface doesn't specify throwing any exceptions, so assume Contact constructors can't throw any, as it would be poor design to throw exceptions that weren't specified in the interface. How then to have Contact guarantee id-uniqueness? It seems the best way would be rewrite the interface to allow the constructor to throw an IllegalArgumentException. But in a real-world situation, could you get away with this? Assume that the interface can't be changed, so we need to manage Contact uniqueness from ContactManager.

  @Test 
  public void test_ContactManager_addNewContact_firstContact() {
    System.out.println("TEST 5");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    Set<Contact> s = cm.getContacts(CONTACTID1);
    Object[] oa = s.toArray(); 
    Contact c = (Contact) oa[0];
    assertEquals(CONTACTNAME1,c.getName());
  }

  @Test 
  public void test_ContactManager_addNewContact_twice_getContacts_singleId() {
    System.out.println("TEST 6");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    Set<Contact> s1 = cm.getContacts(CONTACTID1);
    Set<Contact> s2 = cm.getContacts(CONTACTID2);
    Object[] a1 = s1.toArray(); 
    Object[] a2 = s2.toArray(); 
    Contact c1 = (Contact) a1[0];
    Contact c2 = (Contact) a2[0];
    assertEquals(CONTACTNAME1,c1.getName());
    assertEquals(CONTACTNAME2,c2.getName());
  }

  @Test 
  public void test_ContactManager_addNewContact_twice_IdsDifferent() {
    System.out.println("TEST 7");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    Set<Contact> s = cm.getContacts(CONTACTID1, CONTACTID2);
    Object[] oa = s.toArray(); 
    Contact c0 = (Contact) oa[0];
    Contact c1 = (Contact) oa[1];
    assertNotEquals(c0.getId(),c1.getId());
  }

  @Test (expected=NullPointerException.class)
  public void test_ContactManager_addNewContact_nullName() {
    System.out.println("TEST 7.1");
    cm.addNewContact(null, CONTACTNOTES1);
  }

  @Test (expected=NullPointerException.class)
  public void test_ContactManager_addNewContact_nullNotes() {
    System.out.println("TEST 7.2");
    cm.addNewContact(CONTACTNAME1, null);
  }

  @Test
  public void test_ContactManager_addNewContact_threeTimes_getFirstTwoIds() {
    System.out.println("TEST 8");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    cm.addNewContact(CONTACTNAME3, CONTACTNOTES3);
    Set<Integer> testIdSet = new HashSet<Integer>();
    testIdSet.add(100);  
    testIdSet.add(101);  
    Set<Contact> s = cm.getContacts(CONTACTID1, CONTACTID2);
    Set<Integer> returnedIdSet = new HashSet<Integer>();
    for (Contact c : s) {
      returnedIdSet.add(c.getId());  
    }  
    assertTrue(testIdSet.equals(returnedIdSet));
  }
    
  @Test 
  public void test_ContactManager_addNewContact_100Times_getAllIds() {
    System.out.println("TEST 9");
    int numContacts = 100;
    int contactIdMax = 199;
    Set<Integer> testIdSet = new HashSet<Integer>();
    int[] idsToRequest = new int[numContacts];
    for (int curId = CONTACTIDMIN; curId <= contactIdMax; curId++) {
      String curName = "CONTACTNAME" + curId;  
      String curNotes = "CONTACTNOTES" + curId;  
      cm.addNewContact(curName, curNotes); 
      testIdSet.add(curId);  
      idsToRequest[curId-CONTACTIDMIN] = curId;
    }

    //for (int id : idsToRequest) {
      //System.out.println(id);
    //}

    Set<Contact> s = cm.getContacts(idsToRequest);
    Set<Integer> returnedIdSet = new HashSet<Integer>();
    for (Contact c : s) {
      returnedIdSet.add(c.getId());  
    }  
    assertTrue(testIdSet.equals(returnedIdSet));
  }

  @Test (expected=IllegalArgumentException.class) 
  public void test_ContactManager_getContacts_nonExistentContact() {
    System.out.println("TEST 10");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    int fakeId = 50;
    Set<Contact> s = cm.getContacts(fakeId);
  }
}
