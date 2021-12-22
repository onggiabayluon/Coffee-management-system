package Staff;

import java.util.Date;
import java.util.Scanner;

import Group.Group;
import utils.Console;
import utils.Supporter;

public class Staff {
	protected static final Scanner sc = new Scanner(System.in);
	
	private static int count;

	private String staffID;

	private String staffName;

	private Gender gender;

	private String address;

	private Date birthDate;

	private Date startDate;

	private Group group;

	{
		this.staffID = String.format("S%03d", ++count);
	}

	Supporter support = new Supporter();
	Console console = new Console();

	public Staff(String staffName, Gender gender, String address, String birthDate, String startDate, Group group) {
		this.staffName = staffName;
		this.gender = gender;
		this.address = address;
		this.birthDate = support.getDate(birthDate);
		this.startDate = support.getDate(startDate);
		this.group = group;
	}

	public Staff(String staffName, Gender gender, String address, String birthDate, String startDate) {
		this.staffName = staffName;
		this.gender = gender;
		this.address = address;
		this.birthDate = support.getDate(birthDate);
		this.startDate = support.getDate(startDate);
	}

	public Staff() {

	}

	public void input() {
		System.out.print("Name: ");
		this.staffName = sc.nextLine();

		System.out.print("Address: ");
		this.address = sc.nextLine();

		sc.nextLine();

		// To be continued

		System.out.print("Create successfully\n");
	}

	public void prettyPrint() {
		console.printTopDecor();
		console.printColumnOfStaffs();
		System.out.println(this);
		console.printBotDecor();
	}

	@Override
	public String toString() {
		return String.format("%8s %-25s %20s %12s %10s %12s %12s",
				this.staffID,
				this.staffName,
				this.address,
				this.gender,
				support.toSimpleDateFormat(this.birthDate),
				support.toSimpleDateFormat(this.startDate),
				this.group.getGroupName());
	}

	/**
	 * GETTER SETTER
	 */

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
