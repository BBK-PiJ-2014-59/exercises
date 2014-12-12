public class ContactImpl implements Contact {
  private int id;
  private String name;
  private String note;

  public ContactImpl(int id, String name) {
    this.id = id;
    this.name = name;
    this.note = "";
  }

	public int getId() {
    return id;
  }
	
	public String getName() {
    return name;
  }
	
	public String getNotes() {
    return note;
  }
	
	public void addNotes(String note) {
    this.note = note;
  }

}

