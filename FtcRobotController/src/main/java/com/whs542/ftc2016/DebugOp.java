package com.whs542.ftc2016;

//	TEST Opmode
//	 Throw your test code in here
//

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.*;
import com.whs542.ftc2016.threads.DriveThread;

public class DebugOp extends OpMode
{
    //public WHSRobot robot;
    //public Thread driveThread;
    ScoringBox box;

    public void init()
    {
        box = new ScoringBox(hardwareMap);
        //robot = new WHSRobot(hardwareMap);
        //driveThread = new Thread(new DriveThread(robot));
    }

    public void start()
    {
        //driveThread.start();
    }

	public void loop()
	{
		//Drive testing
        //robot.drive.updateEncoderValues();
        //robot.drive.setLeftRightPower(gamepad1.left_stick_y * 7.0 / 9.0, gamepad1.right_stick_y * 7.0 / 9.0);

		//Encoder testing

		//Proximity Sensor testing
		//telemetry.addData("Proximity", "Within Distance: " + proximitySensor.isInDistance());

        box.setExtension(gamepad1.b);
        //box.setExtensionSpeed(gamepad1.dpad_left, gamepad1.dpad_right);
        box.setDoor(gamepad1.a);
        telemetry.addData("Magnet", box.getExtensionValue());
	}

    public void stop()
    {
        //driveThread.interrupt();
    }
}