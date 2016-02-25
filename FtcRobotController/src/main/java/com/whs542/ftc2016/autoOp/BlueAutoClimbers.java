package com.whs542.ftc2016.autoOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.lib.sensors.PIDController;
import com.whs542.lib.sensors.imu.Quaternion;
import com.whs542.lib.sensors.imu.Vector;

import org.FTC5866.lib.Bno055;

public class BlueAutoClimbers extends OpMode{

    Bno055 imu;
    Quaternion imuData = new Quaternion();
    Vector imuEuler = new Vector(3);

    PIDController pid = new PIDController(0.015, 0.0, 0.0, 0.0);

    boolean initComplete = false;        // Flag to stop initialization

    Bno055.ScheduleItem sensorData,fusionData,  // Data read schedules
            tempData,calibData;

    WHSRobot bot;

    double currentHeading;
    double correction;

    int state = 0;

    public double clamp(double value)
    {
        if(value > 1.0)
        {
            return 1.0;
        }
        else if(value < -1.0)
        {
            return -1.0;
        }
        else
        {
            return value;
        }
    }

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
        bot.drive.zeroLeftEncoders();
        bot.drive.zeroRightEncoders();
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
    public void loop()
    {
        bot.drive.setHook(false);
        telemetry.addData("state", state);
        telemetry.addData("Angular error", pid.getError());
        imu.loop();
        updateQuaternion(imuData, imu.quaternionW(), imu.quaternionX(), imu.quaternionY(), imu.quaternionZ());
        imuData.normalize();
        imuEuler = imuData.toEuler();
        imuEuler.toDegrees();

        switch(state) {
            case 0:
                bot.drive.setLeftRightPower(0.5, 0.5);
                bot.drive.autoNeutral();
                //2.25 feet
                if (bot.drive.hasTargetHit(2.25)) {
                    bot.drive.setLeftRightPower(0.0, 0.0);
                    currentHeading = imuEuler.x();
                    state = 1;
                }
                break;

            case 1:
                correction = pid.update(45.0, Math.abs(imuEuler.x() - currentHeading));
                correction = clamp(correction);
                bot.drive.setLeftRightPower(correction, -correction);
                if (Math.abs(Math.abs(imuEuler.x() - currentHeading) - 45.0) < 0.5)
                {
                    bot.drive.setLeftRightPower(0.0,0.0);
                    state = 2;
                }
            break;

            case 2:
                bot.drive.setLeftRightPower(0.5, 0.5);
                if (bot.drive.hasTargetHit(5.0)) {
                    currentHeading = imuEuler.x();
                    state = 3;
                }
                break;

            case 3:
                correction = pid.update(45.0, Math.abs(imuEuler.x() - currentHeading));
                correction = clamp(correction);
                bot.drive.setLeftRightPower(correction, -correction);
                if (Math.abs(Math.abs(imuEuler.x() - currentHeading) - 45.0) < 0.5)
                {
                    state = 4;
                }
                break;

            case 4:

                bot.drive.setLeftRightPower(0.0, 0.0);
                if (bot.drive.hasTargetHit(2.25)) {
                    //state = 5;
                }
                break;

            /*case 5:
                bot.drive.setLeftRightPower(0.0, 0.0);
                bot.drive.autoDump();
                state = 6;
            break;

            case 6:
                //bot.slides.setTransmissionPower(true, false);
                if(bot.slides.fullyExtended(30.0))
                {
                    state = 7;
                }
            break;

            case 7:
                //bot.slides.setTransmissionPower(false,false);
            break;*/
        }
    }
    public void stop()
    {

    }
}
