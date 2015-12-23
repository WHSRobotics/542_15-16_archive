package com.whs542.ftc2016;

//	TEST Opmode
//	 Throw your test code in here
//

public class DebugOp extends RobotMain
{
	public void loop()
	{
		//Drive testing
		//drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);

		//Encoder testing
		//telemetry.addData("LENC", drive.getLeftBackEncoder() + " " + drive.getLeftFrontEncoder());
		//telemetry.addData("RENC", drive.getRightBackEncoder() + " " + drive.getRightFrontEncoder());

		//Proximity Sensor testing
		//telemetry.addData("Proximity", "Within Distance: " + proximitySensor.isInDistance());
	}
}