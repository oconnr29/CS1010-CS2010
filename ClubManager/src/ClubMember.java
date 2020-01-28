public class ClubMember {
	private String name;
	private String address;
	private String email;
	private String dateOfReg;
	public ClubMember(String name, String address, String email, String dateOfReg) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.dateOfReg = dateOfReg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfReg() {
		return dateOfReg;
	}
	public void setDateOfReg(String dateOfReg) {
		this.dateOfReg = dateOfReg;
	}
	@Override
	public String toString() {
		return "ClubMember [name=" + name + ", address=" + address + ", email=" + email + ", dateOfReg=" + dateOfReg
				+ "]";
	}
	

}
