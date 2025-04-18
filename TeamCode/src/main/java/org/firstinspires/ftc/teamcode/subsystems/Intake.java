package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {

    Servo intake;

    public Intake(HardwareMap hardwareMap) {

        intake = hardwareMap.get(Servo.class, "Intake");

    }

    public double getIntakePosition() {
        return intake.getPosition(); // <- Getter in action
    }

    public void intakeStop() {
        intake.setPosition(0.5);
    }

    public void intakeCollect() {
        intake.setPosition(1.0);
    }

    public void intakeRelease() {
        intake.setPosition(0.0);
    }

}
