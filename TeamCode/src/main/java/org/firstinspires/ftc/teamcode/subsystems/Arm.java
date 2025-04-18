package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Arm {

    DcMotor arm;

    public Arm(HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "Arm");

        arm.setDirection(DcMotor.Direction.FORWARD);

        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public int getArmCurrentPosition() {

        return arm.getCurrentPosition();

    }

    public void armPos1000() {

        arm.setTargetPosition(1000);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(1.0);

    }

    public void armPos2000() {

        arm.setTargetPosition(2000);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(1.0);

    }

    public void armBusyZeroPower() {

        if (!arm.isBusy()) {
            arm.setPower(0);
        }

    }

}
