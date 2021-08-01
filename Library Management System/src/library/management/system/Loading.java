/*

	This java file is responsible for displaying 
	a progessbar before loading the Home page.

*/

package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable{
	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection connection;
	Thread thread;
	
	public static void main(String[] args) {
		new Loading().setVisible(true);
	}
	
	// This method is responsible for starting thread
	public void setUploading() {
		thread.start();
	}
	// Method for increament value of the progressBar 
	public void run() {
		try {
			for(int i = 0; i < 100; i++) {
				progressBar.setValue(i+1);
				Thread.sleep(30);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			new Home().setVisible(true);
			setVisible(false);
		}
	}
	public Loading() {
		super("Loading - Library Management System");
		thread = new Thread((Runnable)this);
		setBounds(420, 260, 600, 280);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel libraryManagement = new JLabel("Library Management System");
		libraryManagement.setForeground(new Color(0, 88, 133));
		libraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		libraryManagement.setBounds(96, 46, 500, 35);
		contentPane.add(libraryManagement);
		
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(0, 88, 133));
		progressBar.setFont(new Font("Tohama", Font.BOLD, 12));
		progressBar.setBounds(130, 135, 300, 25);
		contentPane.add(progressBar);
		
		JLabel waitLabel = new JLabel("Please Wait....");
		waitLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		waitLabel.setForeground(new Color(0, 88, 133));
		waitLabel.setBounds(200, 165, 150, 20);
		contentPane.add(waitLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBounds(0, 0, 590, 390);
		contentPane.add(panel);
		
		setUploading();	// Invoking setUploading method
	}
}
