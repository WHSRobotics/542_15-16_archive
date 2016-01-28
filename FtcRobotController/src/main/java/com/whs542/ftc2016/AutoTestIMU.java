package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.WHSRobot;
import com.whs542.lib.sensors.IMUBNO055;

/**
 * Created by DanielWang on 1/22/16.
 */
public class AutoTestIMU extends OpMode{
    public void init()
    {
        IMUBNO055 imu = new IMUBNO055(0, IMUBNO055.BNO055_ADDRESS_A);
    }
    public void loop()
    {
        telemetry.addData("asdf", IMUBNO055.getVector());
    }
    public void stop()
    {
    }
}
