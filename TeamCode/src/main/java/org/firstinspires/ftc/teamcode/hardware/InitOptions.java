package org.firstinspires.ftc.teamcode.hardware;

public class InitOptions {
    public boolean airplaneEnabled, climbEnabled, drivingEnabled, endEffectorEnabled, intakeEnabled, placerEnabled, slidesEnabled;
    public InitOptions(boolean all){
        this.airplaneEnabled = all;
        this.climbEnabled = all;
        this.drivingEnabled = all;
        this.endEffectorEnabled = all;
        this.intakeEnabled = all;
        this.placerEnabled = all;
        this.slidesEnabled = all;
    }
}
