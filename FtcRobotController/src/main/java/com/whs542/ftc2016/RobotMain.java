package com.whs542.ftc2016;

import com.whs542.lib.sensors.*;
import com.whs542.ftc2016.subsys.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//
// Main Robot Control Class
//

public class RobotMain extends OpMode
{
	Drive drive;
	Intake intake;
	LinearSlides linearSlides;
	ScoringBox scoringBox;
	ProximityGP2Y0D810Z0F proximitySensor;
	CurrentACS711EX currentSensorDirect;
	CurrentACS711EX currentSensorProximal;

	DcMotor testMot;

	public void init()
	{
		//
		// !WARNING!
		//
		// Don't have stuff commented here but not uncommented in the loop
		// Null pointer exception will be thrown at runtime due to no hardware object reference

		//drive = new Drive(hardwareMap);
		//intake = new Intake(hardwareMap);
		linearSlides = new LinearSlides(hardwareMap);
		//scoringBox = new ScoringBox(hardwareMap);
		//proximitySensor = new ProximityGP2Y0D810Z0F(hardwareMap, 0);
		//currentSensorDirect = new CurrentACS711EX(hardwareMap, 0);
		//currentSensorProximal = new CurrentACS711EX(hardwareMap, 4);
		//testMot = hardwareMap.dcMotor.get("testMot");
	}

	boolean trigger = false;
	boolean fast = true;

	public void loop()
	{
		linearSlides.setExtensionPower(gamepad1.left_stick_y);
		if(gamepad1.a)
		{
			if(!trigger)
			{
				fast = !fast;
			}
			trigger = true;
		}
		else
		{
			trigger = false;
		}

		if(fast)
		{
			linearSlides.shiftToSpeed();
		}
		else
		{
			linearSlides.shiftToTorque();
		}

		//drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
		//telemetry.addData("LENC", drive.getLeftBackEncoder() + " " + drive.getLeftFrontEncoder());
		//telemetry.addData("RENC", drive.getRightBackEncoder() + " " + drive.getRightFrontEncoder());
		//telemetry.addData("Proximity", "Within Distance: " + proximitySensor.isInDistance());
		//testMot.setPower(gamepad1.left_stick_y);
		//telemetry.addData("dir", currentSensorDirect.getValue());
		//telemetry.addData("prox", currentSensorProximal.getValue());
	}
}