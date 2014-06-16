// TODO: replace Set.addAll() with Collections.addAll(). Use most generic interface possible, so you can change implementation later.

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Calendar;

public class ContactManagerTests {


  static private final int JESSEID = 999;
  static private final String JESSENAME = "Jesse";
  static private final Contact JESSE = new ContactImpl(JESSEID, JESSENAME);

  static private final int CONTACTIDMIN = 100;
  static private final String USERNAME = "USERNAME";

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

  private int myId;
  private String myName;
  private Contact user;
  private String userName;
  private Contact c;
  private Set<Contact> contacts; 
  private Meeting m;
  private ContactManager cm;
  private Calendar cal = Calendar.getInstance();
  private String myMtgNote; 

  private Set<Contact> populateTestContactSet(int loId, int hiId) {
    Set <Contact> testContactSet = new HashSet<Contact>();
    for (int id=loId; id <= hiId; id++) {
      String name = "dummyContactName" + id;
      testContactSet.add(new ContactImpl(id, name));
    } 
    for (Contact ci: testContactSet) {
      System.out.println(ci.getName());
    }
    return testContactSet;
  }

  @Before
  public void buildUp() {
    myId = 101; 
    userName = "JO"; 
    myName = "Jane"; 
    myMtgNote = "Wow. So meeting."; 
    c = new ContactImpl(myId, myName); // TODO: what if you try to create a Contact without both id and name?
    m = new MeetingImpl(MTGID1, cal); 
    cm = new ContactManagerImpl(); 
    contacts = new HashSet<Contact>(); 
  }

  // TODO: notes 

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
  public void test_Meeting_getContacts_NoContacts() {
    System.out.println("TEST 1.2.5");
    int mtgid = 1000;
    Meeting justUser = new MeetingImpl(mtgid, cal); 
    Set<Contact> sc = new HashSet<Contact>();
    sc.addAll(justUser.getContacts());
    assertEquals(1,sc.size());
  }

  @Test
  public void test_Meeting_getContacts_1Contact() {
    System.out.println("TEST 1.3");
    int mtgid = 1000;
    Set<Contact> sc = new HashSet<Contact>();
    Meeting justUser = new MeetingImpl(mtgid, cal); 
    sc.add(JESSE);
    sc.addAll(justUser.getContacts());

    Meeting userAndJesse = new MeetingImpl(mtgid, cal, sc); 
    Set<Contact> sc2 = new HashSet<Contact>(); 
    sc2 = userAndJesse.getContacts();
    assertTrue(sc.equals(sc2));
  }

  @Test
  public void test_Meeting_getContacts_2Contacts() {
    System.out.println("TEST 1.3.0");

    int fakeMtgId = 1000;
    Meeting justUser = new MeetingImpl(fakeMtgId, cal);

    Set<Contact> fixtureContactSet = new HashSet<Contact>();
    fixtureContactSet.addAll(justUser.getContacts()); // has just the user so far
  
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = populateTestContactSet(101,102);

    fixtureContactSet.addAll(tcs);
    
    Meeting mtg = new MeetingImpl(fakeMtgId, cal, fixtureContactSet);
    assertEquals(fixtureContactSet, mtg.getContacts());
  }

  // TODO: parameterized test of above using number of contacts as parameter

  @Test
  public void test_getMeeting_noMeetingsYet() {
    System.out.println("TEST 1.3.1");
    Meeting mtg = cm.getMeeting(MTGIDMIN); 
    assertNull(mtg);
  }

  @Test
  public void test_getMeeting_meetingExists_1meeting() {
    System.out.println("TEST 1.3.2");
    contacts.add(c);
    cm.addNewPastMeeting(contacts, cal, myMtgNote);
    Meeting mtg = cm.getMeeting(MTGIDMIN); 
    assertEquals(MTGIDMIN,mtg.getId());
  }

  @Test
  public void test_getMeeting_meetingExists_2meetings() {
    System.out.println("TEST 1.3.3");
    contacts.add(c);
    cm.addNewPastMeeting(contacts, cal, myMtgNote);
    cm.addNewPastMeeting(contacts, cal, myMtgNote);
    Meeting mtg1 = cm.getMeeting(MTGIDMIN); 
    Meeting mtg2 = cm.getMeeting(MTGIDMIN+1); 
    assertEquals(MTGIDMIN,mtg1.getId());
    assertEquals(MTGIDMIN+1,mtg2.getId());
  }

  @Test
  public void test_getMeeting_meetingDoesntExist_2meetings() {
    System.out.println("TEST 1.3.4");
    contacts.add(c);
    cm.addNewPastMeeting(contacts, cal, myMtgNote);
    cm.addNewPastMeeting(contacts, cal, myMtgNote);
    Meeting mtg = cm.getMeeting(MTGIDMIN+100); 
    assertNull(mtg);
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

  @Test (expected=NullPointerException.class) 
  public void test_ContactManager_getContacts_nullStringParameter() {
    System.out.println("TEST 11");
    String name = null;
    Set<Contact> s = cm.getContacts(name);
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_NotFound() {
    System.out.println("TEST 12");
    String name = "foooo";
    Set<Contact> s = cm.getContacts(name);
    assertTrue(s.isEmpty());
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_FoundMatch() {
    System.out.println("TEST 13");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    Set<Contact> s = cm.getContacts(CONTACTNAME1);
    assertFalse(s.isEmpty());
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_FoundOneMatch() {
    System.out.println("TEST 14");
    int matchesNeeded = 1; // TODO: parameterize!
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2); 
    Set<Contact> s = cm.getContacts(CONTACTNAME1);
    assertEquals(matchesNeeded, s.size());
    Object[] oa = s.toArray(); 
    Contact c = (Contact) oa[0];
    assertEquals(CONTACTNAME1,c.getName());
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_FoundTwoMatches() {
    System.out.println("TEST 15");
    int matchesNeeded = 2; // TODO: parameterize!
    String match1 = "Jesse";
    String match2 = match1 + " O";
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2); 
    cm.addNewContact(match1, CONTACTNOTES1); 
    cm.addNewContact(match2, CONTACTNOTES2); 
    Set<Contact> s = cm.getContacts(match1);
    assertEquals(matchesNeeded, s.size());
    
    // TODO: add back in with eg SortedSet using custom Comparator.   
    // Otherwise BAD TEST. inconsistent results. Sort Object array and then run assertions. ...use Sorted Set?
    /*
    Object[] oa = s.toArray(); 
    Contact c1 = (Contact) oa[0];
    assertEquals(match1,c1.getName());
    Contact c2 = (Contact) oa[1];
    */
  }

  @Test
  public void test_getPastMeeting_NonExistentId() {
    System.out.println("TEST 16");
    assertNull(cm.getPastMeeting(MTGIDMIN)); 
  }

  @Test
  public void test_getPastMeeting_Exists() {
    System.out.println("TEST 17");
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = populateTestContactSet(101,102);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    assertNotNull(cm.getPastMeeting(MTGIDMIN)); 
  }

  
}