package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by DanielWang on 1/4/16.
 */
public class Angler {

    private DcMotor anglingMotor;

    public Angler(HardwareMap angleMap)
    {
        anglingMotor = angleMap.dcMotor.get("agl_mot");
    }
    public void angleDrive(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(gamepad.dpad_up)
        {
            anglingMotor.setPower(1.0);
        }
        else if(gamepad.dpad_down)
        {
            anglingMotor.setPower(-1.0);
        }
        else
        {
            anglingMotor.setPower(0.0);
        }
    }
}
