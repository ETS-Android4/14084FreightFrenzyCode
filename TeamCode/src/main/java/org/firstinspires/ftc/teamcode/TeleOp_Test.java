package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Hardware;

@TeleOp(name="TeleOp Test", group="robot")

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
        telemetry.addData("Right Bumper", gamepad1.right_bumper);
        telemetry.update();
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

        double clawPower;
        clawPower = gamepad2.left_stick_y * 0.1;


        if(gamepad1.left_bumper) {
            if(gamepad1.right_bumper) {
                frontLeftPower = -gamepad1.left_stick_y * .5;
                frontRightPower = -gamepad1.right_stick_y * .5;
                backLeftPower = -gamepad1.left_stick_y * .5;
                backRightPower = -gamepad1.right_stick_y * .5;

                telemetry.addData("Mode", "Slow Tank");
            } else {
                frontLeftPower = -gamepad1.left_stick_y;
                frontRightPower = -gamepad1.right_stick_y;
                backLeftPower = -gamepad1.left_stick_y;
                backRightPower = -gamepad1.right_stick_y;

                telemetry.addData("Mode", "Tank Drive");
            }
        } else if(gamepad1.right_bumper) {
            frontLeftPower = -gamepad1.left_stick_y * 0.5;
            frontRightPower = -gamepad1.right_stick_y * 0.5;
            backLeftPower = -gamepad1.right_stick_y * 0.5;
            backRightPower = -gamepad1.left_stick_y * 0.5;

            telemetry.addData("Mode", "Sloth Drive");
        } else {
            frontLeftPower = -gamepad1.left_stick_y;
            frontRightPower = -gamepad1.right_stick_y;
            backLeftPower = -gamepad1.right_stick_y;
            backRightPower = -gamepad1.left_stick_y;

            telemetry.addData("Mode", "Bean Drive");
        }

        if(gamepad2.a) {
            telemetry.addData("Lemon", "true");
            if(gamepad2.b) {
                telemetry.addData("Extra Lemon", "");
            }
        } else {
            telemetry.addData("Lemon", "false");
        }

        robot.frontLeftMotor.setPower(frontLeftPower);
        robot.frontRightMotor.setPower(frontRightPower);
        robot.backLeftMotor.setPower(backLeftPower);
        robot.backRightMotor.setPower(backRightPower);

        robot.clawArm.setPower(clawPower);

        telemetry.addData("Status", "Driver Controlled");
        telemetry.addData("Info", "Hit Stop to Stop");
        telemetry.update();


    }

    @Override
    public void stop() {

    }

}

