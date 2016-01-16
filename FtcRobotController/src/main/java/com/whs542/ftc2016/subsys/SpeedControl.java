package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.ftc2016.RobotMain;

/**
 * Created by LucyWang on 12/18/15.
 */
public class SpeedControl
{
    public double power;

    public SpeedControl()
    {

    }

    public void slowMotorLinearly(DcMotor motor) {
        //Slow down which motor you want to slow down
        power = motor.getPower();

        while (Math.abs(power) > 0.0000001)
        {
            power *= .8;
            motor.setPower(power);
        }

        motor.setPower(0);
    }

    public void trapezoidalVelocity()
    {

    }

    public void trapezoidalAcceleration()
    {

    }

    public static void speedUpMotor(DcMotor motor, double desiredPower)
    {
        //Speed up the motor you want to speed up
        double power = motor.getPower();
        while(Math.abs(power) < Math.abs(desiredPower))
        {
            power *= 1.3;
            motor.setPower(power);
        }

        motor.setPower(desiredPower);

    }
}
