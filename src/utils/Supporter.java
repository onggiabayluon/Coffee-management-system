package utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Supporter {
    public static final Scanner sc = new Scanner(System.in);

    public int inputInt() {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Integers only, Choose again: ");
            sc.next();
        }

        return number;
    }

    public String inputString() {
        String str = "";
        try {
            str = sc.next();
        } catch (InputMismatchException exception) {
            System.out.println("String only, Type again: ");
            // sc.next();
        }
        
        return str;
    }

    public Double inputDouble() {
        Double db = 0.0;
        try {
            db = sc.nextDouble();
        } catch (InputMismatchException exception) {
            System.out.println("String only, Type again: ");
            // sc.next();
        }

        return db;
    }

    public String inputName() {
        String str = "";
        try {
            sc.nextLine();
            str = sc.nextLine();
            // str = sc.nextLine();
            // sc.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println("String only, Type again: ");
        }
        // sc.nextLine();
        return str;
    }

    public Date toMonthDate(String month) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");

        try {
            return formatter.parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getMonth(Date target) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");

        return Integer.parseInt(formatter.format(target));
    }

    public String toSimpleDateFormat(Date target) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(target);
    }

    public Date getDate(String date) {
        SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return F.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date toDateFormat(String strDate) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
