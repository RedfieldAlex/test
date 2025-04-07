package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

    @Override
    public void runOpMode() {

        arm = new Arm(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        intake = new Intake(hardwareMap);
        lift = new Lift(hardwareMap);

        waitForStart();

        while (opModeInInit()) {
            //Telemetry
        }


        if (opModeIsActive()) {

            liftSensor.sensor();
            arm.armPos1000();
            intake.intakeRelease();
            sleep(2000);
            intake.intakeStop();

        }

    }

}
