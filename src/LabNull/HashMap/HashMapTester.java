package LabNull.HashMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * GUI for Hash Map.
 * @author Somsubhra
 *
 */
public class HashMapTester {

	public static void main(String[] args){

		
		final HashMap<String, String> map = new HashMap<String, String>();
		JFrame frame = new JFrame();
		frame.setTitle("Dictionary");
		frame.setSize(1100,100);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		JLabel wordLabel = new JLabel("Word");
		final JTextField wordField = new JTextField(20);
		
		JLabel meaningLabel = new JLabel("Meaning");
		final JTextField meaningField = new JTextField(50);
		JButton add = new JButton("Add");
		JButton get = new JButton("Get");
		JButton show = new JButton("Get All");
		
		
		final JLabel number = new JLabel(map.getSize()+" words in dictionary");
		panel.add(wordLabel);
		panel.add(wordField);
		
		panel.add(meaningLabel);
		panel.add(meaningField);
		
		class AddListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				map.setValue(wordField.getText(), meaningField.getText());
				wordField.setText("");
				meaningField.setText("");
				number.setText(map.getSize()+" words in dictionary");
				
			}
			
		}
		
		class GetListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(map.getValue(wordField.getText())==null){
					meaningField.setText("Word not in dictionary");
				}
				else{
					meaningField.setText(map.getValue(wordField.getText()));
				}
			}
			
		}
		
		class showListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame showFrame = new JFrame();
				showFrame.setTitle("All words in dictionary");
				showFrame.setSize(400,400);
				
				JPanel showPanel = new JPanel();
				
				
				JTextArea showArea = new JTextArea();
				showArea.setEditable(false);
				
				showArea.setText(map.toString());
				
				showPanel.add(showArea);
				showFrame.add(showPanel);
				
				showFrame.setVisible(true);
				
			}
			
		}
		
		add.addActionListener(new AddListener());
		get.addActionListener(new GetListener());
		show.addActionListener(new showListener());
		panel.add(add);
		panel.add(get);
		panel.add(number);
		panel.add(show);
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}
