package Staff;

import java.util.ArrayList;
import java.util.List;

import utils.Console;

public class StaffManager {
    private List<Staff> staffs = new ArrayList<>();

    Console console = new Console();

    public void add(Staff staff) {
        this.staffs.add(staff);
    }

    public void remove(String id) {
        this.staffs.removeIf(staff -> staff.getStaffID().equals(id));
    }

    public Staff find(String id) {
        Staff staff = staffs.stream().filter(st -> st.getStaffID().equalsIgnoreCase(id)).findFirst().orElse(null);

        if (staff == null)
            System.out.printf("!! Not found any Staff in the kitchen");
        else
            staff.prettyPrint();

        return staff;
    }

    public void list() {
        console.printTopDecor();
        console.printColumnOfStaffs();

        staffs.forEach(staff -> System.out.println(staff));

        console.printBotDecor();
    }

    public Staff findStaffsByName(String name) {
        Staff staff = staffs.stream().filter(st -> st.getStaffName().contains(name)).findFirst().orElse(null);

        if (staff == null)
            System.out.printf("!! Not found any Staff in the kitchen\n");
        else
            staff.prettyPrint();

        return staff;
    }
    
    public Staff findStaffsByGender(String gender) {
        return staffs.stream()
        .filter(st -> st.getGender().toString().equalsIgnoreCase(gender))
        .findFirst().orElse(null);
    }
    
}
