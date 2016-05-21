package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Amar on 4/27/2016.
 */
public class Intake {
    public DcMotor intake;
    boolean motorStateF = false;
    boolean motorStateR = false;

    public Intake (HardwareMap inMap){

        intake = inMap.dcMotor.get("intake");

    }

    public void intake(boolean on, boolean reverse){

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

    public void useIntake2(boolean button1State, boolean button2State){
        if(button1State && intake.getPower() == 0.0){
            intake.setPower(1.0);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (button1State && intake.getPower() == 1.0){
            intake.setPower(0.0);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(button2State && intake.getPower() == 0.0){
            intake.setPower(-1.0);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (button2State && intake.getPower() == -1.0) {
            intake.setPower(0.0);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (button1State && intake.getPower() == 1.0){

        }

    }

}
