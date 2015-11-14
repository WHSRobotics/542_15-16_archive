package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.lib.sensors.*;
import com.whs542.ftc2016.subsys.*;

public class RobotMain extends OpMode
{
	Drive drive;
	Intake intake;
	LinearSlides linearSlides;
	ScoringBox scoringBox;
	ProximityGP2Y0D810Z0F proximitySensor;
	//ScoringBox scoringBox = new ScoringBox()
	//CurrentACS711EX currentSensor = new CurrentACS711EX();

	public void init()
	{
		drive = new Drive(hardwareMap);
		//intake = new Intake(hardwareMap);
		//linearSlides = new LinearSlides(hardwareMap);
		scoringBox = new ScoringBox();
		proximitySensor = new ProximityGP2Y0D810Z0F(hardwareMap, 0);
	}

	public void loop()
	{
		drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
		telemetry.addData("LENC", drive.getLeftBackEncoder() + " " + drive.getLeftFrontEncoder());
		telemetry.addData("RENC", drive.getRightBackEncoder() + " " + drive.getRightFrontEncoder());
		telemetry.addData("Proximity", "Within Distance: " + proximitySensor.isInDistance());
	}
}