package com.whs542.ftc2016Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.BlueTeamRobot;

/**
 * Created by Amar2 on 4/30/2016.
 */
public class TeleOp extends OpMode{

    BlueTeamRobot robot;

    @Override
    public void init(){

        robot = new BlueTeamRobot(hardwareMap);
    }

    @Override
    public void loop(){
        //Drive train
        robot.drivetrain.setLRDrivePower(gamepad1.left_stick_y, gamepad1.right_stick_y);

        //Intake
        robot.intake.intake(gamepad1.right_trigger, gamepad1.left_bumper);

        //Linear Slides
        //robot.linearSlides.extendSlides(gamepad1.dpad_up, gamepad1.dpad_down);

        //Scoring Mechanism
        robot.scoringMechanism.flip(gamepad1.a, gamepad1.b);
    }
}
