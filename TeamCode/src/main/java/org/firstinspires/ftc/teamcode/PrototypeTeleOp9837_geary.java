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

        geary.leftMotor.setPower(leftDrive);
        geary.rightMotor.setPower(rightDrive);

    }
    @Override
    public void stop(){
    }
}
