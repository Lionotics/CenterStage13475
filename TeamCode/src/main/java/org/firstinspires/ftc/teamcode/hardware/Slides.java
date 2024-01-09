package org.firstinspires.ftc.teamcode.hardware;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class Slides extends Mechanism{
    DcMotor slide;
    public static double SLIDES_UP = 2000;
    public static double SLIDES_HOLD = 0;
    public static double MAX_SPEED = 1;
    public static double MAX_AUTO_SPEED = 1;
    private PIDController controller;
    public static int target = 0;
    public static double Kg = SLIDES_HOLD;
    public static double Kp = .005;
    public static double Ki = 0;
    public static double Kd = 0;
    public static int exitThreshold = 10;

    // state machine
    public enum LIFT_STATE {
        AUTO_MOVE,
        MANUAL_UP,
        MANUAL_DOWN,
        HOLDING
    }
    private LIFT_STATE liftState = LIFT_STATE.HOLDING;
    @Override
    public void init(HardwareMap hwMap) {
        slide = hwMap.dcMotor.get("slides");

        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide.setDirection(DcMotor.Direction.REVERSE);

        controller = new PIDController(Kp,Ki,Kd);
        controller.setPID(Kp,Ki,Kd);
    }
    public double pos(){
        return slide.getCurrentPosition();
    }
    public void autoMoveTo(int newTarget){
        setTarget(newTarget);
        liftState = LIFT_STATE.AUTO_MOVE;
    }

    public void pidLoop(){
        controller = new PIDController(Kp,Ki,Kd);
        controller.setPID(Kp,Ki,Kd);
        double pos = this.getPosition();
        double power = controller.calculate(pos,target);
        if(this.getPosition() > 10) {
            slide.setPower((power * MAX_AUTO_SPEED) + Kg);
        } else{
            slide.setPower((power * MAX_AUTO_SPEED));
        }

    }
    public void setTarget(int target){
        Slides.target = target;}
    public int getTarget(){return target;}

    // Manual movement
    public void slideUp(){
        if (slide.getCurrentPosition() < SLIDES_UP) {
            slide.setPower(MAX_SPEED);
        }
    }
    public void manualUp(){
        liftState = LIFT_STATE.MANUAL_UP;
    }

    public void slideDown(){
        if (slide.getCurrentPosition() > 0) {
            slide.setPower(-MAX_SPEED);
            slide.setPower(-MAX_SPEED);
        }
    }
    public void manualDown(){
        liftState = LIFT_STATE.MANUAL_DOWN;
    }

    public void slideStop(){
        if(this.getPosition() > 10) {
            slide.setPower(SLIDES_HOLD);
        } else {
            slide.setPower(0);
            slide.setPower(0);
        }
    }
    public void hold(){
        liftState = LIFT_STATE.HOLDING;
    }
    public void loop(){
        switch (liftState){
            case AUTO_MOVE:
                pidLoop();
                break;
            case MANUAL_DOWN:
                slideDown();
                break;
            case MANUAL_UP:
                slideUp();
                break;
            case HOLDING:
                slideStop();
                break;
        }
    }
    public int getPosition(){
        return slide.getCurrentPosition();
    }
    public LIFT_STATE getLiftState(){
        return liftState;
    }
}