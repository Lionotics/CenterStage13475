package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.units.qual.A;

// Class for cleaner code
public class Robot {
    public Airplane airplane = new Airplane();
    public Climb climb = new Climb();
    public Slides slides = new Slides();
    public Drivetrain drive = new Drivetrain();
    public EndEffector endEffector = new EndEffector();
    public  Placer placer = new Placer();
    //TODO: Add end effector
    public boolean isAuto = false;

    public Robot(boolean isAuto){
        this.isAuto = isAuto;
    }

    public void init(HardwareMap hwMap, InitOptions options){
        if (options.airplaneEnabled) {airplane.init(hwMap);}
        if (options.climbEnabled) {climb.init(hwMap);}
        if (options.endEffectorEnabled) {endEffector.init(hwMap);}
        if (options.slidesEnabled) {slides.init(hwMap);}
        if (options.placerEnabled) {placer.init(hwMap);}

        // If we are in auto, assume roadrunner is handling the drivetrain
        if (!isAuto && options.drivingEnabled) {drive.init(hwMap);}
    }
}