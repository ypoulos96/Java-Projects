/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 5       Summer 2018  *                        
 *                                                          *
 *  Programmer:  Yiannis Poulos                             *  
 *               Shaniel Omar Rivas Verdejo                 *
 *                                                          * 
 *                                                          *   
 *  Date Due:    July 25, 2018                              *                          
 *                                                          *
 ************************************************************/ 

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class EventsFrame extends JFrame
{
  private final JTextArea textArea;
  private final JComboBox<String> animalBox;
  private final JRadioButton radioButton;
  private final JList<String> animalList;
  private final JButton clearButton;
  
  private static final String[] animalNames = 
      {"Elephant", "Rhinoceros", "Lion", "Hippopotamus"};
  
  public EventsFrame()
  {
    super("Events");
    setLayout(new FlowLayout());
    
    //set up text area
    textArea = new JTextArea(10, 39);
    textArea.setEditable(false);
    add(textArea);
    add(new JScrollPane(textArea));
    
    //implement combo box
    animalBox = new JComboBox<String>(animalNames);
    animalBox.setMaximumRowCount(4);
    add(animalBox);
    
    animalBox.addItemListener (
      new ItemListener()
      {
        //handle combo box events
        @Override 
        public void itemStateChanged(ItemEvent event)
        {
          if (event.getStateChange() == ItemEvent.SELECTED)
          textArea.append(animalNames[animalBox.getSelectedIndex()] + " has been selected from Combo Box.\n");
        }  
      }
    );
    
    //implement radio button
    radioButton = new JRadioButton();
    radioButton.setText("Select me");
    add(radioButton);
    
    radioButton.addItemListener (
      new ItemListener()
      {
        //handle radio button event
        @Override
        public void itemStateChanged(ItemEvent event)
        {
          if (radioButton.isSelected())
            textArea.append("Radio Button has been selected.\n");
              
          else if (!radioButton.isSelected())
            textArea.append("Radio Button has been unselected.\n");
        }
      }
    );    
    
    //implement list
    animalList = new JList<String>(animalNames);
    animalList.setVisibleRowCount(4);
    animalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    add(animalList);
    
    animalList.addListSelectionListener(
      new ListSelectionListener()
      {
        //handle list selection event
        @Override
        public void valueChanged(ListSelectionEvent event)
        {
          textArea.append(animalNames[animalList.getSelectedIndex()] + " has been selected from List.\n");
        }                                      
      } 
    );
    
    //implement clear button
    clearButton = new JButton("Clear");
    add(clearButton);
    
    clearButton.addActionListener(
      new ActionListener()
      {
        //handle button event
        @Override
        public void actionPerformed(ActionEvent event)
        {
          textArea.setText("");
        }
      }   
    );  
  }
}
    
    
    
    