/***********************************************************
*                                                          *
*  CSCI 470/680      Assignment 5            Summer 2018   *
*                                                          *
*  Programmer: Yiannis Poulos                              *
*              Shaniel Omar Rivas Verdejo                  *
*                                                          *
*  Section:    2                                           *
*                                                          *
*  Date Due:   07/30/2018                                  *
*                                                          *
*  Purpose:    This program provides a Graphical User      *
*              Interface of a list of possible travel      *
*              destinations for a client who wishes        *
*              to redeem their accumulated frequent        *
*              flyer miles.                                *
*                                                          *
***********************************************************/

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.io.*;
import java.util.Scanner;

public class MilesRedeemerFrame extends JFrame
{
  private final JPanel destPanel;
  private final JPanel redeemPanel;
  private final JList<String> destList;
  
  private final JLabel normalMilesLabel,
                       saverMilesLabel,
                       upgradeMilesLabel,
                       saverDatesLabel,
                       inputMilesLabel,
                       inputMonthLabel,
                       remainingMilesLabel;
  
  private final JTextField normalMilesField,
                           saverMilesField,
                           upgradeMilesField,
                           saverDatesField,
                           inputMilesField,
                           remainingMilesField;
  
  private final JSpinner monthSpinner;
  private final JTextArea redeemTextArea;
  private final JButton redeemButton;
  
  String[] months = {"", "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"};
  
  SpinnerListModel lm = new SpinnerListModel(months);
  
  Color lightBlue = new Color(145, 255, 255);
  Color tan = new Color(255, 241, 193);
  
  Border blackLine = BorderFactory.createLineBorder(Color.black);
  Dimension d1 = new Dimension(325,500);
  Dimension d2 = new Dimension(350,500);
  
  GridBagConstraints gbc = new GridBagConstraints();
  
  MilesRedeemer miles = new MilesRedeemer();
  
  //prompt user for name of the file
  String filename = JOptionPane.showInputDialog("Enter the name of the file:");
  File file = new File(filename);
  Scanner fileScanner = new Scanner(file);
    
  public MilesRedeemerFrame() throws IOException
  {
    super("Miles Redeemer App");
    setLayout(new FlowLayout());
    
    miles.readDestinations(fileScanner);   //read file for list of destinations
    
    //create Destination Panel
    destPanel = new JPanel(new GridBagLayout());
    destPanel.setBorder(BorderFactory.createTitledBorder(blackLine, "Destinations"));
    destPanel.setPreferredSize(d1);
    destPanel.setBackground(lightBlue);
    add(destPanel);
    
    //create Redeem Miles panel
    redeemPanel = new JPanel(new GridBagLayout());
    redeemPanel.setBorder(BorderFactory.createTitledBorder(blackLine, "Redeem Miles"));
    redeemPanel.setPreferredSize(d2);
    redeemPanel.setBackground(tan);
    add(redeemPanel);
    
    //create List of destinations
    destList = new JList<String>(miles.getCityNames());  //fill list with city names
    destList.setVisibleRowCount(11);
    destList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    gbc.gridx = 0;
    gbc.gridy = 0; 
    gbc.fill = GridBagConstraints.HORIZONTAL;
    destPanel.add(destList, gbc);
    
    //implement list selection listener
    destList.addListSelectionListener(
      new ListSelectionListener()
      {
        //handle list selection event
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
          
          Destination d = miles.findDestination(miles.getCityNames()[destList.getSelectedIndex()]);
          
          normalMilesField.setText(Integer.toString(d.getNormalMiles()));
          saverMilesField.setText(Integer.toString(d.getCheapMiles()));
          upgradeMilesField.setText(Integer.toString(d.getUpgradeMiles()));
          saverDatesField.setText(months[d.getStartMonth()] + " - " + months[d.getEndMonth()]);
        }
      }
    );
    
    //Create labels and text fields for destination info
    normalMilesLabel = new JLabel("Normal miles:      "); 
    gbc.gridx = 0;
    gbc.gridy = 11;
    destPanel.add(normalMilesLabel, gbc);
    
    normalMilesField = new JTextField(15);
    normalMilesField.setEditable(false);
    gbc.gridx = 1;
    gbc.gridy = 11;
    destPanel.add(normalMilesField, gbc);
    
    saverMilesLabel = new JLabel("Supersaver miles:  ");
    gbc.gridx = 0;
    gbc.gridy = 12;
    destPanel.add(saverMilesLabel, gbc);
    
    saverMilesField = new JTextField(15);    
    saverMilesField.setEditable(false);
    gbc.gridx = 1;
    gbc.gridy = 12;
    destPanel.add(saverMilesField, gbc);
    
    upgradeMilesLabel = new JLabel("Upgrade cost:      ");
    gbc.gridx = 0;
    gbc.gridy = 13;
    destPanel.add(upgradeMilesLabel, gbc);
    
    upgradeMilesField = new JTextField(15);    
    upgradeMilesField.setEditable(false);
    gbc.gridx = 1;
    gbc.gridy = 13;
    destPanel.add(upgradeMilesField, gbc);
    
    saverDatesLabel = new JLabel("Supersaver Dates:  ");
    gbc.gridx = 0;
    gbc.gridy = 14;
    destPanel.add(saverDatesLabel, gbc);
    
    saverDatesField = new JTextField(15);    
    saverDatesField.setEditable(false);
    gbc.gridx = 1;
    gbc.gridy = 14;
    destPanel.add(saverDatesField, gbc);
    
    inputMilesLabel = new JLabel("Enter your miles:         ");
    gbc.gridx = 0;
    gbc.gridy = 0;
    redeemPanel.add(inputMilesLabel, gbc);
    
    //TextField for user to input accumulated miles
    inputMilesField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 0;
    redeemPanel.add(inputMilesField, gbc);
    
    inputMonthLabel = new JLabel("Select month of departure:");
    gbc.gridx = 0;
    gbc.gridy = 1;
    redeemPanel.add(inputMonthLabel, gbc);
    
    //Spinner to select month of departure
    monthSpinner = new JSpinner(lm);
    gbc.gridx = 1;
    gbc.gridy = 1;
    redeemPanel.add(monthSpinner, gbc); 
    
    //Textarea to display all possible destinations
    redeemTextArea = new JTextArea(15, 10);
    redeemTextArea.setEditable(false);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    redeemPanel.add(redeemTextArea, gbc);
    
    remainingMilesLabel = new JLabel("Your remaining miles: ");
    gbc.gridx = 0;
    gbc.gridy = 4;
    redeemPanel.add(remainingMilesLabel, gbc);
    
    //Textfield to display user's remaining miles after redeeming
    remainingMilesField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 4;
    remainingMilesField.setEditable(false);
    redeemPanel.add(remainingMilesField, gbc);
    
    //implement Redeem Miles button
    redeemButton = new JButton("Redeem Miles");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    redeemPanel.add(redeemButton, gbc);
    
    //implement Action Listener for Redeem Miles button
    redeemButton.addActionListener(
      new ActionListener()
      {
        @Override
        public void actionPerformed(ActionEvent e)
        {           
          redeemTextArea.setText("");
          
          int userMiles = Integer.parseInt(inputMilesField.getText());
          String monthName = (String)monthSpinner.getValue();
          int departMonth = 0;
          
          //Assign month name to corresponding number
          if (monthName.equals("January"))
            departMonth = 1;
          
          else if (monthName.equals("February"))
            departMonth = 2;
          
          else if (monthName.equals("March"))
            departMonth = 3;    
                   
          else if (monthName.equals("April"))
            departMonth = 4;
           
          else if (monthName.equals("May"))
            departMonth = 5;
                   
          else if (monthName.equals("June"))
            departMonth = 6;
                   
          else if (monthName.equals("July"))
            departMonth = 7;
          
          else if (monthName.equals("August"))
            departMonth = 8;
                   
          else if (monthName.equals("September"))
            departMonth = 9; 
                   
          else if (monthName.equals("October"))
            departMonth = 10; 
                   
          else if (monthName.equals("November"))
            departMonth = 11; 
                   
          else if (monthName.equals("December"))
            departMonth = 12;
                   
          //display all possible destinations in Textarea
          for (String tickets : miles.redeemMiles(userMiles, departMonth))
          {
            redeemTextArea.append("* A trip to " + tickets + " in Economy class\n");
          }
          
          //Notify user if they don't have enough accumulated miles
          if (miles.redeemMiles(userMiles, departMonth).length == 0)
            redeemTextArea.append("Your client has not accumulated enough Frequent Flyer Miles");
          
          remainingMilesField.setText(Integer.toString(miles.getRemainingMiles()));
        }
      }
    );
  }

  /**********************************************************************************
  *         getDestinationList(): returns list of destinations                      *      
  **********************************************************************************/
  public JList<String> getDestinationList()
  {
    return destList;
  }
}
