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
    public void loop()  //Robot starts at top left corner of floor mat next to loading zone
    {
        switch (i)
        {
            case(1):
                robot.drivetrain.moveAuto(63.5,1.0); //robot center lines with center of target crate
                i=2;
            case(2):
                robot.drivetrain.setStartingDeg(robot.gyro.eulerZ()); //turns toward crate
            case(3):
                if(!robot.drivetrain.turn(90,false,0.5,robot.gyro.eulerZ())){
                }
                else{
                    i=4;
                }
            case(4):
                robot.drivetrain.moveAuto(30, 1.0);    //robot drives up to crate
                i=5;
            case(5):
                robot.drivetrain.moveAutoDecrease(41,1.0);   //robot pushes crate, slowly decreasing speed, until parking in opponent's zone
                i=6;
            case(6):
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                robot.scoringMechanism.flipForwards();   //robot drops the 2 waffles
        }
    }

}
