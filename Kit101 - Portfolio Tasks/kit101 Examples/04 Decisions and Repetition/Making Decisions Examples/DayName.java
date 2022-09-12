import java.util.Random;

/**
 * Demonstrates {@code switch} construct with an enumerated type. Uses features
 * of the Enum type that are <em>not</em> required in ths unit.
 *
 * @author James Montgomery
 * @version 1 (March 2014)
 */
public class DayName {
    /** The Day type, an enumeration of days of the week. */
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Day day;
        String dayName;

        System.out.println("Picking a random day");
        //This part can be ignored. You will rarely have to deal
        // with the internal index of an enum value.
        day = Day.values()[ rand.nextInt(Day.values().length) ];
        //we *could* have selected a value manually, with day = Day.TUESDAY;

        //The rest is code that you *will* need to be able to understand
        switch ( day ) {
            case SUNDAY: dayName = "Sunday";
                         break;
            case MONDAY: dayName = "Monday";
                         break;
            case TUESDAY: dayName = "Tuesday";
                          break;
            case WEDNESDAY: dayName = "Wednesday";
                            break;
            case THURSDAY: dayName = "Thursday";
                           break;
            case FRIDAY: dayName = "Friday";
                         break;
            default: dayName = "Saturday";
        }

        System.out.println("The selected day is " + dayName);
    }

}
