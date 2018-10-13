package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 10/8/2018.
 */

@TeleOp(name="TeleOp: Geary", group="Linear Opmode")

public class PrototypeTeleOp9837_geary extends LinearOpMode {
    Hardware9837_geary geary = new Hardware9837_geary();

    @Override
    public void runOpMode() {
        waitForStart();

        while (opModeIsActive()) {
            double leftDrive = gamepad1.left_stick_y;
            double rightDrive = gamepad1.right_stick_y;

            geary.leftMotor.setPower(leftDrive);
            geary.rightMotor.setPower(rightDrive);

        }
    }

}
