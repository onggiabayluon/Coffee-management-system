package Group;
public class CookGroup extends Group {
    private static int count;

    {
        this.groupID = String.format("CG%03d", ++count);
        this.groupName = "Cook";
    }
    
}
