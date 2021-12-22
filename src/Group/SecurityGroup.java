package Group;
public class SecurityGroup extends Group {
    private static int count;

    {
        this.groupID = String.format("SG%03d", ++count);
        this.groupName = "Security";
    }

}
