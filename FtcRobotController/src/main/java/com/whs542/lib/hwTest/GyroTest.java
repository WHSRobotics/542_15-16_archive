package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.lib.WireLibrary.*;
import com.whs542.lib.sensors.IMUBNO055;

/**
 * Created by Amar on 5/5/2016.
 */

//A test for the Wire class and the Bno055 class, along with telemetry

public class GyroTest extends OpMode {

    IMUBNO055 testGyro;

    @Override
    public void init(){
        testGyro = new IMUBNO055(0, IMUBNO055.BNO055_ADDRESS_A);
    }

    public void loop(){
        telemetry.addData("", IMUBNO055.getVector());
    }
}
