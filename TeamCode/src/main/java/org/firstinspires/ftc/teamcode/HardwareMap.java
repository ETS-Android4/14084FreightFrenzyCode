package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareMap {
    //Create Motors
    public DcMotor frontRightMotor = null;
    public DcMotor frontLeftMotor  = null;
    public DcMotor backRightMotor  = null;
    public DcMotor backLeftMotor   = null;
    public DcMotor clawArm         = null;
    public DcMotor spin            = null;

    //Create Servo
    public Servo clawServo         = null;

    //Additional Variables
    com.qualcomm.robotcore.hardware.HardwareMap hardwareMap = null;
    public ElapsedTime runtime     = new ElapsedTime();

    public HardwareMap() {

    }

    public void initialize(com.qualcomm.robotcore.hardware.HardwareMap hwMap) {
        hardwareMap     = hwMap;

        //Init Motor Info
        frontRightMotor = hardwareMap.get(DcMotor.class, "FrontRightDrive");
        frontLeftMotor  = hardwareMap.get(DcMotor.class, "FrontLeftDrive");
        backRightMotor  = hardwareMap.get(DcMotor.class, "BackRightDrive");
        backLeftMotor   = hardwareMap.get(DcMotor.class, "BackLeftDrive");

        clawArm         = hardwareMap.get(DcMotor.class, "ClawArm");

        spin            = hardwareMap.get(DcMotor.class, "Spin");

        //Init Servo Info
        clawServo       = hardwareMap.get(Servo.class  , "Claw");

        //Set Motor Direction
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        clawArm.setDirection(DcMotor.Direction.FORWARD);

        spin.setDirection(DcMotor.Direction.FORWARD);


        //Set Motor Mode
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        clawArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        spin.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Set Zero Power Behavior
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        clawArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        spin.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        //Set Motor Power to Zero
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);

        clawArm.setPower(0);

        spin.setPower(0);


    }
}
