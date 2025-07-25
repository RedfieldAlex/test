package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;
import org.firstinspires.ftc.teamcode.subsystems.LiftSensor;

@Autonomous (name = "MainAuto", group = "Robot")
public class MainAuto extends LinearOpMode {

    Arm arm;
    Drivetrain drivetrain;
    Intake intake;
    Lift lift;
    LiftSensor liftSensor;

    RobotContainer robotContainer;

    @Override
    public void runOpMode() {

        robotContainer = new RobotContainer(hardwareMap);

        while (opModeInInit()) {

            robotContainer.updateTelemetry(telemetry);

        }

        waitForStart();

        if (opModeIsActive()) {

            robotContainer.updateTelemetry(telemetry);
            robotContainer.liftSensorFunc();

            arm.armPos1000();
            lift.liftPos5000();
            intake.intakeRelease();
            sleep(2000);
            intake.intakeStop();

        }

    }

}
