package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 9/15/2018.
 */
@TeleOp(name="TeleOp: Flippy Big HotWheels", group="Pushbot")

public abstract class PrototypeTeleOp9837_flippyBigHotWheels extends OpMode{
    Hardware9837_flippyBigHotWheels flippyBigHotWheels = new Hardware9837_flippyBigHotWheels();

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

        double flipperUp = gamepad1.right_trigger;
        double flipperDown = gamepad1.left_trigger;

        flippyBigHotWheels.rightFrontMotor.setPower(rightDrive);
        flippyBigHotWheels.rightBackMotor.setPower(rightDrive);
        flippyBigHotWheels.flipper.setPower(flipperUp);
        flippyBigHotWheels.flipper.setPower(-flipperDown);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop(){
    }
}
