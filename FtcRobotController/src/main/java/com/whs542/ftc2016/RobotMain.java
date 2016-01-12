package com.whs542.ftc2016;

import com.whs542.lib.sensors.*;
import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;
import com.whs542.ftc2016.threads.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class RobotMain extends OpMode
{
	Drive drive;
    Intake intake;
	LinearSlides linearSlides;
	ScoringBox scoringBox;

	SpeedControl control;

    Thread driveControl;

	public void init()
	{
		//
		// !WARNING!
		//
		// Don't have stuff commented here but not uncommented in the loop
		// Null pointer exception will be thrown at runtime due to no hardware object reference

		drive = new Drive(hardwareMap, Alliance.RED);
		//intake = new Intake(hardwareMap);
		//linearSlides = new LinearSlides(hardwareMap);
		scoringBox = new ScoringBox(hardwareMap, Alliance.RED);
    }
}