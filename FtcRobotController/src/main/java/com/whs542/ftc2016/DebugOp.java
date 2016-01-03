package com.whs542.ftc2016;

//	TEST Opmode
//	 Throw your test code in here
//

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.WHSRobot;
import com.whs542.ftc2016.threads.DriveThread;

public class DebugOp extends OpMode
{
    public WHSRobot robot;
    public Thread driveThread;

    public void init()
    {
        robot = new WHSRobot(hardwareMap);
        driveThread = new Thread(new DriveThread(robot));
    }

    public void start()
    {
        driveThread.start();
    }

	public void loop()
	{
		//Drive testing
        robot.drive.updateEncoderValues();
        robot.drive.setLeftRightPower(gamepad1.left_stick_y * 7.0 / 9.0, gamepad1.right_stick_y * 7.0 / 9.0);

		//Encoder testing

		//Proximity Sensor testing
		//telemetry.addData("Proximity", "Within Distance: " + proximitySensor.isInDistance());
	}

    public void stop()
    {
        driveThread.interrupt();
    }
}