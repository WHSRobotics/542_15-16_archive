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
        robot.intake.useIntake(gamepad1.right_bumper, gamepad1.left_bumper);

        //Linear Slides
        robot.linearSlides.extendSlides(gamepad1.a, gamepad1.b);

        //Scoring Mechanism
        robot.scoringMechanism.useScoring(gamepad1.x, gamepad1.y);

    }
}
