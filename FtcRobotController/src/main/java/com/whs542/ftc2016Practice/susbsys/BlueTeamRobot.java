package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.WireLibrary.*;

/**
 * Created by Amar2 on 4/29/2016.
 */
public class BlueTeamRobot {

    public Drivetrain drivetrain;
    public Intake intake;
    public ScoringMechanism scoringMechanism;
    public LinearSlides linearSlides;

    public Bno055 gyro;

    public BlueTeamRobot(HardwareMap mainMap){
        drivetrain = new Drivetrain(mainMap);
        intake = new Intake(mainMap);
        scoringMechanism = new ScoringMechanism(mainMap);
        linearSlides = new LinearSlides(mainMap);
        gyro = new Bno055(mainMap, "gyro");
    }

}
