package com.whs542.lib.hwTest;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016Practice.susbsys.Drivetrain;
/**
 * Created by Jiangda on 5/28/2016.
 */
public class turnAutoTest extends OpMode{
    Drivetrain drivetrain;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap);
    }


    @Override
    public void loop() {
        drivetrain.turnAuto(90.0,true,0.6);
    }
}
