import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] arg) {
        int investment = 50000;
        int years = 1;
        int investmentRate = 12;
        int compountInterst;
        int interstRate = (investment * investmentRate * years) / 100;
        int rate = (interstRate) / 100;
        System.out.println(rate);
        int componentIntrest = investment + rate;
        System.out.println(componentIntrest);
        Date date = new Date();
        Calendar calender = Calendar.getInstance();
//        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        System.out.println(month);
        int monthCount = 1;
        while(monthCount < month){
            interstRate += rate;
            monthCount++;
        }
        System.out.println(interstRate);
        investment += interstRate;
        System.out.println(investment);
    }
}