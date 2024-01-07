package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.InitOptions;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp(group = "Tests")
public class SlidesTesting extends LinearOpMode {

    private Robot robot = new Robot(false);
    @Override
    public void runOpMode() throws InterruptedException {
        InitOptions options = new InitOptions(false);
        options.slidesEnabled = true;
        options.drivingEnabled = true;
        robot.init(hardwareMap, options);
        waitForStart();
        while(opModeIsActive()){
            robot.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
            if (gamepad1.dpad_up){
                robot.slides.manualUp();
            } else if (gamepad1.dpad_down){
                robot.slides.manualDown();
            } else {
                robot.slides.hold();
            }
            robot.slides.loop();
            telemetry.addLine(String.valueOf(robot.slides.pos()));
            telemetry.update();
        }
    }
}
