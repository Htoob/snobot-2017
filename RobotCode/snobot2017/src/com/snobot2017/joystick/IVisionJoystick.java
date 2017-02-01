package com.snobot2017.joystick;

import com.snobot.lib.ISubsystem;

/**
 * Joystick for interacting with the vision app
 * 
 * @author jbnol
 *
 */
public interface IVisionJoystick extends ISubsystem
{
    /**
     * @return true if App View should be changed
     */
    boolean iterateAppView();

    /**
     * Button to switch the app to use the front camera
     * 
     * @return True if the camera should be switched to the front
     */
    boolean switchToFrontCamera();

    /**
     * Button to switch the app to use the back camera
     * 
     * @return True if the camera should be switched to the back
     */
    boolean switchToRearCamera();

    /**
     * Button to restart the app
     * 
     * @return True if the app should be reset
     */
    boolean restartApp();
}
