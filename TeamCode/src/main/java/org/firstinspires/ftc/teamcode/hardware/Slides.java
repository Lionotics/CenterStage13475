package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slides extends Mechanism{
    DcMotor slide;
    private double SLIDES_UP;
    @Override
    public void init(HardwareMap hwMap) {
        slide = hwMap.dcMotor.get("slide");

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
}
