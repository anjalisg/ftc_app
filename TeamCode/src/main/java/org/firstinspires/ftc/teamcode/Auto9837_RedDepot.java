package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;



/**
 * Created by Anjali on 9/24/2018.
 */

@Autonomous(name="Vuforia", group ="Concept")
public class Auto9837_RedDepot extends LinearOpMode {

    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix phoneLocation;

    /*License key
    *(register then get license key here https://developer.vuforia.com/targetmanager/licenseManager/licenseListing)
    */
    public static final String VUFORIA_KEY = "AcPpQr7/////AAABmRuQqklau0F7hH15ovElLi8g8xxcFH4hzU6JHV7txfq4WXoLctKsuwc8XqSq/SU10A1VnIUj5HXdhG5Ni8/2X8Z+dWSe4pyn1lwj/Bc7nLV5+6j/8I1wKUrZ6wrjclDvcv+lz/W+TQDnrcLXYOLB8b3/voF9/xd/xTZFi5P2oaA/AOokm2IuadPdTJw1iyEujqs6RJM20C1Kjd9v0FSG07oUlImhPuSV18p/JoP/isRgxQLDxKpGluZbvWZm7yITMciaJ9uPvh7O48UiEzfeOupsFbHIUb0C7DgyzmFTEPwjIuQXbNLZik+IB0upOVabS4Lh572YxBj2rv30Icw99tGVaioIMk2LkoVxI9SH6LdH";

    public float robotX = 0;
    public float robotY = 0;
    public float robotAngle = 0;

    @Override
    public void runOpMode() {

        setupVuforia();
        waitForStart();

        while (opModeIsActive()){

            OpenGLMatrix latestLocation = listener.getUpdatedRobotLocation();   //this method tracks where the robot while Vuforia is tracking the target (otherwise, it returns null)

            if(latestLocation != null){
                lastKnownLocation = latestLocation;
            }

            //Get robot coordinates
            float[] robotCoordinates = lastKnownLocation.getTranslation().getData();

            robotX = robotCoordinates[0];
            robotY = robotCoordinates[1];
            //Third angle = orientation about z axis
            robotAngle = Orientation.getOrientation(lastKnownLocation,AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;

            telemetry.addData("Tracking " + target.getName(), listener.isVisible());
            telemetry.addData("Last known location", formatMatrix(lastKnownLocation));

            telemetry.update();
            idle();

        }
    }

    public String formatMatrix(OpenGLMatrix matrix) {
        return matrix.formatAsTransform();
    }

    public void setupVuforia(){
        //adjust parameters object
        parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId); //Put "R.id.cameraMonitorViewId" in the parameter of the Parameters method if you want camera to display on RC phone
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        //Extended tracking looks at relative movements from camera frames
        //parameters.useExtendedTracking = false;   //Extended tracking tracks an object when it's not in sight, but it's often inaccurate

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //initialize vuforiaLocalizer object using parameters object
        vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters);

        //Tell the visionTargets object what pictures we want it to track
        visionTargets = vuforiaLocalizer.loadTrackablesFromAsset("RoverRuckus");    //.xml file in FTCRobotController >src>main>assets

        //Make vuforia look for all 4 images simultaneously
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        //CHANGE FOR DIFFERENT IMAGE TARGETS
        target = visionTargets.get(0);
        target.setName("Front Perimeter Target Image");
        //CHANGE TARGET LOCATION FOR DIFFERENT TARGETS
        //x,y,z = location (mm); u,v,w refers to rotation (degrees)
        target.setLocation(createMatrix(0,0,0,0,0,0));      //set target at zero for now, fix after testing

        phoneLocation = createMatrix(0,0,0,90,0,0);          //define where on robot phone is located (90 degrees about x-axis)

        listener = (VuforiaTrackableDefaultListener) target.getListener();      //finds robot location on field
        listener.setPhoneInformation(phoneLocation, parameters.cameraDirection);    //find which camera is being used (front or back)
    }

    public OpenGLMatrix createMatrix(float x, float y, float z, float u, float v, float w){ //parameters for position xyz, then rotation uvw
        return OpenGLMatrix
                .translation(x,y,z)
                .multiplied(
                        Orientation.getRotationMatrix(
                                AxesReference.EXTRINSIC,    //Extrinsic = rotations use world's axes, not the object's axes
                                AxesOrder.XYZ,              //order in which object can be rotated
                                AngleUnit.DEGREES,          //set units to degrees
                                u, v, w
                        )
                );
    }
}
