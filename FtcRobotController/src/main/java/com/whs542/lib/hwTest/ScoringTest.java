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

        scoringMechanism.flip2(gamepad1.a);

        telemetry.addData("Encoder Ticks", scoringMechanism.scoringMotor.getCurrentPosition());
        telemetry.addData("a", gamepad1.a);
        telemetry.addData("b", gamepad1.b);

    }
}
