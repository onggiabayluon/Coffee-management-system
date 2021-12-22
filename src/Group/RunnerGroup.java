package Group;
public class RunnerGroup extends Group {
    private static int count;
    
    {
        this.groupID = String.format("RG%03d", ++count);
        this.groupName = "Runner";
    }

}
