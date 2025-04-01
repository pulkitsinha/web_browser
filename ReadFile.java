package web_browser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.	*;

public class ReadFile extends JFrame{
	private JTextField addressbar;
	private JEditorPane display;
	
	//constructor
	public ReadFile(){
		super("Best Browser Ever");
		
		addressbar= new JTextField("Enter the address");
		addressbar.addActionListener(
				new ActionListener(){
						public void actionPerformed(ActionEvent event ){
							//getActionCommand=get string from JTextField
							LoadPage(event.getActionCommand());
						}
				}
				);
		add(addressbar, BorderLayout.NORTH);
		
		display=new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if (event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							LoadPage(event.getURL().toString());	
						}
					}
				}
				);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
		
	}
	//load data on to the screen
	public void LoadPage(String userText){
	try{
		display.setPage(userText);
		addressbar.setText(userText);
	}	
	catch(Exception e){
		System.out.println("Oops something went wrong!!");
		
	}	
	}
	
}



