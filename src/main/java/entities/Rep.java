package entities;

public class Rep {
	
	private long repId;
	
	private String firstName;
	
	private String lastName;

	public Rep(long repId, String firstName, String lastName) {
		super();
		this.repId = repId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getRepId() {
		return repId;
	}

	public void setRepId(long repId) {
		this.repId = repId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
