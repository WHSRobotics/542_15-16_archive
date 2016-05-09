package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by jian on 5/9/2016.
 */
public class motorTest{
    DcMotor motor;
    public void init(HardwareMap hardwaremap){
        motor = hardwaremap.dcMotor.get("motor");
    }
    public int loop(){
        motor.setTargetPosition(300);
        return motor.getCurrentPosition();

    }
}
