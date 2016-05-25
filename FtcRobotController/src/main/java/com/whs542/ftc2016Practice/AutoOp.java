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

    ////////////////////////////
    //---READ THIS JOYCE!!!---//
    ////////////////////////////

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
    public void loop()
    {
        switch (i)
        {
            case(1):
                robot.drivetrain.moveAuto(63.5,1.0);
                i=2;
            case(2):
                robot.drivetrain.setStartingDeg(robot.gyro.eulerZ());
            case(3):
                if(!robot.drivetrain.turn(90,false,0.5,robot.gyro.eulerZ())){
                }
                else{
                    i=4;
                }
            case(4):
                robot.drivetrain.moveAuto(48,1.0);
                i=5;
            case(5):
                robot.drivetrain.moveAuto(48,0.5);
                robot.scoringMechanism.flipForwards();

        }
    }

}
