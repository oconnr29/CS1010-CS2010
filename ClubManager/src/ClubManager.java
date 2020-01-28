import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ClubMember> membersList = new ArrayList<ClubMember>();
		try {
			FileReader fr = new FileReader("members");
			BufferedReader br = new BufferedReader(fr);
			while (br.read() != -1) {
				String[] membersArray = br.readLine().split(", ");
				String name = membersArray[0];
				String address = membersArray[1];
				String email = membersArray[2];
				String dateOfReg = membersArray[3];
				ClubMember clubMember = new ClubMember(name, address, email, dateOfReg);
				membersList.add(clubMember);
			}
			ClubManager manager = new ClubManager();
			do {
			boolean inputFound = false;
			String input = "";
			do {
				System.out.print(
						"Hello manager, type what you would like to do or type 'inputs' to see a list of all available inputs:");
				Scanner userInput = new Scanner(System.in);
				if (userInput.hasNext()) {
					input = userInput.next();
					inputFound = true;
				} else
					System.out.print("Error: No input please try again.");
				if (input.equals("inputs")) {
					System.out.print("The commands you can input are:"
							+ "\n'printMembers' which allows you to print all club members names,"
							+ "\n'getMember' which allows you to search for a club member and returns their details,"
							+ "\n'updateMember' which allows you to change details about members,"
							+ "\n'createGroup'  which allows you to create a new club group,"
							+ "\n'addMemberToGroup' which allows you to add a member to a group,"
							+ "\n'printGroupMembers' which allows you to see all the members of a certain group,"
							+ "\n'printGroups' which allows you to see all groups and how many members each has.\n");
					inputFound = false;
				}
			} while (!inputFound);
			boolean finished = false;
			if (input.equals("printMembers"))
				printMembers(membersList);
			if (input.equals("getMember")) {
				do {
				String name = null;
				System.out.print("Who would you like to search for?");
				Scanner userInput = new Scanner(System.in);
				if (userInput.hasNext())
					name = userInput.next();
				if (userInput.hasNext())
					name += " "+userInput.next();
				ClubMember member = getMember(membersList, name);
				if (member != null) {
				System.out.print(member);
				finished = true;
				} else
					System.out.print("Error: This person is not a member of this club, make sure you spelt their name right.\n");
				}while (!finished);
			}
			if (input.equals("updateMember")) {
				do {
				String name = null;
				String address = null;
				String email = null;
				System.out.print("Who would you like to update?");
				Scanner userInput = new Scanner(System.in);
				if (userInput.hasNext())
					name = userInput.next();
				if (userInput.hasNext())
					name += " "+userInput.next();
				ClubMember member = getMember(membersList, name);
				if (member != null) {
				System.out.print("If you would like to update their address please enter their new address if not just enter a space:");
				Scanner addressInput = new Scanner(System.in);
				if (addressInput.hasNext())
					address = addressInput.next();
				System.out.print("If you would like to update their address please enter their new address if not just enter a space:");
				Scanner emailInput = new Scanner(System.in);
				if (emailInput.hasNext())
					address = emailInput.next();
				updateMember(member, address, email);
				finished = true;
				System.out.print("Member updated.");
				}
				else
					System.out.print("Error: This person is not a member of this club, make sure you spelt their name right.\n");
				}while (!finished);
			}
			
			} while (true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printMembers(ArrayList<ClubMember> membersList) {
		for (int i = 0; i < membersList.size(); i++) {
			System.out.println(membersList.get(i).getName());
		}
	}

	public static ClubMember getMember(ArrayList<ClubMember> memberList, String name) {
		ClubMember member = null;
		for (int i = 0; i < memberList.size(); i++) {
			member = memberList.get(i);
			if (name.equals(member.getName())) {
				return member;
			}
		}
		return null;
	}

	public static void updateMember(ClubMember member, String address, String email) {
		if (member != null) {
			if (address != null) {
				member.setAddress(address);
			}
			if (email != null) {
				member.setEmail(email);
			}
		}
	}

	public Group CreateGroup(int groupId, String groupDescription) {
		if (groupId >= 0) {
			ArrayList<ClubMember> memberList = new ArrayList<ClubMember>();
			Group newGroup = new Group(groupId, groupDescription, memberList);
			return newGroup;
		} else
			return null;
	}

	public void addMemberToGroup(Group group, ClubMember member) {
		ArrayList<ClubMember> groupMembers = group.getMemberList();
		boolean memberFound = false;
		int count = 0;
		while (!memberFound) {
			if (groupMembers.get(count).getName().equals(member.getName())) {
				memberFound = true;
			} else {
				count++;
			}
		}
		if (!memberFound) {
			groupMembers.add(member);
		}
	}

	public void printGroupMembers(Group group) {
		ArrayList<ClubMember> groupMembers = group.getMemberList();
		if (groupMembers != null && groupMembers.size() > 0) {
			for (int index = 0; index < groupMembers.size(); index++) {
				System.out.println(groupMembers.get(index).getName());
			}
		}
	}

	public void printGroupNamesAndNumberOfMembers(ArrayList<Group> groupList) {
		if (groupList != null) {
			for (int i = 0; i < groupList.size(); i++) {
				Group group = groupList.get(i);
				System.out.println("Group description: " + group.getGroupDescription());
				ArrayList<ClubMember> groupMembers = group.getMemberList();
				System.out.println("Number of members: " + groupMembers.size());
			}
		}
	}
}
