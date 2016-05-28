package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Amar on 4/27/2016.
 */
public class Intake {
    public DcMotor intake;

    public Intake(HardwareMap inMap) {

        intake = inMap.dcMotor.get("intake");

    }

    public void intake(float trigger, boolean reverse) {
        boolean on;
        if (trigger == 0.0) {
            on = false;
        } else {
            on = true;

            while (on) {
                intake.setPower(0.5);
            }
            while (reverse) {
                intake.setPower(-0.5);
            }
            intake.setPower(0.0);
        }
    }

    /*public void intake2(double forward, boolean reverse)
    {
        boolean pressed = (Math.abs(forward) > 0.0);

        intake(pressed,reverse);
    }*/

    public void useIntake2(float button1, boolean button2State){
        boolean button1State;
        if (button1 == 0.0){
            button1State = false;
        }
        else {
            button1State = true;
        }
        if(button1State && intake.getPower() == 0.0){
            intake.setPower(1.0);
            try {
                Thread.sleep(200);                                           //Tries to sleep (pause) for 200ms, to give driver time to release button
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
        else if (button1State && intake.getPower() == -1.0){
            intake.setPower(1.0);
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
        else if (button2State && intake.getPower() == 1.0){
            intake.setPower(-1.0);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
