package com.whs542.ftc2016;

//	TEST Opmode
//	 Throw your test code in here
//

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.*;
import com.whs542.ftc2016.threads.DriveThread;
import com.whs542.lib.Alliance;

public class DebugOp extends OpMode
{
    Drive drive;

    volatile float armPower;

    public class ArmThread implements Runnable
    {
        public void run()
        {
            while (true)
            {
                armPower = gamepad2.right_stick_y;
                // Sleep for 10 ms.
                try { Thread.sleep(10); }
                // Catch an interrupt exception that hopefully never happens.
                catch (InterruptedException ex)
                {Thread.currentThread().interrupt(); }
            }
        }
    }

    public void init()
    {

    }

    Thread armThread;

    @Override
    public void start()
    {
        armPower = 0;
        armThread = new Thread(new ArmThread());
        armThread.start();
    }
    @Override
    public void loop()
    { // normal loop for drive motors
        telemetry.addData("left", gamepad1.left_stick_y );
        telemetry.addData("right", gamepad1.right_stick_y );
        telemetry.addData("arm", armPower );
    }

    public void stop()
    {
        armThread.interrupt();
    }
}