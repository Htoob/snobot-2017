package com.snobot2017.autonomous.commands;

import com.snobot2017.SnobotActor.ISnobotActor;
import com.snobot2017.autonomous.AutonomousFactory.StartingPositions;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns a fixed number of degrees based on the starting position. To be used in
 * conjunction with DriveStraightPathWithGyroFromStartingPosition so that you
 * can go to a peg from a starting position.
 * 
 * @author Team174
 *
 */
public class TurnToPegAfterPathFromStartingPosition extends Command
{
    private ISnobotActor mSnobotActor;
    private boolean mFinished;
    private double mTurnAngle;
    private double mSpeed;
    private StartingPositions mStartPosition;

    /**
     * Constructor
     * 
     * @param aSpeed
     *            The speed to drive
     * @param aTurnAngle
     * @param aDriveTrain
     * @param aPositioner
     */
    public TurnToPegAfterPathFromStartingPosition(double aSpeed, StartingPositions aStartPosition, ISnobotActor aSnobotActor, double aRedLeft,
            double aRedRight, double aRedMiddle, double aBlueLeft, double aBlueRight, double aBlueMiddle)
    {
        mSnobotActor = aSnobotActor;

        switch (aStartPosition)
        {
        case RedLeft:
            mTurnAngle = aRedLeft;
            break;
        case RedRight:
            mTurnAngle = aRedRight;
            break;
        case BlueRight:
            mTurnAngle = aBlueRight;
            break;
        case BlueLeft:
            mTurnAngle = aBlueLeft;
            break;
        case RedMiddle:
            mTurnAngle = aRedMiddle;
            break;
        case BlueMiddle:
            mTurnAngle = aBlueMiddle;
            break;
        case Origin:
        default:
            mTurnAngle = 0;
            break;
        }

        mSnobotActor.setTurnGoal(mTurnAngle, aSpeed);
        mSpeed = aSpeed;
        mStartPosition = aStartPosition;
        mFinished = false;
    }

    @Override
    protected void initialize()
    {
        System.out.println("TurnWithDegrees: " + mStartPosition + ", " + mSpeed + ", " + mTurnAngle);
    }

    @Override
    protected void execute()
    {
        mFinished = mSnobotActor.executeControlMode();
    }

    @Override
    protected boolean isFinished()
    {
        return mFinished;
    }

    @Override
    protected void end()
    {
        System.out.println("TurnWithDegrees: END");
    }
}