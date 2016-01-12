package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.Alliance;

public class WHSRobot
{
    public Drive drive;
    public Intake intake;
    public LinearSlides slides;
    public ScoringBox box;

    public WHSRobot(HardwareMap map, Alliance side)
    {
        drive = new Drive(map, side);
        intake = new Intake(map);
        slides = new LinearSlides(map);
        box = new ScoringBox(map, side);
    }
}