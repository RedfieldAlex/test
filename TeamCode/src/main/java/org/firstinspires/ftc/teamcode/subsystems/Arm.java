package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Arm {

    public DcMotor arm = null;

    public void arm(Gamepad gamepad2) {

        if (gamepad2.x) {
            arm.setTargetPosition(2400);   // Clear barrier
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(1.0);
        }
        else if (gamepad2.y) {
            arm.setTargetPosition(980);    // Level 1 hang
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(1.0);
        }
        else if (gamepad2.b) {
            arm.setTargetPosition(1600);    // Scoring
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(1.0);
        }
        else if (gamepad2.a) {
            arm.setTargetPosition(2700);    // Slightly parallel to ground
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(1.0);
        }
        else if (gamepad2.right_stick_button) {
            arm.setTargetPosition(0);    // Home Pos
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(1.0);
        }
        else if (!arm.isBusy()) {
            arm.setPower(0);
        }

    }

}
