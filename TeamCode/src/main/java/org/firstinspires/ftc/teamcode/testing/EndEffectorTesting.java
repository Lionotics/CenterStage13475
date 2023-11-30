package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp
public class EndEffectorTesting extends LinearOpMode {
    private Robot robject = new Robot(false);
    @Override
    public void runOpMode() throws InterruptedException {
        robject.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            if (gamepad1.x){
                robject.endEffector.pivotUp();
            } else if (gamepad1.y){
                robject.endEffector.pivotDown();
            } else if (gamepad1.a){
                robject.endEffector.toggleTop();
            } else if (gamepad1.b){
                robject.endEffector.toggleBottom();
            }
        }
    }
}
