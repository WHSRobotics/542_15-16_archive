package com.whs542.lib.sensors;

import com.qualcomm.robotcore.hardware.HardwareDevice;

/**
 * Created by DanielWang on 1/9/16.
 */
public abstract class I2C implements HardwareDevice
{
    public abstract boolean read(int reg, int length, byte[] asdf);

    public abstract boolean write(int reg, byte asdf);
}
