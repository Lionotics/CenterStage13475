package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.InitOptions;
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
        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        robot.init(hardwareMap, new InitOptions(true));
        robot.drive.setMaxSpeed(0.9);

        waitForStart();
        //robot.intake.stop();

        while (opModeIsActive()) {
            time.reset();

            // update our gamepad extension
            gp1.update(gamepad1);
            gp2.update(gamepad2);

            // Actually drive the robot
            robot.drive.drive(gp1.left_stick_y, gp1.left_stick_x, gp1.right_stick_x);

           // climb controls
            if (gp1.leftBumper.isCurrentlyPressed() || gp2.leftBumper.isCurrentlyPressed()) {
               robot.climb.hookUp(); 
            } else if (gp1.rightBumper.isCurrentlyPressed() || gp2.rightBumper.isCurrentlyPressed()) {
                robot.climb.hookDown(); 
            }
            if (gp1.left_trigger > 0.5 || gp2.left_trigger > 0.5) {
                robot.climb.manualUp();
            } else if (gp1.right_trigger > 0.5 || gp2.right_trigger > 0.5) {
               robot.climb.manualDown();
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

            if (gp1.dpad_up || gp2.dpad_up){
                robot.slides.slideUp();
            } else if (gp1.dpad_down || gp2.dpad_down){
                robot.slides.slideDown();
            } else {
                robot.slides.hold();
            }
            robot.slides.loop();

           if (gp1.dpad_right || gp2.dpad_right) {
               robot.airplane.shootAirplane();
           }

            // Telemetry
            //telemetry.addData("Climb pos", robot.climb.getPosition());
            //telemetry.addData("Climb State ", robot.climb.getClimbState());
            telemetry.update();
        }
    }
}