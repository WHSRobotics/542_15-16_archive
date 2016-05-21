package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.lib.WireLibrary.*;

/**
 * Created by Amar on 5/5/2016.
 */

//A test for the Wire class and the Bno055 class, along with telemetry

public class GyroTest extends OpMode {

    Bno055 testGyro;

    @Override
    public void init(){
        testGyro = new Bno055(hardwareMap, "gyro");
    }

    public void loop(){
        telemetry.addData("X", testGyro.eulerX());
        telemetry.addData("Y", testGyro.eulerY());
        telemetry.addData("Z", testGyro.eulerZ());
    }
}
