package com.whs542.ftc2016;

import com.whs542.lib.Toggler;

/**
 * Created by DanielWang on 12/5/15.
 */

public class TeleOp extends RobotMain {

    //Toggler boxScore = new Toggler(2);
    //Toggler slideExtender = new Toggler(4);

    boolean boxFull = false;
    //boolean boxRetracted = false;

    public boolean proxState0 = false;
    public boolean proxState1 = false;
    public boolean proxState2 = false;
    public boolean proxState3 = false;

    private int shiftState;
    private int lockState;

    public void loop()
    {
        /*
        //---------Box Flap
        if(gamepad1.a)
        {
            //Open
            scoringBox.boxFlapState(0.15);
            //scoringBox.boxFlapState(gamepad1, 0.15, 0.4);
        }
        else if(gamepad1.b)
        {
            //Closed
            scoringBox.boxFlapState(0.4);
        }
        //---------Inner Box Extension
        if(gamepad1.x)
        {
            scoringBox.innerBoxExtension(1.0);
        }
        else if(gamepad1.y)
        {
            scoringBox.innerBoxExtension(0.0);
        }
        else
        {
            scoringBox.innerBoxExtension(0.5);
        }
        */
        //intake.setIntakePosition(gamepad2);
        //-----------Linear Slides
        if(gamepad1.right_bumper)
        {
            linearSlides.setTransmissionPower(1.0);
        }
        else if(gamepad1.right_trigger == 1.0)
        {
            linearSlides.setTransmissionPower(-1.0);
        }
        else
        {
            linearSlides.setTransmissionPower(0.0);
        }
        //linearSlides.shiftTransmissionServo(gamepad2); //shiftState
        //-----------Shift Transmission
        if(gamepad2.a)
        {
            linearSlides.shiftTransmissionServo(0.0);
        }
        else if(gamepad2.b)
        {
            linearSlides.shiftTransmissionServo(0.5);
        }
        //-----------Lock Servo
        if(gamepad2.x)
        {
            lockState = 1;
            linearSlides.lockTransmissionServo(0.95);
        }
        else if(gamepad2.y)
        {
            lockState = 2;
            linearSlides.lockTransmissionServo(0.65);
        }
        /*
        if(intakeState0 && intakeState1 && intakeState2)
        {
            boxFull = true;
            //intake.setIntakePower(0.0);
        }
        else
        {
            for(int i = 0; i < 4; i++)
            {
                if(i == 0)
                {
                    if(scoringBox.proximity0.isInDistance())
                    {
                        proxState0 = true;
                    }
                    else
                    {
                        proxState0 = false;
                        boxFull = false;
                    }
                }
                else if(i == 1)
                {
                    if(scoringBox.proximity1.isInDistance())
                    {
                        proxState1 = true;
                    }
                    else
                    {
                        proxState1 = false;
                        boxFull = false;
                    }
                }
                else if(i == 2)
                {
                    if(scoringBox.proximity2.isInDistance())
                    {
                        proxState2 = true;
                    }
                    else
                    {
                        proxState2 = false;
                        boxFull = false;
                    }
                }
                /*
                else if(i == 3)
                {
                    if(scoringBox.proximity3.isInDistance())
                    {
                        proxState3 = true;
                    }
                    else
                    {
                        proxState3 = false;
                        boxFull = false;
                    }
                }

            }
        }
        */
        drive.setLeftRightPower(gamepad1.left_stick_y * 7.0/9.0, gamepad1.right_stick_y * 7.0/9.0);
        //----------Hook
        //hookLPosition = 0.85
        //hookRPosition = 0.15
        if(gamepad2.dpad_up)
        {
            //drive.hook(hookLPosition, hookRPosition)
            drive.hook(0.85, 0.15);
        }
        //hookLPosition = 0.35
        //hookRPosition = 0.55
        else if(gamepad2.dpad_down)
        {
            drive.hook(0.35, 0.55);
        }
        //-----------Side Climbers
        //sideLPosition = 0.
        //sideRPosition =
        if(gamepad2.dpad_left)
        {
            drive.sideClimbers(gamepad2);
        }
        else if(gamepad2.dpad_right)
        {
            drive.sideClimbers(gamepad2);
        }
        //angling.angleDrive(gamepad1);
        //telemetry.addData("Proximity 0", intakeState0);
        //telemetry.addData("Left Hook", drive.hookLPosition);
        //telemetry.addData("Right Hook", drive.hookRPosition);
        //telemetry.addData("Left Side Climber", drive.sideLPosition);
        //telemetry.addData("Right Side Climber", drive.sideRPosition);
        //telemetry.addData("shift servo", linearSlides.shiftServoPosition);
        //telemetry.addData("door servo", scoringBox.servoDoorValue);
        //telemetry.addData("extension servo", scoringBox.servoExtensionValue);
    }
}
