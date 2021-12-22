package Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import utils.Console;
import utils.Supporter;

public class StaffManager {
    private List<Staff> staffs = new ArrayList<>();

    Supporter support = new Supporter();
    Console console = new Console();

    public void add(Staff staff) {
        this.staffs.add(staff);
    }

    public void update(String id) {
        Staff staff = staffs.stream().filter(st -> st.getStaffID().equalsIgnoreCase(id)).findFirst().orElse(null);
        staff.input();
    }

    public void remove(String id) {
        this.staffs.removeIf(staff -> staff.getStaffID().equals(id));
    }

    public Staff findStaffByID(String id) {
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
    
    public List<Staff> findStaffsByGender(String gender) {
        List<Staff> listOfStaff = staffs.stream()
                .filter(st -> st.getGender().toString().equalsIgnoreCase(gender))
                .collect(Collectors.toList());

        if (listOfStaff == null)
            System.out.printf("!! Not found any Staff in the kitchen\n");
        else
            listOfStaff.forEach(staff -> staff.prettyPrint());

        return listOfStaff;
    }

    public List<Staff> findStaffsByAddress(String address) {
        List<Staff> listOfStaff = staffs.stream()
                .filter(st -> st.getAddress().equalsIgnoreCase(address))
                .collect(Collectors.toList());

        if (listOfStaff == null)
            System.out.printf("!! Not found any Staff in the kitchen\n");
        else
            listOfStaff.forEach(staff -> staff.prettyPrint());

        return listOfStaff;
    }
    
    public Staff findStaffsByBirthDate(String birth_date) {
        Date birthDate = support.getDate(birth_date); 
        Staff staff = staffs.stream().filter(st -> st.getBirthDate().equals(birthDate)).findFirst().orElse(null);

        if (staff == null)
            System.out.printf("!! Not found any Staff in the kitchen\n");
        else
            staff.prettyPrint();

        return staff;
    }

    public List<Staff> CelebrateStaffsBirthDateInMonth(String month) {
        List<Staff> listOfStaff = staffs.stream()
                .filter(st -> support.getMonth(st.getBirthDate()) == support.getMonth(support.toMonthDate(month)))
                .collect(Collectors.toList());

        if (listOfStaff.isEmpty())
            System.out.printf(">> Not found any Staff With the same month\n");
        else
            System.out.printf(">> Happy BirthDate to All Of those <<\n");
            listOfStaff.forEach(staff -> staff.prettyPrint());

        return listOfStaff;
    }
    
}
