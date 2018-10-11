package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Anjali on 9/15/2018.
 */

public class Hardware9837_geary {

    public DcMotor rightMotor = null;
    public DcMotor leftMotor = null;


    HardwareMap hwMap = null;
    private ElapsedTime period  = new ElapsedTime();

    public Hardware9837_geary(){

    }

    public void init(HardwareMap hardwareMap){
        //set direction of motors facing opposite directions

        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        leftMotor.setDirection(DcMotor.Direction.FORWARD);

        //set pwr to 0

        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);

    }

}


