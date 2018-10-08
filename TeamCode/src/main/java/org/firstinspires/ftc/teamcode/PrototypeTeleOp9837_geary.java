package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 10/8/2018.
 */

@TeleOp(name="TeleOp: Geary", group="Pushbot")

public abstract class PrototypeTeleOp9837_geary extends OpMode {
    Hardware9837_geary geary = new Hardware9837_geary();
    public void init(){
        geary.init(hardwareMap);
    }

    @Override
    public void start() {}

    @Override
    public void loop() {
        double leftDrive = gamepad1.left_stick_y;
        double rightDrive = gamepad1.right_stick_y;

        geary.rightFrontMotor.setPower(rightDrive);
        geary.rightBackMotor.setPower(rightDrive);

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop(){
    }
}
