package com.kuniansky.marc.unitconverter;
/*
 * Modifications:
 * 9/18/2015 by Marc Kuniansky, Created the class and implemented the lengthConvert method.
 */
/**
 * This class contains all of the code for the conversions that take place. Each conversion
 * has its own method, and is only called by one activity.
 *
 * Created by Marc Kuniansky on September 17, 2015
 */
public class Converter
{// Begin converter class

    //Constructor
    /**
     * Constructor with no parameters
     */
    public Converter()
    {
        //Can just be empty, there are no global variables
    }

    /**
     * Takes a number, a unit, and a new unit and converts the number to the new unit.
     * @param originalNum must be a valid double.
     * @param originalUnit must be a string
     * @param desiredUnit must be a string
     * @return the new double
     */
    public double lengthConvert(double originalNum, String originalUnit, String desiredUnit)
    {
        //Make two variable doubles, one the original double and one the new one
        double num1 = originalNum;
        double num2 = 0;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = desiredUnit.toLowerCase();

        //Now there is a series of if statements to check which units are being converted from/to and
        //to do the proper operation

        if(original.equals("inches")) { //Begin converting from inches
            //First, what happens if the user sets both inputs to inches?
            if(newU.equals("inches")) { //Begin converting from inches to inches- nothing change
                num2 = originalNum;
            } //End converting from inches to inches

            //Next, inches to feet
            else if(newU.equals("feet")) { //Begin converting from inches to feet
                //12 inches in a foot, so divide by 12
                num2 = num1 / 12;
            } //End converting from inches to feet

            //Next, inches to yards
            else if(newU.equals("yards")) { //Begin converting from inches to yards
                //36 inches in a yard, so divide by 36
                num2 = num1 / 36;
            } //End converting from inches to yards

            //Next, inches to miles
            else if(newU.equals("miles")) { //Begin converting from inches to miles
                //63,360 inches in a mile
                num2 = num1 / 63360;
            } //End converting from inches to miles

            //Next, inches to millimeters
            else if(newU.equals("millimeters")) { //Begin converting from inches to millimeters
                //There are 25.4 millimeters in an inch, so multiply inches by 25.4
                num2 = num1 * 25.4;
            } //End converting from inches to millimeters

            //Next, inches to centimeters
            else if(newU.equals("centimeteters")) { //Begin converting from inches to centimeters
                //2.54cm in an inch, multiply inches by 2.54
                num2 = num1 * 2.54;
            } //End converting from inches to centimeters

            //Next, inches to meters
            else if(newU.equals("meters")) { //Begin converting from inches to meters
                //0.0254 meters to an inch, so multiply inches by 0.0254
                num2 = num1 * 0.0254;
            } //End converting from inches to meters

            //Finally, if none of the others are true then convert inches to kilometers
            else { //Begin converting from inches to kilometers
                //0.0000254km in an inch
                num2 = num1 * 0.0254;
            } //End converting from inches to kilometers
        } //End converting from inches

        //Next, converting from feet
        else if(original.equals("feet"))
        { //Begin conversions from feet
            //First, what happens if the user converts feet to feet? Nothing.
            if(newU.equals("feet"))
            { //Begin converting feet to feet
                num2 = num1;
            } //End converting feet to feet

            //Next, how should we convert feet to other empirical units?
            //Feet to inches.
            else if(newU.equals("inches"))
            { //Begin converting feet to inches
                //12 inches in a foot, multiply by 12
                num2 = num1*12;
            } //End converting feet to inches

            //Feet to yards
            else if(newU.equals("yards"))
            { //Begin feet to yards
                //3 feet in a yard
                num2 = num1/3;
            } //End feet to yards

            //Feet to miles
            else if(newU.equals("miles"))
            { //Begin converting feet to miles
                //5,280 feet in a mile
                num2 = num1/5280;
            } //End converting feet to miles

            //Now convert to metric units

            //Feet to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting feet to millimeters
                //304.8 millimeters in a foot
                num2 = num1*304.8;
            } //End converting feet to millimeters

            //Feet to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from feet to centimeters
                //30.48 Centimeters in a foot
                num2 = num1*30.48;
            } //End converting from feet to centimeters

            //Feet to meters
            else if(newU.equals("meters"))
            { //Begin converting from feet to meters
                //0.3048 meters in a foot
                num2 = num1*0.3048;
            } //End converting from feet to meters

            //Feet to kilometers
            else
            { //Begin converting from feet to kilometers
                //0.0003048 kilometers in a meter
                num2 = num1*0.0003048;
            } //End converting from feet to kilometers
        } //End conversions from feet

        //Next, conversions from yards
        else if(original.equals("yards"))
        { //Begin conversions from yards

            //Yards to yards
            if(newU.equals("yards"))
            { //Begin converting from yards to yards
                num2 = num1;
            } //End converting from yards to yards

            //First, convert between empircal units

            //Yards to inches
            else if(newU.equals("inches"))
            { //Begin converting from yards to inches
                //36 inches in a yard
                num2 = num1*36;
            } //End converting from yards to inches

            //Yards to feet
            else if(newU.equals("feet"))
            { //Begin converting from yards to feet
                //3 feet to a yard
                num2 = num1*3;
            } //End converting from yards to feet

            //Yards to miles
            else if(newU.equals("miles"))
            { //Begin converting from yards to miles
                //1760 yards in a mile
                num2 = num1/1760;
            } //End converting from yards to miles

            //Now metric units

            //Yards to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting yards to millimeters
                //914.4 millimeters in a yard
                num2 = num1*914.4;
            } //End converting yards to millimeters

            //Yards to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting yards to centimeters
                //91.44 centimeters in a yard
                num2 = num1*91.44;
            } //End converting yards to centimeters

            //Yards to meters
            else if(newU.equals("meters"))
            { //Begin conversion from yards to meters
                num2 = num1*0.9144;
            } //End conversion from yards to meters

            //Yards to kilometers
            else
            { //Begin conversion from yards to kilometers
                //1,093.61 yards in a kilometer
                num2 = num1/1093.61;
            } //End conversion from yards to kilometers
        } //End conversions from yards

        //Next, convert from miles
        else if(original.equals("miles"))
        { //Begin conversions from miles
            //First, miles to miles
            if(newU.equals("miles"))
            { //Begin converting from miles to miles
                num2 = num1;
            } //End converting from miles to miles

            //Now, convert to the rest of the empirical units
            //Miles to inches
            else if(newU.equals("inches"))
            { //Begin converting from miles to inches
                //6330 inches in a mile
                num2 = num1*6330;
            } //End converting from miles to inches

            //Miles to feet
            else if(newU.equals("feet"))
            { //Begin converting from miles to feet
                //5280 feet in a mile
                num2 = num1*5280;
            } //End converting from miles to feet

            //Miles to yards
            else if(newU.equals("yards"))
            { //Begin converting from miles to yards
                //1760 yards in a mile
                num2 = num1*1760;
            } //End converting from miles to yards

            //Now do the metric conversions

            //Miles to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from miles to millimeters
                //1,609,000 millimeters in a mile
                num2 = num1*1609340;
            } //End converting from miles to millimeters

            //Miles to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from miles to centimeters
                //16,0934 centemeters in a miles
                num2 = num1*160934;
            } //End converting from miles to centimeters

            //Miles to meters
            else if(newU.equals("meters"))
            { //Begin converting from miles to meters
                //1609.34 meters in a mile
                num2 = num1*1609.34;
            } //End converting from miles to meters

            //Miles to kilometers
            else
            { //Begin converting miles to kilometers
                //1.60934 kilometers in a mile
                num2 = num1*1.60934;
            } //End converting miles to kilometers
        } //End conversions from miles

        //Next, convert from millimeters
        else if(original.equals("millimeters"))
        { //Begin converting from millimeters

            //Millimeters to millimeters
            if(newU.equals("millimeters"))
            { //Begin converting from millimeters to millimeters
                num2 = num1;
            } //End converting from millimeters to millimeters

            //Emperical units first

            //Millimeters to inches
            else if(newU.equals("inches"))
            { //Begin converting from millimeters to inches
                num2 = num1*25.4;
            } //End converting from millimeters to inches

            //Millimeters to feet
            else if(newU.equals("feet"))
            { //Begin converting from millimeters to feet
                num2 = num1/304.8;
            } //End converting from millimeters to feet

            //Millimeters to yards
            else if(newU.equals("yards"))
            { //Begin converting from millimeters to yards
                num2 = num1/914.4;
            } //End converting from millimeters to yards

            //Millimeters to miles
            else if(newU.equals("miles"))
            { //Begin converting from millimeters to miles
                num2 = num1/1609000;
            } //End converting from millimeters to miles

            //Now metric

            //Millimeters to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from millimeters to centimeters
                num2 = num1/10;
            } //End converting from millimeters to centimeters

            //Millimeters to meters
            else if(newU.equals("meters"))
            { //Begin converting from millimeters to meters
                num2 = num1/1000;
            } //End converting from millimeters to meters

            //Millimeters to Kilomters
            else
            { //Begin converting from millimeters to kilometers
                num2 = num1/1000000;
            } //End converting from millimeters to kilometers

        } //End converting from millimeters

        //Next, convert from centimeters
        else if(original.equals("centimeters"))
        { //Begin converting from centimeters

            //Centimeters to centimeters
            if(newU.equals("centimeters"))
             { //Begin converting from centimeters to centimeters
                 num2 = num1;
             } //End converting from centimeters to centimeters

            //Empirical units

            //Centimeters to inches
            else if(newU.equals("inch"))
            { //Begin converting from centimeters to inches
                num2 = num1/2.54;
            } //End converting from centimeters to inches

            //Centimeters to feet
            else if(newU.equals("feet"))
            { //Begin converting from centimeters to feet
                num2=num1/30.48;
            } //End converting from centimeters to feet

            //Centimeters to yards
            else if(newU.equals("inch"))
            { //Begin converting from centimeters to yards
                num2=num1/91.44;
            } //End converting from centimeters to yards

            //Centimeters to miles
            else if(newU.equals("mile"))
            { //Begin converting from centimeters to miles
                num2 = num1/160934;
            } //End converting from centimeters to miles

            //Metric units

            //Centimeters to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from centimeters to millimeters
                num2 = num1*10;
            } //End converting from centimeters to millimeters

            //Centimeters to meters
            else if(newU.equals("meters"))
            { //Begin converting from centimeters to meters
                num2 = num1/100;
            } //End converting from centimeters to meters

            //Centimeters to kilometers
            else
            { //Begin converting from centimeters to kilometers
                num2 = num1/100000;
            } //End converting from centimeters to kilometers
        } //End converting from centimeters

        //Next, convert from meters
        else if(original.equals("meters"))
        { //Begin converting from meters

            //Convert meters to meters
            if(newU.equals("meters"))
            { //Begin converting from meters to meters
                num2 = num1;
            } //End converting from meters to meters

            //Empirical units

            //Meters to inches
             else if(newU.equals("inches"))
             { //Begin converting from meters to inches
                 num2 = num1*39.3701;
             } //End converting from meters to inches

            //Meters to feet
            else if(newU.equals("feet"))
            { //Begin converting from meters to feet
                num2 = num1*3.28084;
            } //End converting from meters to feet

            //Meters to yards
            else if(newU.equals("yards"))
            { //Begin converting from meters to yards
                num2 = num1*1.09361;
            } //End converting from meters to yards

            //Meters to miles
            else if(newU.equals("miles"))
            { //Begin converting from meters to miles
                num1 = num2/1609.34;
            } //End converting from meters to miles

            //Metric units

            //Meters to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from meters to millimeters
                num1 = num2*1000;
            } //End converting from meters to millimeters

            //Meters to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from meters to centimeters
                num2 = num1*100;
            } //End converting from meters to centimeters

            //Meters to kilometers
            else
            { //Begin converting from meters to kilometers
                num2 =num1/1000;
            } //End converting from meters to kilometers
        } //End converting from meters

        //Finally, try converting from kilometers
        else
        { //Begin converting from kilometers

            //Kilometers to kilometers
            if(newU.equals("kilometers"))
            { //Begin converting from kilometers to kilometers
                num2 = num1;
            } //End converting from kilometers to kilometers

            //Empirical units

            //Kilometers to inches
            else if(newU.equals("inches"))
            { //Begin converting from kilometers to inches
                num2 = num1*39370.1;
            } //End converting from kilometers to inches

            //Kilometers to feet
            else if(newU.equals("feet"))
            { //Begin converting from kilometers to feet
                num2 = num1*3280.84;
            } //End converting from kilometers to feet

            //Kilometers to yards
            else if(newU.equals("yards"))
            { //Begin converting from kilometers to yards
                num2 = num1*1093.61;
            } //End converting from kilometers to yards

            //Kilometers to miles
            else if(newU.equals("miles"))
            { //Begin converting from kilometers to miles
                num2 = num1/1.60934;
            } //End converting from kilometers to miles

            //Metric units

            //Kilometers to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from kilometers to millimeters
                num2 = num1*1000000;
            } //End converting from kilometers to millimeters

            //Kilometers to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from kilometers to centimeters
                num2 = num1*100000;
            } //End converting from kilometers to centimeters

            //Kilometers to meters
            else
            { //Begin converting from kilometers to meters
                num2 = num1*1000;
            } //End converting from kilometers to meters
        } //End converting from kilometers

    //num2 is the number we want; return it
    return num2;
    } //End lengthConvert

} //End converter class
