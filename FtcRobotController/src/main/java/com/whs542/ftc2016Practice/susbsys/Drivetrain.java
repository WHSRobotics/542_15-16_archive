package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.Wire.Bno055;

import static java.lang.Math.*;

/**
 * Created by Amar2 on 4/28/2016.
 */
public class Drivetrain {
    //Drivetrain is one word. This is important.
    //All measurements in inches, because 'murica

    public static final double WHEEL_DIAMETER = ;
    public static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER*Math.PI;
    public static final int ENCODER_TICKS = ;

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    Bno055 driveGyro;

    double rotations;
    double distanceTraveled;

    int oldDeg;
    int newDeg;

    public Drivetrain (HardwareMap driveMap) {
        frontLeft = driveMap.dcMotor.get("frontLeft");
        frontRight = driveMap.dcMotor.get("frontRight");
        backLeft = driveMap.dcMotor.get("backLeft");
        backRight = driveMap.dcMotor.get("backRight");

        driveGyro = new Bno055(driveMap, "driveGyro");
    }

    public void move (double leftStickY, double rightStickY){

        frontLeft.setPower(leftStickY);
        backLeft.setPower(leftStickY);
        frontRight.setPower(rightStickY);
        backRight.setPower(rightStickY);

    }

    public void moveAuto (double distance, double speed){

        rotations = frontLeft.getCurrentPosition()/ENCODER_TICKS;
        distanceTraveled = rotations*WHEEL_CIRCUMFERENCE;

        while (distanceTraveled<distance){

                frontLeft.setPower(speed);
                frontRight.setPower(speed);
                backLeft.setPower(speed);
                backRight.setPower(speed);

                rotations = frontLeft.getCurrentPosition()/ENCODER_TICKS;
                distanceTraveled = rotations*WHEEL_CIRCUMFERENCE;

        }
    }

    public void turn (int degDifference, boolean direction){                     //True = Right, False = Left

        oldDeg = driveGyro.eulerZ();
        newDeg = oldDeg+degDifference;



    }


}
