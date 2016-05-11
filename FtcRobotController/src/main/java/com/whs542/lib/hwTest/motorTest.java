package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by jian on 5/9/2016.
 */
public class motorTest extends OpMode{
    DcMotor motor;

    @Override
    public void init(){
        motor = hardwareMap.dcMotor.get("motor");
    }

    @Override
    public void loop(){
        motor.setTargetPosition(300);
        motor.setPower(0.5);

        telemetry.addData("test", motor.getCurrentPosition());
    }
}
