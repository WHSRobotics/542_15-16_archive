package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.whs542.lib.sensors.EncoderTicks;

/**
 * Created by Amar2 on 5/6/2016.
 */
public class LinearSlides {
    //All measurements in inches
    static final double PULLEY_DIAMETER = 1;
    static final double SLIDE_LIMIT = 22;
    static final double ROTATION_LIMIT = PULLEY_DIAMETER * Math.PI/SLIDE_LIMIT;

    DcMotor slideMotor;

    public LinearSlides(HardwareMap slideMap)
    {
        slideMotor = slideMap.dcMotor.get("slides");
    }

    public void extendSlides(boolean extend, boolean retract)
    {
        if(extend && slideMotor.getCurrentPosition()/EncoderTicks.LINEAR_SLIDES < ROTATION_LIMIT)
        {
            slideMotor.setPower(0.8);
        }
        else if(retract && slideMotor.getCurrentPosition()/EncoderTicks.LINEAR_SLIDES > 0)
        {
            slideMotor.setPower(-0.8);
        }
        else
        {
            slideMotor.setPower(0.0);
        }
    }

    public void extendSlides(double power)
    {
        if(power>0 && slideMotor.getCurrentPosition()/EncoderTicks.LINEAR_SLIDES < ROTATION_LIMIT)
        {
            slideMotor.setPower(power);
        }
        else if(power<0 && slideMotor.getCurrentPosition()/EncoderTicks.LINEAR_SLIDES > 0)
        {
            slideMotor.setPower(power);
        }
        else
        {
            slideMotor.setPower(0.0);
        }
    }

}
