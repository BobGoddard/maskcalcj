/*
 *      This program is free software; you can redistribute it and/or
 *      modify it under the terms of the GNU General Public License
 *      as published by the Free Software Foundation, version 2 of
 *      the License.
 *
 *      Bob Goddard Computing Ltd. does not admit liability nor provide
 *      warranty for any of this software. This material is provided
 *      "AS-IS" and at no charge.
 */

/**
 * Title: MaskCalc
 * Description: Network mask calculator
 * Copyright: Copyright (c) 2002, 2003, 2004, 2005, 2006
 * Company: Bob Goddard Computing Ltd.
 * @author Bob Goddard
 * @version 1.0
 */


package maskcalc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AboutBox extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private String product = "maskcalc";
	private String version = "1.0";
	private String copyright = "Copyright Bob Goddard Computing Ltd. (c) 2002,3,4,5,6";
	private String comments = "Network mask calculator";
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton jButton = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private GridLayout gridLayout = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	/**
	 * This is the default constructor
	 */
	public AboutBox(Frame parent) {
		super();
		try {
			initialize();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	    pack();

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() throws Exception {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.setSize(400, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("About");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.add(getJPanel2(), java.awt.BorderLayout.WEST);
			jPanel.add(getJPanel3(), java.awt.BorderLayout.CENTER);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.add(getJButton(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton("Ok");
			jButton.addActionListener(this);
		}
		return jButton;
	}

	//Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			cancel();
		}
		super.processWindowEvent(e);
	}

	//Close the dialog
	void cancel() {
		dispose();
	}

	//Close the dialog on a button event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButton) {
			cancel();
		}
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(getGridLayout());
			jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 60, 10, 10));
			jPanel3.add(getLabel1());
			jPanel3.add(getLabel2());
			jPanel3.add(getLabel3());
			jPanel3.add(getLabel4());
		}
		return jPanel3;
	}


	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private GridLayout getGridLayout() {
		if (gridLayout == null) {
			gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setColumns(1);
		}
		return gridLayout;
	}


	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel
	 */
	private JLabel getLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText(product);
		}
		return jLabel1;
	}
	
	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel
	 */
	private JLabel getLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText(version);
		}
		return jLabel2;
	}
	
	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel
	 */
	private JLabel getLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText(copyright);
		}
		return jLabel3;
	}
	
	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel
	 */
	private JLabel getLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText(comments);
		}
		return jLabel4;
	}
}
