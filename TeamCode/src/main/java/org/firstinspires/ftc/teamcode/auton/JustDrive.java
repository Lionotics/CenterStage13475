package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous
public class JustDrive extends LinearOpMode
{
    Robot robot = new Robot(true);
    static final double FEET_PER_METER = 3.28084;

    @Override
    public void runOpMode() {
        telemetry.setMsTransmissionInterval(50);
        //Hardware initializing
        robot.init(hardwareMap);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */

        while (!isStarted() && !isStopRequested()) {
            //TODO: Add choice selection for auto
            //based on the starting position, select the correct trajectory
            //drive.setPoseEstimate(new Pose2d());
            telemetry.update();
            sleep(20);
        }
        //DRIVER PRESSED THE PLAY BUTTON!

    }
}