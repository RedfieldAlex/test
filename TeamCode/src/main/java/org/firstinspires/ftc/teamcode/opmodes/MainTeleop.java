package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.ControllerMapping;
import org.firstinspires.ftc.teamcode.subsystems.LiftSensor;

@TeleOp (name = "Main_Teleop", group = "Robot")
public class MainTeleop extends LinearOpMode {

    ControllerMapping controllerMapping;
    LiftSensor liftSensor;

    @Override
    public void runOpMode() {

        controllerMapping = new ControllerMapping(hardwareMap);
        liftSensor = new LiftSensor();

        waitForStart();

        while (opModeInInit()) {
            //Telemetry
        }

        while (opModeIsActive()) {

            controllerMapping.armFunc(gamepad2);
            controllerMapping.drivetrainFunc(gamepad1);
            controllerMapping.intakeFunc(gamepad2);
            controllerMapping.liftFunc(gamepad2);

            liftSensor.sensor();

        }

    }

}
