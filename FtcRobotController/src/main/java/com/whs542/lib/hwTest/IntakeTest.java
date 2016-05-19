package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.Intake;

/**
 * Created by Amar on 5/18/2016.
 */
public class IntakeTest extends OpMode{

    Intake intake;


    @Override
    public void init() {
        intake = new Intake(hardwareMap);                       //DcMotor "intake"
    }

    @Override
    public void loop() {
        intake.useIntake2(gamepad1.a, gamepad1.b);
        telemetry.addData("Motor Power", intake.intake.getPower());
        Thread.sleep();
    }
}
