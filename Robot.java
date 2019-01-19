/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive DriveTrain;

  private Joystick LeftStick;
  private Joystick RightStick;

  private SpeedControllerGroup LeftDrive;
  private SpeedControllerGroup RightDrive;

  private Talon MotorZero;
  private Talon MotorOne;
  private Talon MotorTwo;
  private Talon MotorThree;



  @Override
  public void robotInit() {
    MotorZero = new Talon(0);
    MotorOne = new Talon(1);
    MotorTwo = new Talon(2);
    MotorThree = new Talon(3);

    LeftDrive = new SpeedControllerGroup(MotorZero, MotorOne);
    RightDrive = new SpeedControllerGroup(MotorTwo, MotorThree);

    DriveTrain = new DifferentialDrive(LeftDrive, RightDrive);
    LeftStick = new Joystick(0);
    RightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    DriveTrain.tankDrive(LeftStick.getY(), RightStick.getY());
  }
}
