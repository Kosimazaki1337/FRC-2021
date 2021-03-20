// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.ExampleCommand;
// import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.IntakeClose;
import frc.robot.commands.IntakeOpen;
import frc.robot.commands.IntakeRotate;
import frc.robot.commands.ShooterRotate;
import frc.robot.commands.ShooterStop;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
//   // The robot's subsystems and commands are defined here...
//   private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

//   private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
private final Intake m_intake = new Intake();
private final Shooter m_shooter = new Shooter();

private final IntakeClose m_intakeClose = new IntakeClose(m_intake);
private final IntakeOpen m_intakeOpen = new IntakeOpen(m_intake);
private final IntakeRotate m_intakeRotate = new IntakeRotate(m_intake);
private final ShooterRotate m_shooterRotate = new ShooterRotate(m_shooter);
private final ShooterStop m_shooterStop = new ShooterStop(m_shooter);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Joystick driverJoy = new Joystick(PortMap.kJoystick);
    JoystickButton intakeCloseButton = new JoystickButton(driverJoy, 1);
    JoystickButton intakeOpenButton = new JoystickButton(driverJoy, 2);
    JoystickButton intakeRotateButton = new JoystickButton(driverJoy, 6);
    JoystickButton shooterRotateButton = new JoystickButton(driverJoy, 3);
    JoystickButton shooterStopButton = new JoystickButton(driverJoy, 4);

    intakeCloseButton.whenPressed(new IntakeClose(m_intake));
    intakeOpenButton.whenPressed(new IntakeOpen(m_intake));
    intakeRotateButton.whileHeld(new IntakeRotate(m_intake));
    shooterRotateButton.whenPressed(new ShooterRotate(m_shooter));
    shooterStopButton.whenPressed(new ShooterStop(m_shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
//   public Command getAutonomousCommand() {
//     // An ExampleCommand will run in autonomous
//     return m_autoCommand;
//   }
}
