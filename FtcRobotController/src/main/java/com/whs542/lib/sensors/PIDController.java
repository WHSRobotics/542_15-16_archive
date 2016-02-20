package com.whs542.lib.sensors;

/**
 * Created by DanielWang on 2/9/16.
 */
public class PIDController{

    private double kp;
    private double ki;
    private double kd;
    private double integralDamper;
    public double lastError = 0.0;
    private double errorSum = 0.1;

    public PIDController(double pIn, double iIn, double dIn, double damping)
    {
        kp = pIn;
        ki = iIn;
        kd = dIn;
        integralDamper = damping;
    }
    public double update(double reference, double sensorValue)
    {
        double error = reference - sensorValue;
        double output = kp * error + ki * errorSum - kd * (error - lastError);
        lastError = error;
        if(errorSum > 1.0)
        {
            errorSum = (1/errorSum) *(errorSum + error); //integralDamper
        }
        else
        {
            errorSum = integralDamper * (errorSum + error);
        }
        return output;
    }
}