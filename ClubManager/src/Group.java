import java.util.ArrayList;

public class Group {
	private int groupid;
	private String groupDescription;
	private ArrayList<ClubMember> memberList;
	public ArrayList<ClubMember> getMemberList() {
		return memberList;
	}
	public void setMemberList(ArrayList<ClubMember> memberList) {
		this.memberList = memberList;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	
	public Group(int groupid, String groupDescription, ArrayList<ClubMember> memberList) {
		super();
		this.groupid = groupid;
		this.groupDescription = groupDescription;
		this.memberList = memberList;
	}
}
