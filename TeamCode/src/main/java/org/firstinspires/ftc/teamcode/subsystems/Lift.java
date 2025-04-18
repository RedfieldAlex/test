package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {

    DcMotor leftLift;
    DcMotor rightLift;

    public Lift(HardwareMap hardwareMap) {

        leftLift = hardwareMap.get(DcMotor.class, "leftLift");
        rightLift = hardwareMap.get(DcMotor.class, "rightLift");

        leftLift.setDirection(DcMotor.Direction.FORWARD);
        rightLift.setDirection(DcMotor.Direction.REVERSE);

        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public int getLeftLiftCurrentPosition() {

        return leftLift.getCurrentPosition();

    }

    public int getRightLiftCurrentPosition() {

        return rightLift.getCurrentPosition();

    }

    public void liftPos0() {

        leftLift.setTargetPosition(0);
        rightLift.setTargetPosition(0);
        leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftLift.setPower(1.0);
        rightLift.setPower(1.0);

    }

    public void liftPos5000 () {

        leftLift.setTargetPosition(5000);
        rightLift.setTargetPosition(5000);
        leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftLift.setPower(1.0);
        rightLift.setPower(1.0);

    }

}
