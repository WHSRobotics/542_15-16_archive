package com.whs542.lib.hwTest;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.ftc2016Practice.susbsys.LinearSlides;

/**
 * Created by jian on 5/21/2016.
 */
public class LinearSlidesTest extends OpMode{
    LinearSlides linearSlides;

    @Override
    public void init(){
        linearSlides = new LinearSlides(hardwareMap);
    }

    @Override
    public void loop(){
        linearSlides.extendSlides(gamepad1.left_trigger,gamepad1.left_bumper);
    }

}
