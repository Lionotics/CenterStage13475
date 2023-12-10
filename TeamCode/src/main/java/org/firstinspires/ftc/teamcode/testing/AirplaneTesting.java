package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp(group = "Tests")
public class AirplaneTesting extends LinearOpMode {

    Robot robot = new Robot(false);
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()){
            robot.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
        }
        if(gamepad1.dpad_right){
            robot.airplane.shootAirplane();
        }
    }
}
