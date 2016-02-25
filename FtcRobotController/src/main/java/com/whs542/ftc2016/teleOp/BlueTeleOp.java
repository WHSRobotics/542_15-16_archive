package com.whs542.ftc2016.teleOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.whs542.lib.sensors.imu.*;

import org.FTC5866.lib.Bno055;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by DanielWang on 12/5/15.
 */

public class BlueTeleOp extends OpMode
{
    Bno055 imu;
    Quaternion imuData = new Quaternion();
    Vector imuEuler = new Vector(3);

    boolean initComplete = false;        // Flag to stop initialization

    Bno055.ScheduleItem sensorData,fusionData,  // Data read schedules
            tempData,calibData;

    WHSRobot bot;

    public void updateQuaternion(Quaternion q, double w, double x, double y, double z)
    {
        q.setW(w);
        q.setX(x);
        q.setY(y);
        q.setZ(z);
    }

    public void printVector(Vector v)
    {
        telemetry.addData("Euler X", v.x());
        telemetry.addData("Euler Y", v.y());
        telemetry.addData("Euler Z", v.z());
    }

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.BLUE);
        imu = new Bno055(hardwareMap, "imu");
        imu.init();
    }

    public void init_loop()
    {
        if (imu.isInitActive()) {
            imu.init_loop();
        } else if (!initComplete) {
            initComplete        = true;
            String status  = imu.isInitDone()?"OK":"Failed";
            telemetry.addData("Init", status);
        }
    }

    public void start()
    {
        sensorData  = imu.startSchedule(Bno055.BnoPolling.SENSOR, 100);     // 10 Hz
        fusionData  = imu.startSchedule(Bno055.BnoPolling.FUSION, 33);      // 30 Hz
        tempData    = imu.startSchedule(Bno055.BnoPolling.TEMP, 200);       // 5 Hz
        calibData   = imu.startSchedule(Bno055.BnoPolling.CALIB, 250);      // 4 Hz
    }

    public void loop() {

        imu.loop();
        updateQuaternion(imuData, imu.quaternionW(), imu.quaternionX(), imu.quaternionY(), imu.quaternionZ());
        imuData.normalize();
        imuEuler = imuData.toEuler();
        imuEuler.toDegrees();
        printVector(imuEuler);

        //-----------------
        //Gamepad 1
        //-----------------
        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());
        telemetry.addData("Error", bot.slides.pidControl.getError());
        //telemetry.addData("Joy", gamepad1.left_stick_y / 2.0 + " " + gamepad1.right_stick_y / 2.0);

        //drive
        bot.drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
        bot.drive.setOrientation(gamepad1.a);
        bot.drive.setHook(gamepad1.right_trigger == 1.0);

        //Slides
        bot.slides.setRamp(gamepad1.right_bumper);
        bot.slides.setAngle(gamepad1.dpad_up, gamepad1.dpad_down);
        bot.slides.setIntake(gamepad1.left_trigger == 1.0, gamepad1.left_bumper);
        //bot.slides.setTransmissionPower(gamepad1.y, gamepad1.x);
        bot.slides.testLinearSlide(0.5, gamepad1.y, gamepad1.x);
        //-----------------
        //Gamepad 2
        //-----------------
        //Drive Telemetry

        //Drive
        /*bot.drive.setLeftRightPower(gamepad2.left_stick_y/2.0, gamepad2.right_stick_y/2.0);
        bot.drive.setOrientation(gamepad2.a);
        bot.drive.setHook(gamepad2.right_trigger == 1.0);

        //Slides
        bot.slides.setRamp(gamepad2.right_bumper);
        bot.slides.setAngle(gamepad2.dpad_up, gamepad2.dpad_down);
        bot.slides.setIntake(gamepad2.left_trigger == 1.0, gamepad2.left_bumper);
        //bot.slides.setTransmissionPower(gamepad2.y, gamepad2.x);
        bot.slides.testLinearSlide(0.5, correction, gamepad2.y, gamepad1.x);*/
    }

    public void stop()
    {

    }
}
