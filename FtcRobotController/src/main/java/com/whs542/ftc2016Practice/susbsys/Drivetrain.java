package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.sensors.EncoderTicks;


/**
 * Created by Amar on 4/28/2016.
 */
public class Drivetrain {
    //Drivetrain is one word. This is important.
    //All measurements in inches, because 'murica

    public static final double WHEEL_DIAMETER = 4;
    public static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER*Math.PI;

    DcMotor lfMotor;
    DcMotor rfMotor;
    DcMotor lbMotor;
    DcMotor rbMotor;

    double rotations;
    double distanceTraveled;

    double startingDistance;

    int startingDeg;
    int targetDeg;

    public Drivetrain (HardwareMap driveMap) {
        lfMotor = driveMap.dcMotor.get("drive_lf");
        lbMotor = driveMap.dcMotor.get("drive_lb");
        rfMotor = driveMap.dcMotor.get("drive_rf");
        rbMotor = driveMap.dcMotor.get("drive_rb");
        lfMotor.setDirection(DcMotor.Direction.REVERSE);
        lbMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setLRDrivePower(double leftPower, double rightPower)
    {
        lfMotor.setPower(leftPower);
        lbMotor.setPower(leftPower);
        rfMotor.setPower(rightPower);
        rbMotor.setPower(rightPower);
    }

    public void setStartingDistance()
    {
        rotations = lfMotor.getCurrentPosition()/ EncoderTicks.FRONT_LEFT;
        startingDistance = rotations*WHEEL_CIRCUMFERENCE;
    }

    public void moveAuto (double distance, double speed){                 //Distance should always be positive

        rotations = lfMotor.getCurrentPosition()/EncoderTicks.FRONT_LEFT;
        distanceTraveled = rotations*WHEEL_CIRCUMFERENCE;

        while (distanceTraveled<distance){

            lfMotor.setPower(speed);
            rfMotor.setPower(speed);
            lbMotor.setPower(speed);
            rbMotor.setPower(speed);

        }
    }

    //Turning:

    public void setStartingDeg (int startingGryoZ){
        startingDeg = startingGryoZ;
    }

    public boolean turn (int degDifference, boolean direction, double speed, int gyroZ)
    {            //True = Right, False = Left
        targetDeg = startingDeg+degDifference;

        if(direction && gyroZ < targetDeg){
            rfMotor.setPower(speed);
            rbMotor.setPower(speed);
        }else if(!direction && gyroZ > targetDeg){
            lfMotor.setPower(-speed);
            lbMotor.setPower(-speed);
        }else{
            return true;
        }
        return false;

    }

    public double getCurrentPower()
    {
        return lfMotor.getPower();
    }

    public double[] getAllCurrentPower(){
        double[] returnPower = new double[4];
        returnPower[0] = lfMotor.getCurrentPosition();
        returnPower[1] = lbMotor.getCurrentPosition();
        returnPower[2] = rfMotor.getCurrentPosition();
        returnPower[3] = rbMotor.getCurrentPosition();
        return returnPower;
    }
}

