package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Anjali on 9/15/2018.
 */

public abstract class PrototypeTeleOp9837 extends OpMode{
    Hardware9837 bot = new Hardware9837();

    public void init (){
        bot.init(hardwareMap);
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

        bot.leftFrontMotor.setPower(leftDrive);
        bot.leftBackMotor.setPower(leftDrive);
        bot.rightFrontMotor.setPower(rightDrive);
        bot.rightBackMotor.setPower(rightDrive);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop(){
    }
}
