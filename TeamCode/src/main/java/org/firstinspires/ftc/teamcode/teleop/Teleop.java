package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Climb;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.hardware.Slides;
import org.firstinspires.ftc.teamcode.helpers.GamepadEx;

@TeleOp(name = "Teleop")
public class Teleop extends LinearOpMode {
    Robot robot = new Robot(false);
    GamepadEx gamepadEx1 = new GamepadEx();
    GamepadEx gamepadEx2 = new GamepadEx();
    ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.drive.setMaxSpeed(0.8);

        waitForStart();
        robot.intake.stop();

        while (opModeIsActive()) {
            time.reset();

            // update our gamepad extionsion
            gamepadEx1.update(gamepad1);
            gamepadEx2.update(gamepad2);

            // Actually drive the robot
            robot.drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            // intake controls
            // Only allow intake when slides are not actively moving
            if (gamepad1.right_bumper
                    && robot.slides.getLiftState() == Slides.LIFT_STATE.HOLDING) {
                robot.intake.intake();
            } else if (gamepad1.left_trigger > 0.6) {
                robot.intake.outtake();
            } else{
                robot.intake.stop();
            }


            // Manual slides control - just up and down
            if ((gamepad1.b || gamepad1.dpad_up) && robot.slides.getPosition() < robot.slides.SLIDES_UP) {
                robot.slides.slideUp();
            } else if (gamepad1.left_bumper && robot.slides.getPosition() > 0) {
                robot.slides.slideDown();
            } else {
                robot.slides.slideStop();
            }

            if (gamepadEx1.left.isNewlyPressed()) {
                if(robot.climb.getClimbState() == Climb.ClimbState.STOWED){
                    robot.climb.startRaise();
                } else if (robot.climb.getClimbState() == Climb.ClimbState.RAISED){
                    robot.climb.startClimb();
                }
            }

            robot.climb.updateClimb();

            // Telemetry
            /*telemetry.addData("Slides pos", robot.slides.getPosition());
            telemetry.addData("PixelState", robot.arm.getPixelState());
            telemetry.addData("ArmState", robot.arm.getArmState());
            telemetry.addData("IntakeState", robot.intake.getIntakeState());
            telemetry.addData("Climb pos", robot.climb.getPosition());
            telemetry.addData("Climb State ", robot.climb.getClimbState());
            telemetry.addData("Intake Height", robot.intake.intakeHeight);
            telemetry.update();*/
        }
    }
}