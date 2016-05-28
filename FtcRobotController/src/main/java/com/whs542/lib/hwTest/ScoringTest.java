package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.*;

/**
 * Created by Amar2 on 5/11/2016.
 */
public class ScoringTest extends OpMode{

    ScoringMechanism scoringMechanism;
    Intake intake;
    int maxEncoderValue = -100000;

    @Override
    public void init(){
        scoringMechanism = new ScoringMechanism(hardwareMap);
        intake = new Intake(hardwareMap);

    }

    @Override
    public void loop(){

        scoringMechanism.flip(gamepad1.dpad_up, gamepad1.dpad_down);
        telemetry.addData("Encoder Ticks", scoringMechanism.scoringMotor.getCurrentPosition());
        telemetry.addData("a", gamepad1.a);

        intake.intake(gamepad1.right_trigger, gamepad1.right_bumper);
        telemetry.addData("right trigger", gamepad1.right_trigger);
        telemetry.addData("right trigger", gamepad1.right_bumper);
        telemetry.addData("Motor Power", intake.intake.getPower());

        if(maxEncoderValue<scoringMechanism.scoringMotor.getCurrentPosition()){
            maxEncoderValue = scoringMechanism.scoringMotor.getCurrentPosition();
        }

        telemetry.addData("Max Enc", maxEncoderValue);

    }
}
