
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/*
* This OpMode was written for the TeleOp Basics video. This demonstrates basic principles of
* controlling motors and servos with gamepads.
*/


@TeleOp(name = "TeleOp Tutorial", group = "Tutorials")
public class BasicTeleOP extends LinearOpMode


{

   // Declare drive motors

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorLift;

    // Declare arm servo

    private Servo LeftarmServo;
    private Servo RightarmServo;

    // Constants for moving arm
    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_POSITION = 0.8;


    @Override
   public void runOpMode() throws InterruptedException
    {


        // Initialize drive motors
        motorLeft = hardwareMap.dcMotor.get("left_drive");
        motorRight = hardwareMap.dcMotor.get("right_drive");
        motorLift = hardwareMap.dcMotor.get("lift_drive");

        // If drive motors are given full power, robot would spin because of the motors being in
        // opposite directions. So reverse one

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        // Initialize arm servo
        LeftarmServo = hardwareMap.servo.get("left_lift");
        RightarmServo = hardwareMap.servo.get("right_lift");


        // Retract arm servo to stay within 18"


        LeftarmServo.setPosition(ARM_RETRACTED_POSITION);
        RightarmServo.setPosition(ARM_RETRACTED_POSITION);


        // Wait until start button is pressed

        waitForStart();

        // Repeatedly run code in here until stop button is pressed

        while(opModeIsActive())
        {


            // Tank drive
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);
            motorLift.setPower(-gamepad1.right_stick_y);

           // Move the arm servo if requested
            if(gamepad2.a)

            {
                LeftarmServo.setPosition(ARM_EXTENDED_POSITION);


            }


            if(gamepad2.b)


            {


                LeftarmServo.setPosition(ARM_RETRACTED_POSITION);


            }


            // Give hardware a chance to catch up

            idle();
        }


    }


}
