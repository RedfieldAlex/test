package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;


@TeleOp (name = "Main_Teleop", group = "Robot")
public class Main_Teleop extends LinearOpMode {

    private Drivetrain drivetrain;
    private Arm arm;


    @Override
    public void runOpMode() {

        arm = new Arm();  // Initialize the Arm class
        Arm = hardwareMap.get(DcMotor.class, "arm");




        waitForStart();

        while (opModeInInit()) {
            //Telemetry
        }


        while (opModeIsActive()) {
            arm.arm(gamepad2);
            //arm, drivetrain, lift, lift-sensor
        }

    }

}
