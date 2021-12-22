package Group;
public class SecurityGroup extends Group {
    private static int count;

    {
        this.groupID = String.format("SG%03d", ++count);
    }

    public SecurityGroup(String groupName) {
        super(groupName);
    }
}
