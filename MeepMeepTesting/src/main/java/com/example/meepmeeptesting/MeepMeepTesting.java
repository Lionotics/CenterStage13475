package com.example.meepmeeptesting;

import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(AutoConstants.RED_RIGHT_START)
                                .lineToSplineHeading(AutoConstants.RED_RIGHT_RIGHT_PUSH)
                                .lineToSplineHeading(AutoConstants.RED_RIGHT_RIGHT_PLACE)
                                .lineToSplineHeading(AutoConstants.RED_RIGHT_STAGE)
                                .lineToSplineHeading(AutoConstants.RED_RIGHT_PARK)
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}