package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class LiftSensor {

    TouchSensor liftSensor;
    DcMotor leftLift;
    DcMotor rightLift;

    public LiftSensor(HardwareMap hardwareMap) {

        liftSensor = hardwareMap.get(TouchSensor.class, "liftSensor");

        leftLift = hardwareMap.get(DcMotor.class, "leftLift");
        rightLift = hardwareMap.get(DcMotor.class, "rightLift");

        leftLift.setDirection(DcMotor.Direction.FORWARD);
        rightLift.setDirection(DcMotor.Direction.REVERSE);

        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public boolean isLiftSensorPressed() {

        return liftSensor.isPressed();

    }

    public void sensor() {

        if (liftSensor.isPressed()) {
            leftLift.setPower(0);
            rightLift.setPower(0);
            leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        else {
            leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

    }

}
