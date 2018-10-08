package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Anjali on 9/15/2018.
 */

public class Hardware9837_flippyBigHotWheels {

    public DcMotor rightFrontMotor = null;
    public DcMotor rightBackMotor = null;
    public DcMotor flipper = null;

    HardwareMap hwMap = null;
    private ElapsedTime period  = new ElapsedTime();

    public Hardware9837_flippyBigHotWheels(){

    }

    public void init(HardwareMap hardwareMap){
        //set direction of motors facing opposite directions

        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);

        //set pwr to 0

        rightFrontMotor.setPower(0.0);
        rightBackMotor.setPower(0.0);

        flipper.setPower(0.0);
    }

}


