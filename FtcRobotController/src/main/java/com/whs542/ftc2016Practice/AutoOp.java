package com.whs542.ftc2016Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.BlueTeamRobot;


public class AutoOp extends OpMode{

    BlueTeamRobot robot;
    int i = 1;

    @Override
    public void init(){
        robot = new BlueTeamRobot(hardwareMap);
    }

    /*
    Example:
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
    **/

    @Override
    public void loop(){
        switch (i){
            case(1):
                robot.drivetrain.moveAuto(63.5,1.0);
                i=2;
            case(2):
                robot.drivetrain.turn(90,false,0.5,);
                i=3;
            case(3):
                robot.drivetrain.moveAuto(63.5,1.0);
                i=4;
            case(4):
                while (robot.drivetrain.)
                robot.drivetrain.moveAuto(10,0.5);
                robot.scoringMechanism.scoringAuto();

        }
    }

}
