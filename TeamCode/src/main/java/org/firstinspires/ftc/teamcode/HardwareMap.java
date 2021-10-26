package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareMap {
    //Create Motors
    public DcMotor frontRightMotor = null;
    public DcMotor frontLeftMotor  = null;
    public DcMotor backRightMotor  = null;
    public DcMotor backLeftMotor   = null;

    //Create Servo
    public Servo servo1            = null;

    //Additional Variables
    com.qualcomm.robotcore.hardware.HardwareMap hardwareMap = null;
    public ElapsedTime runtime     = new ElapsedTime();

    public HardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hwMap) {
        initialize(hwMap);
    }

    private void initialize(com.qualcomm.robotcore.hardware.HardwareMap hwMap) {
        hardwareMap     = hwMap;

        //Init Motor Info
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        frontLeftMotor  = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backRightMotor  = hardwareMap.get(DcMotor.class, "backRightMotor");
        backLeftMotor   = hardwareMap.get(DcMotor.class, "backLeftMotor");

        //Init Servo Info
        servo1          = hardwareMap.get(Servo.class  , "servo1");

        //Set Motor Direction
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        //Set Motor Mode
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Set Zero Power Behavior
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Set Motor Power to Zero
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);


    }
}
