package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.helpers.GamepadEx;

@TeleOp
public class EndEffectorTesting extends LinearOpMode {
    private Robot robject = new Robot(false);
    GamepadEx gp1 = new GamepadEx();
    @Override
    public void runOpMode() throws InterruptedException {
        robject.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            gp1.update(gamepad1);

            if (gp1.x.isNewlyPressed()){
                robject.endEffector.pivotUp();
            } else if (gp1.y.isNewlyPressed()){
                robject.endEffector.pivotDown();
            } else if (gp1.a.isNewlyPressed()){
                robject.endEffector.toggleTop();
            } else if (gp1.b.isNewlyPressed()){
                robject.endEffector.toggleBottom();
            }
            telemetry.update();
        }
    }
}
