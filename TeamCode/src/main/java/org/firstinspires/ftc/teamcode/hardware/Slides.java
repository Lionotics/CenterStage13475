package org.firstinspires.ftc.teamcode.hardware;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class Slides extends Mechanism{
    DcMotor slide;
    public static double SLIDES_UP = 200;

    public static double hold = 0;
    @Override
    public void init(HardwareMap hwMap) {
        slide = hwMap.dcMotor.get("beltSlide");

        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void slideUp(){
        if (slide.getCurrentPosition() < SLIDES_UP) {
            slide.setPower(1);
        }
    }
    public void slideDown(){
        if (slide.getCurrentPosition() > 0) {
            slide.setPower(-1);
        }
    }
    public void hold(){
        slide.setPower(hold);
    }
    public double pos(){
        return slide.getCurrentPosition();
    }
}
