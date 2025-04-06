package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Lift_Sensor {

    public TouchSensor liftSensor = null;
    public DcMotor leftLift = null;
    public DcMotor rightLift = null;

    private void liftSensor() {

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
