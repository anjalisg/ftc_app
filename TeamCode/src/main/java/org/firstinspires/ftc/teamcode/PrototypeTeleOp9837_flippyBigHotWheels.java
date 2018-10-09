package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 9/15/2018.
 */
@TeleOp(name="TeleOp: Flippy Big HotWheels", group="Pushbot")

public abstract class PrototypeTeleOp9837_flippyBigHotWheels extends OpMode{
    Hardware9837_flippyBigHotWheels flippyBigHotWheels = new Hardware9837_flippyBigHotWheels();

    public double motorPower_flippers = 0.8;
    public void init (){
        flippyBigHotWheels.init(hardwareMap);
    }

    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double leftDrive = gamepad1.left_stick_y;
        double rightDrive = gamepad1.right_stick_y;

        boolean rightFlipperUp = gamepad1.y;
        boolean rightFlipperDown = gamepad1.a;

        boolean leftFlipperUp = gamepad1.dpad_up;
        boolean leftFlipperDown = gamepad1.dpad_down;

        //driving motors:
        flippyBigHotWheels.rightMotor.setPower(rightDrive);
        flippyBigHotWheels.leftMotor.setPower(leftDrive);

        //flips robot with dpad up/down and 'y' and 'a' keys
        if(rightFlipperUp) flippyBigHotWheels.rightFlipper.setPower(motorPower_flippers);
        else if(rightFlipperDown) flippyBigHotWheels.rightFlipper.setPower(-motorPower_flippers);
        else flippyBigHotWheels.rightFlipper.setPower(0.0);

        if(leftFlipperUp) flippyBigHotWheels.leftFlipper.setPower(motorPower_flippers);
        else if(leftFlipperDown) flippyBigHotWheels.leftFlipper.setPower(-motorPower_flippers);
        else flippyBigHotWheels.leftFlipper.setPower(0.0);

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop(){
    }
}
