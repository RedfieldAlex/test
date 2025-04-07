package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ControllerMapping {

    Arm arm;
    Drivetrain drivetrain;
    Intake intake;
    Lift lift;

    public ControllerMapping(HardwareMap X) {

        arm = new Arm(X);
        drivetrain = new Drivetrain(X);
        intake = new Intake(X);
        lift = new Lift(X);

    }

    public void armFunc(Gamepad gamepad2) {

        if (gamepad2.x) {
            arm.armPos1000(); // x maps to arm pos 1000
        }

        if (gamepad2.y) {
            arm.armPos2000(); // y maps to arm pos 2000
        }

    }

    public void drivetrainFunc(Gamepad gamepad1) {

        double strafe;
        double drive;
        double turn;
        double max;

        drive = -gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;
        strafe = gamepad1.left_stick_x;

        // Combine drive and turn for blended motion.
        double frontLeftPower = drive + strafe + turn;
        double frontRightPower = drive - strafe - turn;
        double backLeftPower = drive - strafe + turn;
        double backRightPower = drive + strafe - turn;

        // Normalize the values so neither exceed +/- 1.0
        max = Math.max(Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower)),
                Math.max(Math.abs(backLeftPower), Math.abs(backRightPower)));

        if (max > 1.0) {
            frontLeftPower /= max;
            frontRightPower /= max;
            backLeftPower /= max;
            backRightPower /= max;
        }

        if (gamepad1.left_bumper) {
            // Scale down to half speed if the left bumper is held
            frontLeftPower *= 0.5;
            frontRightPower *= 0.5;
            backLeftPower *= 0.5;
            backRightPower *= 0.5;
        } else if (gamepad1.right_bumper) {
            // Scale down to one-third speed if the right bumper is held
            frontLeftPower *= 0.33;
            frontRightPower *= 0.33;
            backLeftPower *= 0.33;
            backRightPower *= 0.33;
        }

        /*
        if (drive == 0 && turn == 0 && strafe == 0) {
            frontLeftPower = 0;
            frontRightPower = 0;
            backLeftPower = 0;
            backRightPower = 0;
        }
        */

        drivetrain.setDrivePower(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

    }

    public void intakeFunc(Gamepad gamepad2) {

        if (gamepad2.left_stick_y > 0) {
            intake.intakeCollect();
        }
        else if (gamepad2.left_stick_y < 0) {
            intake.intakeRelease();
        }
        else {
            intake.intakeStop();
        }

    }

    public void liftFunc(Gamepad gamepad2) {

        if (gamepad2.dpad_up) {
            lift.liftPos5000(); // dpad up maps to lift pos 4000
        }

        else if (gamepad2.dpad_down) {
            lift.liftPos0(); // dpad down maps to lift pos 0
        }

    }

}
