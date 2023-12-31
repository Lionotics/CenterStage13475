package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.InitOptions;
import org.firstinspires.ftc.teamcode.hardware.Robot;


@TeleOp(group = "Tests")
public class ClimbTesting extends LinearOpMode {

    Robot robot = new Robot(false);

    @Override
    public void runOpMode() throws InterruptedException {
        InitOptions options = new InitOptions(false);
        options.drivingEnabled = true;
        options.climbEnabled = true;
        robot.init(hardwareMap, options);
        waitForStart();

        while(opModeIsActive()){
            if(gamepad1.dpad_up){
                robot.climb.manualUp();
            } else if (gamepad1.dpad_down){
                robot.climb.manualDown();
            } else {
                robot.climb.stop();
            }

            if(gamepad1.a) {
                robot.climb.hookUp();
            } else if (gamepad1.b ){
                robot.climb.hookDown();
            }

            robot.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);

            telemetry.addData("Climb Pos", robot.climb.getPosition());
            telemetry.update();
        }
    }
}