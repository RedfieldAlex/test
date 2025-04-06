package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Drivetrain {

    public DcMotor frontLeftDrive  = null;
    public DcMotor frontRightDrive = null;
    public DcMotor backLeftDrive = null;
    public DcMotor backRightDrive = null;

    public void drive(Gamepad gamepad1, Gamepad gamepad2) {

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
        } else if (gamepad2.right_bumper) {
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

        frontLeftDrive.setPower(frontLeftPower);
        frontRightDrive.setPower(frontRightPower);
        backLeftDrive.setPower(backLeftPower);
        backRightDrive.setPower(backRightPower);

    }
}

