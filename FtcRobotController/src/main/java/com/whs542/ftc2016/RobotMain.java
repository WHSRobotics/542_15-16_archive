package com.whs542.ftc2016;

import com.whs542.lib.sensors.*;
import com.whs542.ftc2016.subsys.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class RobotMain extends OpMode{
	Drive drive;
	AutoOp autonomous;
	//Intake intake;
	//LinearSlides linearSlides;
	//ScoringBox scoringBox;
	//ProximityGP2Y0D810Z0F proximitySensor;
	//CurrentACS711EX currentSensorDirect;
	//CurrentACS711EX currentSensorProximal;

	DcMotor testMot;
	String asdf1234;

	public void init()
	{
		/* WARNING
		Don't have stuff commented here but not uncommented in the loop
		Null pointer exception will be thrown at runtime due to no hardware object reference
		 */

		drive = new Drive(hardwareMap);
		autonomous = new AutoOp(drive);
		//intake = new Intake(hardwareMap);
		//linearSlides = new LinearSlides(hardwareMap);
		//scoringBox = new ScoringBox(hardwareMap);
		//proximitySensor = new ProximityGP2Y0D810Z0F(hardwareMap, 0);
		//currentSensorDirect = new CurrentACS711EX(hardwareMap, 0);
		//currentSensorProximal = new CurrentACS711EX(hardwareMap, 4);
		//testMot = hardwareMap.dcMotor.get("testMot");
	}
	/*
	public void loop()
	{
		//linearSlides.setTransmissionPower(gamepad1.left_stick_y);
		//linearSlides.setShiftServoPosition(gamepad1.right_stick_y);
		//drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
		//telemetry.addData("LENC", drive.getLeftBackEncoder() + " " + drive.getLeftFrontEncoder());
		//telemetry.addData("RENC", drive.getRightBackEncoder() + " " + drive.getRightFrontEncoder());
		//telemetry.addData("Proximity", "Within Distance: " + proximitySensor.isInDistance());
		//testMot.setPower(gamepad1.left_stick_y);
		//telemetry.addData("dir", currentSensorDirect.getValue());
		//telemetry.addData("prox", currentSensorProximal.getValue());
	}
	*/
	public void stop()
	{

	}

}