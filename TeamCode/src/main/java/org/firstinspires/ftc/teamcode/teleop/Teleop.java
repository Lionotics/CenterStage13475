package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Climb;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.helpers.GamepadEx;

@TeleOp(name = "Teleop")
public class Teleop extends LinearOpMode {
    Robot robot = new Robot(false);
    GamepadEx gp1 = new GamepadEx();
    GamepadEx gp2 = new GamepadEx();
    ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.drive.setMaxSpeed(0.8);

        waitForStart();
        robot.intake.stop();

        while (opModeIsActive()) {
            time.reset();

            // update our gamepad extension
            gp1.update(gamepad1);
            gp2.update(gamepad2);

            // Actually drive the robot
            robot.drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            // intake controls
            if (gp1.leftBumper.isNewlyPressed() || gp2.leftBumper.isNewlyPressed()) {
                robot.intake.intake();
            } else if (gp1.rightBumper.isNewlyPressed() || gp2.rightBumper.isNewlyPressed()) {
                robot.intake.outtake();
            } else {
                robot.intake.stop();
            }

            if (gp1.left.isNewlyPressed() || gp2.left.isNewlyPressed()) {
                if(robot.climb.getClimbState() == Climb.ClimbState.STOWED) {
                    robot.climb.startRaise();
                } else if (robot.climb.getClimbState() == Climb.ClimbState.RAISED) {
                    robot.climb.startClimb();
                }
            }

            if (gp1.x.isNewlyPressed() || gp2.x.isNewlyPressed()) {
                robot.endEffector.pivotUp();
            } else if (gp1.y.isNewlyPressed() || gp2.y.isNewlyPressed()) {
                robot.endEffector.pivotDown();
            } else if (gp1.a.isNewlyPressed() || gp2.a.isNewlyPressed()) {
                robot.endEffector.toggleTop();
            } else if (gp1.b.isNewlyPressed() || gp2.b.isNewlyPressed()) {
                robot.endEffector.toggleBottom();
            }

            if (gamepad1.dpad_right || gamepad2.dpad_right) {
                robot.airplane.shootAirplane();
            }

            robot.climb.updateClimb();

            // Telemetry
            telemetry.addData("Climb pos", robot.climb.getPosition());
            telemetry.addData("Climb State ", robot.climb.getClimbState());
            telemetry.update();
        }
    }
}