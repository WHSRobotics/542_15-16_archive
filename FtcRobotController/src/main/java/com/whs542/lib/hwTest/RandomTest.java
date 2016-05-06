package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class RandomTest extends OpMode {

    DcMotor motor1;

    @Override
    public void init()
    {
        motor1 = hardwareMap.dcMotor.get("motor1");

    }
    @Override
    public void loop() {

        if(gamepad1.a == true) {
            motor1.setPower(1.0);
        }
        else{
            motor1.setPower(0.0);
        }

        telemetry.addData("", gamepad1.a); 	//This always gave back false.
    }
}
