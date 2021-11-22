package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="PID Coeff Tuner", group="robot")

public class PID_Coeff_Tuner extends OpMode {

    HardwareMap robot = new HardwareMap();

    public static PIDCoefficients pidCoeffs = new PIDCoefficients(0,0,0);
    public PIDCoefficients pidGains = new PIDCoefficients(0,0,0);

    ElapsedTime PIDTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    @Override
    public void init() {
        robot.initialize(hardwareMap);
    }

    @Override
    public void loop() {
        double speed = gamepad2.left_stick_y * 0.4;
        telemetry.addData("Speed", speed);
        PID(speed);

        //Increment Percent
        if(gamepad1.a) {
            pidCoeffs.p = pidCoeffs.p + 0.1;

        }
        //Decrement Percent
        if(gamepad1.b) {
            pidCoeffs.p = pidCoeffs.p - 0.1;

        }
        //Increment Integral
        if(gamepad1.x) {
            pidCoeffs.i = pidCoeffs.i + 0.1;

        }
        //Decrement Integral
        if(gamepad1.y) {
            pidCoeffs.i = pidCoeffs.i - 0.1;

        }
        //Increment Derivative
        if(gamepad1.dpad_up) {
            pidCoeffs.d = pidCoeffs.d + 0.1;

        }
        //Decrement Derivative
        if(gamepad1.dpad_down) {
            pidCoeffs.d = pidCoeffs.d - 0.1;

        }

        telemetry.addData("P Coeff", pidCoeffs.p);
        telemetry.addData("I Coeff", pidCoeffs.i);
        telemetry.addData("D Coeff", pidCoeffs.d);

        telemetry.addData("P Gain", pidGains.p);
        telemetry.addData("I Gain", pidGains.i);
        telemetry.addData("D Gain", pidGains.d);


    }

    double integral = 0;
    double lastError = 0;

    public void PID(double targetVelocity) {

        PIDTimer.reset();

        double currentVelocity = robot.clawArm.getVelocity();

        double error = targetVelocity - currentVelocity;

        integral += error + PIDTimer.time();

        double deltaError = error - lastError;
        double derivative = deltaError / PIDTimer.time();

        pidGains.p = pidCoeffs.p * error;
        pidGains.i = pidCoeffs.i * integral;
        pidGains.d = pidCoeffs.d * derivative;
        robot.clawArm.setVelocity(pidGains.p + pidGains.i + pidGains.d + targetVelocity);


    }
}
