package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.ftc2016.subsys.WHSRobot;
import com.whs542.lib.sensors.IMUBNO055;

/**
 * Created by DanielWang on 1/22/16.
 */
public class AutoTestIMU extends OpMode{
<<<<<<< HEAD
    private IMUBNO055 imu;
    public void init()
    {
        imu = new IMUBNO055(hardwareMap, 0, IMUBNO055.BNO055_ADDRESS_A);
    }
    public void loop()
    {
        telemetry.addData("asdf", imu.getHeading());
    }
    public void stop()
    {
    }
}
