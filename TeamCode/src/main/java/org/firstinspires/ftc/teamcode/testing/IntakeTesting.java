package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp
public class IntakeTesting extends LinearOpMode {

    private Robot robject = new Robot(false);
    @Override
    public void runOpMode() throws InterruptedException {
        robject.drive.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            robject.init(hardwareMap);
            robject.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
            if (gamepad1.left_bumper){
                robject.intake.intake();
            } else if (gamepad1.right_bumper){
                robject.intake.outtake();
            } else {
                robject.intake.stop();
            }
        }
    }
}
