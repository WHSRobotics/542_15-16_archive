package com.whs542.ftc2016;

//	TEST Opmode
//	 Throw your test code in here
//

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.*;
import com.whs542.ftc2016.threads.DriveThread;
import com.whs542.lib.Alliance;

public class DebugOp extends OpMode
{
    //public Thread driveThread;
    ScoringBox box;
    LinearSlides slid;

    public void init()
    {
        //slid = new LinearSlides(hardwareMap);
        box = new ScoringBox(hardwareMap, Alliance.RED);
        //driveThread = new Thread(new DriveThread(robot));
    }

    public void start()
    {
        //driveThread.start();
    }

	public void loop()
	{
        //slid.setTransmissionPower(9.0/7.0, gamepad1.dpad_up, gamepad1.dpad_down);
        //box.setDoorPosition(gamepad1.left_stick_y);
        box.setExtension(gamepad1.b);
        //box.setExtensionSpeed(gamepad1.dpad_left, gamepad1.dpad_right);
        box.setDoor(gamepad1.a);
        telemetry.addData("servo pos", gamepad1.left_stick_y);
        telemetry.addData("Magnet", box.getExtensionValue());
	}

    public void stop()
    {
        //driveThread.interrupt();
    }
}