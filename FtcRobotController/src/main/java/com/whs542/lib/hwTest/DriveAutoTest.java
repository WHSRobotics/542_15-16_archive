package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.whs542.ftc2016Practice.susbsys.Drivetrain;

/**
 * Created by Amar2 on 5/28/2016.
 */
public class DriveAutoTest extends OpMode {

    Drivetrain drivetrain;



    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap);
    }

    @Override
    public void loop() {
        drivetrain.moveAuto2(10, 1.0);
        telemetry.addData("", drivetrain.lfMotor.getCurrentPosition());
    }
}
