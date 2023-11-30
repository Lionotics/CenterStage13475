package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

@Autonomous
public class JustDrive extends LinearOpMode
{
    Robot robject = new Robot(true);
    static final double FEET_PER_METER = 3.28084;

    @Override
    public void runOpMode() {
        telemetry.setMsTransmissionInterval(50);
        //Hardware initializing
        robject.init(hardwareMap);
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