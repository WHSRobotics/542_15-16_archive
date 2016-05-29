package com.whs542.ftc2016Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.BlueTeamRobot;

/**
 * Created by Amar2 on 5/28/2016.
 */
public class AutoOp2 extends OpMode{

    BlueTeamRobot robot;
    int i = 1;

    @Override
    public void init() {
        robot = new BlueTeamRobot(hardwareMap);
    }

    @Override
    public void loop() {
        switch (i){
            case (1):
                if (robot.drivetrain.moveAuto2(20,1.0)){
                    i=2;
                }else {
                    telemetry.addData("", robot.drivetrain.distanceTraveled);
                }
            case (2):
                if(robot.drivetrain.turnAuto(90, false, 0.7)){
                    i=3;
                }
            case (3):
                if(robot.drivetrain.moveAuto2(72,1.0)){
                    break;
                }
        }

    }
}
