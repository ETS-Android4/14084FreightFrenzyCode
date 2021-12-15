package org.firstinspires.ftc.teamcode;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp

public class RunToPosition_Test extends OpMode {
    HardwareMap robot = new HardwareMap();

    @Override
    public void init() {
        robot.initialize(hardwareMap);

        robot.testMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        robot.testMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.testMotor.setTargetPosition(0);

        robot.testMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.testMotor.setPower(0);

    }

    @Override
    public void loop() {
        armMove();

        robot.testMotor.setPower(0);



    }

    public void armMove() {
        int position = robot.testMotor.getCurrentPosition();

        robot.testMotor.setPower(0);

        if (!robot.spin.isBusy()) {
            if (gamepad1.dpad_down && !(position < -80)) {
                position = position - 40;

            } else if (gamepad1.dpad_up && !(position > 120)) {
                position = position + 40;

            }
            robot.testMotor.setTargetPosition(position);

            robot.testMotor.setPower(.25);

            telemetry.addData("Position", robot.testMotor.getCurrentPosition());
            telemetry.addData("Motor is busy = ", robot.testMotor.isBusy());
            telemetry.update();

        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
