package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.*;

/**
 * Created by Amar2 on 5/11/2016.
 */
public class ScoringTest extends OpMode{

    ScoringMechanism scoringMechanism;
    int maxEncoderValue = -100000;

    @Override
    public void init(){
        scoringMechanism = new ScoringMechanism(hardwareMap);

    }

    @Override
    public void loop(){

        // problem ---> scoringMechanism.flip(gamepad1.a);
        telemetry.addData("Encoder Ticks", scoringMechanism.scoringMotor.getCurrentPosition());
        telemetry.addData("a", gamepad1.a);

        if(maxEncoderValue<scoringMechanism.scoringMotor.getCurrentPosition()){
            maxEncoderValue = scoringMechanism.scoringMotor.getCurrentPosition();
        }

        telemetry.addData("Max Enc", maxEncoderValue);

    }
}
