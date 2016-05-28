package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.whs542.lib.sensors.EncoderTicks;
/**
 * Created by Joyce on 4/29/2016.
 */
public class ScoringMechanism {

    public DcMotor scoringMotor;
    int state = 1;
    boolean flipState = false;

    public ScoringMechanism(HardwareMap scoringMap)
    {
        scoringMotor = scoringMap.dcMotor.get("scoringMechanism");
    }

    public void flipForwards(){
        for(boolean i = false; i==false;)
        {
            if(scoringMotor.getCurrentPosition() < EncoderTicks.SCORING_MECHANISM/3-120){
                scoringMotor.setPower(0.5);
            }
            else{
                scoringMotor.setPower(0.0);
                i = true;
            }
        }
    }

    public void flipBackwards(){
        for(boolean i = false; i==false;) {
            if (scoringMotor.getCurrentPosition() >= 120) {
                scoringMotor.setPower(-0.5);
            }
            else {
                scoringMotor.setPower(0.0);
                i = true;
            }
        }
    }
    public void flip(boolean flipForward, boolean flipBackward){
        if(flipForward) {
            scoringMotor.setPower(0.3);
            //flipForwards();
        }
        else if (flipBackward) {
            scoringMotor.setPower(-0.3);
            //flipBackwards();
        }
        else {
            scoringMotor.setPower(0.0);
        }

    }
}

   /*
   public boolean flip(boolean forwards, boolean backwards)
   {
       if(forwards)
       {
           for(boolean i = false; i==true;)
           {
               if(scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM/3)-100){
                   scoringMotor.setPower(0.5);
               }
               else{
                   scoringMotor.setPower(0.0);
                   i = true;
               }
           }
           return true;

       }
       if (backwards){
           for(boolean i = false; i==true;) {
               if (scoringMotor.getCurrentPosition() >= 100) {
                   scoringMotor.setPower(-0.5);
               }
               else {
                   scoringMotor.setPower(0.0);
                   i = true;
               }
           }
           return true;
       }
       return false;
   }

   public void scoringAuto(boolean direction) {
       if (direction) {
           while (scoringMotor.getCurrentPosition() < EncoderTicks.SCORING_MECHANISM / 3) {
               scoringMotor.setPower(0.5);
           }
       }
       else {
           while (scoringMotor.getCurrentPosition() >= 100){
               scoringMotor.setPower(-0.5);
           }
       }
   }

   public void flip2 (boolean flip){
       if(flip){
           while (!flipState){
               switch (state){
                   case (1):
                       if (scoringMotor.getCurrentPosition() < EncoderTicks.SCORING_MECHANISM/3) {
                           scoringMotor.setPower(0.5);
                       }
                       else {
                           scoringMotor.setPower(0.0);
                           state = 2;
                       }
                   case (2):
                       if (scoringMotor.getCurrentPosition() >= 100 ){
                           scoringMotor.setPower(-0.5);
                       }
                       else {
                           scoringMotor.setPower(0.0);
                           flipState = true;
                       }
               }

<<<<<<< HEAD
            }
        }
    }

    public void flip3 (boolean flip){
        if(flip){
            switch (state){
                case (1):
                        if (scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM/3)-100) {
                            scoringMotor.setPower(0.5);
                        }
                        state = 2;
                case (2):
                        if (scoringMotor.getCurrentPosition() >= 100 ){
                            scoringMotor.setPower(-0.5);
                        }
                        state = 3;
                case(3):
                    scoringMotor.setPower(0.0);
                    break;

                }

            }
        }
    }
}
=======
           }
       }
   }

   public void flip3 (boolean flip){
       if(flip){
           switch (state){
               case (1):
                       if (scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM/3)-100) {
                           scoringMotor.setPower(0.5);
                       }
                       state = 2;
               case (2):
                       if (scoringMotor.getCurrentPosition() >= 100 ){
                           scoringMotor.setPower(-0.5);
                       }
                       state = 3;
               case(3):
                   scoringMotor.setPower(0.0);
                   break;

               }
            }
        }
    }
}*/

