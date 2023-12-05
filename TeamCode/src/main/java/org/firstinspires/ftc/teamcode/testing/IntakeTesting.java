package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp(group = "Tests")
public class IntakeTesting extends LinearOpMode {

    private Robot robot = new Robot(false);
    @Override
    public void runOpMode() throws InterruptedException {
        robot.drive.init(hardwareMap);
        robot.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            robot.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
            if (gamepad1.left_bumper){
                robot.intake.intake();
            } else if (gamepad1.right_bumper){
                robot.intake.outtake();
            } else {
                robot.intake.stop();
            }
        }
    }
}
