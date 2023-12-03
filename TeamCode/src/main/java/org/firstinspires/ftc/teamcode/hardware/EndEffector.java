package org.firstinspires.ftc.teamcode.hardware;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class EndEffector extends Mechanism {
    Servo leftPivot, rightPivot, top, bottom;
    public static double CLOSE = 0.5;
    public static double OPEN = 0.65;
    public static double PIVOT_DOWN = 0.95;
    public static double PIVOT_UP = 0.73;
    boolean topOpen = true;
    boolean bottomOpen = true;

    @Override
    public void init(HardwareMap hwMap) {
        leftPivot = hwMap.servo.get("leftPivot");
        rightPivot = hwMap.servo.get("rightPivot");
        top = hwMap.servo.get("top");
        bottom = hwMap.servo.get("bottom");

        rightPivot.setDirection(Servo.Direction.REVERSE);
    }
    public void pivotUp() {
        leftPivot.setPosition(PIVOT_UP);
        rightPivot.setPosition(PIVOT_UP);
    }
    public void pivotDown() {
        leftPivot.setPosition(PIVOT_DOWN);
        rightPivot.setPosition(PIVOT_DOWN);
    }
    public void toggleTop() {
        if (topOpen) {
            top.setPosition(CLOSE);
        } else {
            top.setPosition(OPEN);
        }
        topOpen = !topOpen;
    }
    public void toggleBottom() {
        if (bottomOpen) {
            bottom.setPosition(CLOSE);
        } else {
            bottom.setPosition(OPEN);
        }
        bottomOpen = !bottomOpen;
    }
}
