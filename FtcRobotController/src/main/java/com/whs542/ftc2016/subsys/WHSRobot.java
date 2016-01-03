package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class WHSRobot
{
    public Drive drive;
    public Intake intake;
    public LinearSlides slides;
    public ScoringBox box;

    public WHSRobot(HardwareMap map)
    {
        drive = new Drive(map);
        intake = new Intake(map);
        slides = new LinearSlides(map);
        box = new ScoringBox(map);
    }
}