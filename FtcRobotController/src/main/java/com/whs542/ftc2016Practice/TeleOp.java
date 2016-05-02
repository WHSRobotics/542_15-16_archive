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

        robot.drivetrain.move(gamepad1.left_stick_y, gamepad1.right_stick_y);
        robot.intake.useIntake(gamepad1.right_bumper, gamepad1.left_bumper);



    }
}
