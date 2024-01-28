package org.firstinspires.ftc.teamcode.hardware;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

@Config
public class EndEffector extends Mechanism {
    ServoImplEx rightPivot, leftPivot, top, bottom;
    public static double TOP_CLOSE = 0.9;
    public static double TOP_OPEN = 0.5;
    public static double BOTTOM_CLOSE = 0.5;
    public static double BOTTOM_OPEN = 0.7;
    public static double PIVOT_AUTO = 0.38;
    public static double PIVOT_UP = 0.59;
    public static double PIVOT_DOWN = 0.76;

    boolean topOpen = true;
    boolean bottomOpen = true;

    @Override
    public void init(HardwareMap hwMap) {
        leftPivot = (ServoImplEx) hwMap.servo.get("leftPivot");
        rightPivot = (ServoImplEx) hwMap.servo.get("rightPivot");
        rightPivot.setDirection(Servo.Direction.REVERSE);

        top = (ServoImplEx) hwMap.servo.get("top");
        bottom = (ServoImplEx) hwMap.servo.get("bottom");

        leftPivot.setPwmRange(new PwmControl.PwmRange(500, 2500));
        rightPivot.setPwmRange(new PwmControl.PwmRange(500, 2500));
    }
    public void pivotUp() {
        leftPivot.setPosition(PIVOT_UP);
        rightPivot.setPosition(PIVOT_UP);
    }
    public void pivotDown() {
        leftPivot.setPosition(PIVOT_DOWN);
        rightPivot.setPosition(PIVOT_DOWN);
    }
    public void pivotAuto() {
        leftPivot.setPosition(PIVOT_AUTO);
        rightPivot.setPosition(PIVOT_AUTO);
    }
    public void toggleTop() {
        if (topOpen) {
            closeTop();
        } else {
            openTop();
        }
        topOpen = !topOpen;
    }
    public void toggleBottom() {
        if (bottomOpen) {
            closeBottom();
        } else {
            openBottom();
        }
        bottomOpen = !bottomOpen;
    }
    public void openBottom() {
        bottom.setPosition(BOTTOM_OPEN);
    }
    public void closeBottom() {
        bottom.setPosition(BOTTOM_CLOSE);
    }
    public void openTop() {
        top.setPosition(TOP_OPEN);
    }
    public void closeTop() {
        top.setPosition(TOP_CLOSE);
    }
}
