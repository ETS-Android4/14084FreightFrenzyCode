package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class RunToPosition_Test extends OpMode {
    HardwareMap robot = new HardwareMap();

    @Override
    public void init() {
        robot.initialize(hardwareMap);
        robot.clawArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.clawArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.clawArm.setTargetPosition(0);
        robot.clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.clawArm.setPower(.5);
    }

    @Override
    public void loop() {
       armMove();


    }

    public void armMove() {
        if (gamepad2.dpad_up) {
            robot.clawArm.setTargetPosition(robot.clawArm.getCurrentPosition() +200);
        } else if (gamepad2.dpad_down) {
            robot.clawArm.setTargetPosition(robot.clawArm.getCurrentPosition() -200);
        } else {
            robot.clawArm.setTargetPosition(robot.clawArm.getCurrentPosition());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
