package com.whs542.ftc2016;

import com.whs542.lib.Toggler;

/**
 * Created by DanielWang on 12/5/15.
 */

public class TeleOp extends RobotMain {

    //Toggler boxScore = new Toggler(2);
    //Toggler slideExtender = new Toggler(4);

    //boolean boxFull = false;
    //boolean boxRetracted = false;

    public void loop()
    {
        //scoringBox.boxFlapState(gamepad1);
        //scoringBox.innerBoxExtension(gamepad1);
        //linearSlides.setTransmissionPower(100.0, gamepad1);
        drive.setLeftRightPower(gamepad1.left_stick_y * 7.0/9.0, gamepad1.right_stick_y * 7.0/9.0);
    }
}
