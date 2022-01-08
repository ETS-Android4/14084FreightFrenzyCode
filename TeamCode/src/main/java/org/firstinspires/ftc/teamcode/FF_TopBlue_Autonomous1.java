package org.firstinspires.ftc.teamcode;

//import statements added automatically

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "Top Blue Autonomous" , group = "robot", preselectTeleOp = "TeleOp_Test.java")
public class FF_TopBlue_Autonomous1 extends LinearOpMode {
    //Define all variables
    HardwareMap robot = new HardwareMap();

    boolean continueLoop = true;

    @Override
    //Run Op Mode loop
    public void runOpMode() {
        //Initialize Robot
        robot.initialize(hardwareMap);




        //Add Telemetry text to Driver Station Screen
        telemetry.addData("Status","Initialized");
        telemetry.addData("Action", "Press Play to Start");
        telemetry.update();

        //Wait for user to push start
        waitForStart();

        //Run Autonomous code


    }

    //Add any other necessary loops here i.e. IMU init, vuforia init, etc.

}
