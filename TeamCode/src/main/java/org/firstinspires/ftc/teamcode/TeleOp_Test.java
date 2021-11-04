package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Hardware;

@TeleOp(name="TeleOpTest", group="robot")
@Disabled

public class TeleOp_Test extends OpMode {
    HardwareMap robot = new HardwareMap();

    @Override
    public void init() {
        robot.initialize(hardwareMap);
        telemetry.addData("Status", "Initializing");
        telemetry.update();

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        telemetry.addData("Status", "Start");
        telemetry.update();

    }

    @Override
    public void loop() {
        double frontLeftPower;
        double frontRightPower;
        double backLeftPower;
        double backRightPower;

        frontLeftPower = -gamepad1.left_stick_y;
        frontRightPower = -gamepad1.right_stick_y;
        backLeftPower = -gamepad1.right_stick_y;
        backRightPower = -gamepad1.left_stick_y;

        robot.frontLeftMotor.setPower(frontLeftPower);
        robot.frontRightMotor.setPower(frontRightPower);
        robot.backLeftMotor.setPower(backLeftPower);
        robot.backRightMotor.setPower(backRightPower);

        telemetry.addData("Status", "Driver Controlled");
        telemetry.addData("Info", "Hit Stop to Stop");
        telemetry.update();

    }

    @Override
    public void stop() {

    }

}

