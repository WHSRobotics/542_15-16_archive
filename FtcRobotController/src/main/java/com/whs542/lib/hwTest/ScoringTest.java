package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.*;

/**
 * Created by Amar2 on 5/11/2016.
 */
public class ScoringTest extends OpMode{

    ScoringMechanism scoringMechanism;

    @Override
    public void init(){
        scoringMechanism = new ScoringMechanism(hardwareMap);
    }

    @Override
    public void loop(){

        scoringMechanism.useScoring(gamepad1.a, gamepad1.b);
        telemetry.addData("Encoder Ticks", scoringMechanism.scoringMotor.getCurrentPosition());

    }
}
