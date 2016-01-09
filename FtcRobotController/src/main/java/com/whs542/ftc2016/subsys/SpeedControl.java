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

    public void slowMotorLinearly(DcMotor motorToSlowDown)
    {
        //Slow down which motor you want to slow down
        power = motorToSlowDown.getPower();

        while(Math.abs(power) > 0.0000001)
        {
            motorToSlowDown.setPower(power/2);
        }

        motorToSlowDown.setPower(0);
    }

    public void trapezoidalVelocity()
    {

    }

    public void trapezoidalAcceleration()
    {

    }

    public static void speedUpMotor(DcMotor motorToSpeedUp, double powerYouWant)
    {
        //Speed up the motor you want to speed up
        double currentPower = motorToSpeedUp.getPower();
        while(currentPower < powerYouWant)
        {
            motorToSpeedUp.setPower(currentPower * 1.3);
        }

        motorToSpeedUp.setPower(powerYouWant);
    }
}
