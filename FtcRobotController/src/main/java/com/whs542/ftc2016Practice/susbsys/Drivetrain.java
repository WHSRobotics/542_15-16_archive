package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.sensors.EncoderTicks;

import com.whs542.lib.Toggler;

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

    Toggler orientation = new Toggler(2);

    double rotations;
    double distanceTraveled;

    double startingDistance;

    int startingDeg;
    int targetDeg;

    double power;

    static final double CIRCUMFERENCE_ROBOT_TURN = 14.5* Math.PI;
    static final double CIRCUMFERENCE_WHEEL = 4*Math.PI;
    static final double ENCODER_TICKS_PER_DEGREE = CIRCUMFERENCE_ROBOT_TURN*1120/(CIRCUMFERENCE_WHEEL*360);

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
        switch(orientation.currentState()) {
            case 0:
                lfMotor.setPower(leftPower);
                lbMotor.setPower(leftPower);
                rfMotor.setPower(rightPower);
                rbMotor.setPower(rightPower);
                break;
            case 1:
                lfMotor.setPower(-leftPower);
                lbMotor.setPower(-leftPower);
                rfMotor.setPower(-rightPower);
                rbMotor.setPower(-rightPower);
                break;
        }
    }

    public void changeOrientation(boolean switchOrientation)
    {
        orientation.changeState(switchOrientation);
    }

    public String getOrientation()
    {
        String o = "";
        int state = orientation.currentState();
        if(state == 0)
        {
            o = "Forward";
        }
        else if(state == 1)
        {
            o = "Reverse";
        }

        return o;
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
            lfMotor.setPower(power);
            rfMotor.setPower(power);
            lbMotor.setPower(power);
            rbMotor.setPower(power);

        }
    }

    public void moveAutoDecrease (double distance, double speed){                 //Distance should always be positive

        rotations = lfMotor.getCurrentPosition()/EncoderTicks.FRONT_LEFT;
        distanceTraveled = rotations*WHEEL_CIRCUMFERENCE;


        while (distanceTraveled<distance){
            power = 1-0.8*(distanceTraveled/(distance));
            lfMotor.setPower(power);
            rfMotor.setPower(power);
            lbMotor.setPower(power);
            rbMotor.setPower(power);

        }
    }

    //Turning:

    public void setStartingDeg (int startingGyroZ){
        startingDeg = startingGyroZ;
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
    //this is a two wheel turn
    public void turnAuto(double degree, boolean direction, double powerTurn){ //direction: true=right, false=left
        double x = degree*ENCODER_TICKS_PER_DEGREE/2;
        if (lfMotor.getCurrentPosition()<x && direction){
            setLRDrivePower(powerTurn,-powerTurn);
           /*lfMotor.setPower(powerTurn);
           lbMotor.setPower(powerTurn);
           rfMotor.setPower(-powerTurn);
           rbMotor.setPower(-powerTurn);*/
        }
        else if(rfMotor.getCurrentPosition()<x && !direction){
            setLRDrivePower(-powerTurn,powerTurn);
           /*
           lfMotor.setPower(-powerTurn);
           lbMotor.setPower(-powerTurn);
           rfMotor.setPower(powerTurn);
           rbMotor.setPower(powerTurn);*/
        }
        else{
            setLRDrivePower(0.0,0.0);
        }


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
