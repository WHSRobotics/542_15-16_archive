package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.Wire.*;

/**
 * Created by Amar2 on 4/29/2016.
 */
public class BlueTeamRobot {

    Drivetrain drivetrain;
    Intake intake;
    ScoringMechanism scoringMechanism;

    Bno055 gyro;

    public BlueTeamRobot(HardwareMap mainMap){
        drivetrain = new Drivetrain(mainMap);
        intake = new Intake(mainMap);
        scoringMechanism = new ScoringMechanism(mainMap);
        gyro = new Bno055(mainMap, "gyro");
    }

}
