package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp
public class SlidesTesting extends LinearOpMode {

    private Robot robject = new Robot(false);
    @Override
    public void runOpMode() throws InterruptedException {
        robject.drive.init(hardwareMap);
        robject.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            robject.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
            if (gamepad1.a){
                robject.slides.slideUp();
            } else if (gamepad1.b){
                robject.slides.slideDown();
            } else {
                robject.slides.hold();
            }
            telemetry.addLine(String.valueOf(robject.slides.pos()));
            telemetry.update();
        }
    }
}
