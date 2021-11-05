package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Autonomous Test" , group = "robot")

public class Autonomous_Test extends LinearOpMode {
    HardwareMap robot           = new HardwareMap();
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime timer   = new ElapsedTime();

    static final double driveSpeed = 0.6;
    static final double turnSpeed  = 0.5;


    @Override
    public void runOpMode() {
        robot.initialize(hardwareMap);
        telemetry.addData("Status","Initialized");
        telemetry.addData("Action", "Press Play to Start");
        telemetry.update();

        waitForStart();

        runtime.reset();
        timer.reset();

        while (opModeIsActive() && (timer.milliseconds() < 3000)) {
            telemetry.addData("Timer", timer.milliseconds());
            telemetry.update();


        }


    }
}
