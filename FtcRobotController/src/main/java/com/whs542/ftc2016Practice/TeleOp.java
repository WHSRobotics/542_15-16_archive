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
        //Drivetrain
        robot.drivetrain.setLRDrivePower(gamepad1.left_stick_y, gamepad1.right_stick_y);
        robot.drivetrain.changeOrientation(gamepad1.a);

        telemetry.addData("Orientation", robot.drivetrain.getOrientation());
        telemetry.addData("Left Power", gamepad1.left_stick_y);
        telemetry.addData("Right Power", gamepad1.right_stick_y);

        //Intake
        robot.intake.intake(gamepad1.right_trigger, gamepad1.right_bumper);

        //Linear Slides
        robot.linearSlides.extendSlides(gamepad1.left_trigger, gamepad1.left_bumper);

        //Scoring Mechanism
        robot.scoringMechanism.flip(gamepad1.dpad_up, gamepad1.dpad_down);

    }
}
