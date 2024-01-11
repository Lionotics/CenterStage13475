package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
@Config
public class AutoConstants {

    public static final Pose2d RED_RIGHT_START = new Pose2d(12, -64, Math.toRadians(180));
    public static final Pose2d BLUE_LEFT_START = new Pose2d(12, 64, Math.toRadians(0));

    public static final Pose2d RED_RIGHT_LEFT_PUSH = new Pose2d(3,-35,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_LEFT_PLACE = new Pose2d(4.5,-37,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_CENTER_PUSH = new Pose2d(14,-32,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_CENTER_PLACE = new Pose2d(14,-34,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_RIGHT_PUSH = new Pose2d(18,-44,Math.toRadians(135));
    public static final Pose2d RED_RIGHT_RIGHT_PLACE = new Pose2d(18,-46,Math.toRadians(135));


    public static final Pose2d BLUE_LEFT_RIGHT_PUSH = new Pose2d(3, 35, Math.toRadians(0));
    public static final Pose2d BLUE_LEFT_RIGHT_PLACE = new Pose2d(-3.5, 37, Math.toRadians(0));

    public static final Pose2d BLUE_LEFT_CENTER_PUSH = new Pose2d(14,30,Math.toRadians(0));
    public static final Pose2d BLUE_LEFT_CENTER_PLACE = new Pose2d(10,33,Math.toRadians(0));

    public static final Pose2d BLUE_LEFT_LEFT_PUSH = new Pose2d(14, 30, Math.toRadians(45));
    public static final Pose2d BLUE_LEFT_LEFT_PLACE = new Pose2d(12, 36, Math.toRadians(45));


    public static final Pose2d RED_LEFT_STAGE = new Pose2d(47,-30,0);
    public static final Pose2d RED_CENTER_STAGE = new Pose2d(47,-34,0);
    public static final Pose2d RED_RIGHT_STAGE = new Pose2d(47,-42,0);

    public static final Pose2d BLUE_RIGHT_STAGE = new Pose2d(49,30,0);
    public static final Pose2d BLUE_CENTER_STAGE = new Pose2d(49,34,0);
    public static final Pose2d BLUE_LEFT_STAGE = new Pose2d(49,42,0);

    public static final Pose2d RED_RIGHT_PARK = new Pose2d(52, -60, Math.toRadians(270));
    public static final Pose2d BLUE_LEFT_PARK = new Pose2d(52, 60, Math.toRadians(270));

    public static Pose2d mirror(Pose2d pose){
        return new Pose2d(pose.getX(),-pose.getY(),pose.getHeading() + Math.toRadians(180));
    }
    public static Pose2d negateY(Pose2d pose){
        return new Pose2d(pose.getX(),-pose.getY(),pose.getHeading());
    }
}