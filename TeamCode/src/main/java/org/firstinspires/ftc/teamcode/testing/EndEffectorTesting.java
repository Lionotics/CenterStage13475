package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.InitOptions;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.helpers.GamepadEx;

@TeleOp(group = "Tests")
public class EndEffectorTesting extends LinearOpMode {
    private final Robot robot = new Robot(false);
    GamepadEx gp1 = new GamepadEx();
    @Override
    public void runOpMode() throws InterruptedException {
        InitOptions options = new InitOptions(false);
        options.endEffectorEnabled = true;
        options.drivingEnabled = true;
        robot.init(hardwareMap, options);
        waitForStart();
        while(opModeIsActive()){
            gp1.update(gamepad1);
            robot.drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
            if (gp1.x.isNewlyPressed()){
                robot.endEffector.pivotUp();
            } else if (gp1.y.isNewlyPressed()){
                robot.endEffector.pivotDown();
            } else if (gp1.a.isNewlyPressed()){
                robot.endEffector.toggleTop();
            } else if (gp1.b.isNewlyPressed()){
                robot.endEffector.toggleBottom();
            }
            telemetry.update();
        }
    }
}
