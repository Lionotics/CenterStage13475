package com.example.meepmeeptesting;

import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
//                .followTrajectorySequence(drive ->
//                        drive.trajectorySequenceBuilder(AutoConstants.RED_RIGHT_START)
//                                //
//                                .lineToSplineHeading(AutoConstants.RED_RIGHT_LEFT_SPIKEMARK)
//                                //
//                                .waitSeconds(1)
//                                //
//                                .lineToSplineHeading(AutoConstants.RED_LEFT_STAGE)
//                                //
//                                .waitSeconds(3)
//                                .back(3)
//                                //
//                                .build()
//                );
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(AutoConstants.RED_RIGHT_START)
                        .strafeRight(28)
                        .lineToSplineHeading(AutoConstants.RED_RIGHT_LEFT_PUSH)
                        .lineToSplineHeading(AutoConstants.RED_RIGHT_LEFT_PLACE)
                        .waitSeconds(1)
                        .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}