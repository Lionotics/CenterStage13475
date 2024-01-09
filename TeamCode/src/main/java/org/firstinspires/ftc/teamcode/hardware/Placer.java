package org.firstinspires.ftc.teamcode.hardware;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Placer extends Mechanism{
    Servo placer;
    public static double up = 0;
    public static double down = 1;

    @Override
    public void init(HardwareMap hwMap) {
        placer = hwMap.servo.get("autoGrabber");
    }

    public void reset() {
        placer.setPosition(up);
    }
    public void place() {
        placer.setPosition(down);
    }
    public double pos() { return placer.getPosition();}
}
