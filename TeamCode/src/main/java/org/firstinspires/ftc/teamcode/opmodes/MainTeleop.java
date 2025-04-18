package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.RobotContainer;

@TeleOp (name = "Main_Teleop", group = "Robot")
public class MainTeleop extends LinearOpMode {

    RobotContainer robotContainer;

    @Override
    public void runOpMode() {

        robotContainer = new RobotContainer(hardwareMap);

        waitForStart();

        while (opModeInInit()) {

            robotContainer.updateTelemetry(telemetry);

        }

        while (opModeIsActive()) {

            robotContainer.updateTelemetry(telemetry);
            robotContainer.liftSensorFunc();

            robotContainer.armFunc(gamepad2);
            robotContainer.drivetrainFunc(gamepad1);
            robotContainer.intakeFunc(gamepad2);
            robotContainer.liftFunc(gamepad2);

        }

    }

}
