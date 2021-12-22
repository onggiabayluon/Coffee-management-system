package Group;
public abstract class Group {

	protected String groupID;

	protected String groupName;

	public Group() {}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * GETTER SETTER 
	 */

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
