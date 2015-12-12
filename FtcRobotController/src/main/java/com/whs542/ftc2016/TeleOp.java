package com.whs542.ftc2016;

/**
 * Created by DanielWang on 12/5/15.
 */
public class TeleOp extends RobotMain {

    public void loop()
    {
        com.whs542.ftc2016.subsys.Drive.setLeftRightPower(1.0, 1.0);
    }
}
