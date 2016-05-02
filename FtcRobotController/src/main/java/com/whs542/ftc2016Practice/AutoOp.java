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




        }
    }
}
