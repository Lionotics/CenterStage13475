package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
@Config
public class AutoConstants {

    public static final Pose2d RED_RIGHT_START = new Pose2d(12, -64, Math.toRadians(180));
    public static final Pose2d BLUE_LEFT_START = mirror(RED_RIGHT_START);

    public static final Pose2d RED_RIGHT_LEFT_SPIKEMARK = new Pose2d(9.5,-40,Math.toRadians(135));
    public static final Pose2d RED_RIGHT_CENTER_SPIKEMARK = new Pose2d(11.5,-34,Math.toRadians(90));
    public static final Pose2d RED_RIGHT_LEFT_PUSH = new Pose2d(3,-35,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_LEFT_PLACE = new Pose2d(4.5,-37,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_CENTER_PUSH = new Pose2d(14,-32,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_CENTER_PLACE = new Pose2d(14,-34,Math.toRadians(180));
    public static final Pose2d RED_RIGHT_RIGHT_PUSH = new Pose2d(18,-44,Math.toRadians(135));
    public static final Pose2d RED_RIGHT_RIGHT_PLACE = new Pose2d(18,-46,Math.toRadians(135));


    public static final Pose2d BLUE_LEFT_RIGHT_SPIKEMARK = mirror(RED_RIGHT_LEFT_SPIKEMARK);
    public static final Pose2d BLUE_LEFT_CENTER_SPIKEMARK = mirror(RED_RIGHT_CENTER_SPIKEMARK);
    public static final Pose2d BLUE_LEFT_LEFT_PUSH = mirror(RED_RIGHT_RIGHT_PUSH);
    public static final Pose2d BLUE_LEFT_LEFT_PLACE = mirror(RED_RIGHT_RIGHT_PLACE);


    public static final Pose2d RED_LEFT_STAGE = new Pose2d(52,-30,0);
    public static final Pose2d RED_CENTER_STAGE = new Pose2d(52,-34,0);
    public static final Pose2d RED_RIGHT_STAGE = new Pose2d(52,-42,0);

    public static final Pose2d BLUE_RIGHT_STAGE = mirror(RED_LEFT_STAGE);
    public static final Pose2d BLUE_CENTER_STAGE = mirror(RED_CENTER_STAGE);
    public static final Pose2d BLUE_LEFT_STAGE = mirror(RED_RIGHT_STAGE);

    public static Pose2d mirror(Pose2d pose){
        return new Pose2d(pose.getX(),-pose.getY(),-pose.getHeading());
    }

}