package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp Test", group="robot")
@Disabled

public class TeleOp_Test extends OpMode {
    HardwareMap robot = new HardwareMap();

    double spinDirection;
    private boolean oldLeftBumper;
    private boolean oldRightBumper;


    @Override
    public void init() {
        robot.initialize(hardwareMap);

        robot.clawServo.setPosition(0);

        telemetry.addData("Status", "Initializing");
        telemetry.update();

    }

    @Override
    public void init_loop() {
        //Right bumper is pressed to have motor spin correctly for red side
        //Left bumper is press to have motor spin correctly for blue side
        boolean newLeftBumper = gamepad1.left_bumper;
        boolean newRightBumper = gamepad1.right_bumper;

        spinDirection = -1;

        if (newLeftBumper && !oldLeftBumper) {
            spinDirection = 1;
        } else if (newRightBumper && !oldRightBumper) {
            spinDirection = -1;
        }
        oldLeftBumper = newLeftBumper;
        oldRightBumper = newRightBumper;

        if (spinDirection == -1) {
            telemetry.addData("Spin Direction", "Red Side");
            telemetry.addData("Press GP1 LeftBumper", "to switch to Blue Side");
        } else {
            telemetry.addData("Spin Direction", "Blue Side");
            telemetry.addData("Press GP1 RightBumper", "to switch to Red Side");
        }

        telemetry.addData("Status", "Awaiting User Input");
        telemetry.addData("Action", "Press Play to Start");
        telemetry.update();
    }

    @Override
    public void start() {
        telemetry.addData("Status", "Starting");
        telemetry.update();

    }

    @Override
    public void loop() {
        double frontLeftPower;
        double frontRightPower;
        double backLeftPower;
        double backRightPower;

        double clawPower;
        clawPower = gamepad2.left_stick_y * 0.4;

        double spinPower;
        spinPower = gamepad2.right_trigger * 0.1;

        double liftPower;
        liftPower = gamepad2.right_stick_y * 0.4;


        if(gamepad1.left_bumper) {
            if(gamepad1.right_bumper) {
                frontLeftPower                 = -gamepad1.left_stick_y * .5;
                frontRightPower                = -gamepad1.right_stick_y * .5;
                backLeftPower                  = -gamepad1.left_stick_y * .5;
                backRightPower                 = -gamepad1.right_stick_y * .5;

                telemetry.addData("Drive Mode", "Slow Tank");

            } else {
                frontLeftPower                 = -gamepad1.left_stick_y;
                frontRightPower                = -gamepad1.right_stick_y;
                backLeftPower                  = -gamepad1.left_stick_y;
                backRightPower                 = -gamepad1.right_stick_y;

                telemetry.addData("Drive Mode", "Tank Drive");

            }
        } else if(gamepad1.right_bumper) {
            frontLeftPower                     = -gamepad1.left_stick_y * 0.5;
            frontRightPower                    = -gamepad1.right_stick_y * 0.5;
            backLeftPower                      = -gamepad1.right_stick_y * 0.5;
            backRightPower                     = -gamepad1.left_stick_y * 0.5;

            telemetry.addData("Drive Mode"    , "Sloth Drive");

        } else {
            frontLeftPower                     = -gamepad1.left_stick_y;
            frontRightPower                    = -gamepad1.right_stick_y;
            backLeftPower                      = -gamepad1.right_stick_y;
            backRightPower                     = -gamepad1.left_stick_y;

            telemetry.addData("Drive Mode", "Bean Drive");

        }

        if(gamepad2.dpad_up) {
            //telemetry.addData("Lemon", "true");
            robot.clawServo.setPosition(.55);
        }

        if(gamepad2.dpad_down) {
            //telemetry.addData("Lemon", "false");
            robot.clawServo.setPosition(0);
        }

        robot.frontLeftMotor.setPower(frontLeftPower);
        robot.frontRightMotor.setPower(frontRightPower);
        robot.backLeftMotor.setPower(backLeftPower);
        robot.backRightMotor.setPower(backRightPower);

        robot.clawArm.setPower(clawPower);
        robot.slidePull.setPower(liftPower);

        robot.spin.setPower(spinPower * spinDirection);

        robot.testMotor.setPower(clawPower);

        if (spinDirection == -1) {
            telemetry.addData("Spin Direction", "Red Side");
        } else {
            telemetry.addData("Spin Direction", "Blue Side");
        }

        telemetry.addData("Status", "Driver Controlled");
        telemetry.addData("Action", "Press Stop When Finished");
        telemetry.update();


    }

    //Add PID TUNING https://www.youtube.com/watch?v=FDRWcK-orJs



    @Override
    public void stop() {
        //TODO make sure all variables get set to 0 here so the robot actually stops
        telemetry.addData("Status", "Stopped");
        telemetry.update();
    }

}

