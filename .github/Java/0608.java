import java.text.DecimalFormat;

public class Homework0608 {
    /** Main method */
    public static void main(String[] args) {
        System.out.println( "摄氏度" + "    " + "华氏度" + "          " + "华氏度" + "   " + "摄氏度" + " " );
        System.out.println( "——————————————————————————————————————————" );
        DecimalFormat dcmFmt1 = new DecimalFormat("0.0");
        DecimalFormat dcmFmt2 = new DecimalFormat("0.00");
        for ( double celsius = 40.0 ; celsius >= 31.0 ; celsius--){
            if ( celsius >= 38.0 ) {
                System.out.println(celsius + "     " + dcmFmt1.format(celsiusToFarenheit(celsius)) + "            " + (120.0 - (40.0 - celsius) * 10)
                        + "   " + dcmFmt2.format(farenheitToCelsius(120.0 - (40.0 - celsius) * 10)) + " ");
            }
            else {
                System.out.println(celsius + "     " + dcmFmt1.format(celsiusToFarenheit(celsius)) + "             " + (120.0 - (40.0 - celsius) * 10)
                        + "    " + dcmFmt2.format(farenheitToCelsius(120.0 - (40.0 - celsius) * 10)) + " ");
            }
        }
    }

    /** Convert from Celsius to Farenheit */
    public static double celsiusToFarenheit(double celsius) {
        double farenheit = (9.0 / 5) * celsius + 32 ;
        return farenheit;
    }

    /** Convert from Farenheit to Celsius*/
    public static double farenheitToCelsius(double farenheit) {
        double celsius = (5.0 / 9) * ( farenheit - 32 ) ;
        return celsius;
    }
}