package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

//Joyce was here
/**
 * Created by Amar on 4/27/2016.
 */
public class Intake {
    DcMotor intake;

    public Intake (HardwareMap inMap){

        intake = inMap.dcMotor.get("intake");

    }

    public void useIntake(boolean on, boolean reverse){

        if(on){
            intake.setPower(1.0);
        }
        else if (reverse){
            intake.setPower(-1.0);
        }
        else{
            intake.setPower(0.0);
        }

    }
}
