package com.whs542.ftc2016Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.BlueTeamRobot;

/**
 * Created by Amar2 on 5/1/2016.
 */
public class AutoOp extends OpMode{

    BlueTeamRobot robot;
    int i = 1;

    @Override
    public void init(){
        robot = new BlueTeamRobot(hardwareMap);
    }

    @Override
    public void loop(){
        switch (i){
            case(1):
                robot.drivetrain.moveAuto(10,1.0);
                i = 2;
            case(2):
                robot.drivetrain.setStartingDeg(robot.gyro.eulerZ());
                while(!robot.drivetrain.turn(90, true, 0.75, robot.gyro.eulerZ())){

                }
                i = 3;
        }
    }
}
