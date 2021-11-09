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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;

public class maskcalc extends JFrame {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu fileMenu = null;

	private JMenu helpMenu = null;

	private JMenuItem exitMenuItem = null;

	private JMenuItem aboutMenuItem = null;

	private GridLayout gridLayout = null;

	private ButtonGroup buttonGroup = new ButtonGroup();

	private long MaskRight;

	private long MaskLeft;

	private JSpinner spinnerOct4 = null;

	private JSpinner spinnerOct3 = null;

	private JSpinner spinnerOct2 = null;

	private JSpinner spinnerOct1 = null;

	private JSpinner spinnerMask = null;

	private SpinnerNumberModel spinnerMOct4 = null;

	private SpinnerNumberModel spinnerMOct3 = null;

	private SpinnerNumberModel spinnerMOct2 = null;

	private SpinnerNumberModel spinnerMOct1 = null;

	private SpinnerNumberModel spinnerMMask = null;

	/*
	 * Row 1
	 */
	private JPanel panelOct4 = null;

	private JPanel panelOct3 = null;

	private JPanel panelOct2 = null;

	private JPanel panelOct1 = null;

	private JPanel panelMask = null;

	/*
	 * Row 2
	 */
	private JPanel panelOct1_8 = null;

	private JPanel panelOct9_16 = null;

	private JPanel panelOct17_24 = null;

	private JPanel panelOct25_32 = null;

	private JPanel panelOctNull = null;

	/*
	 * Row 3
	 */
	private JPanel panelI4 = null;

	private JPanel panelI3 = null;

	private JPanel panelI2 = null;

	private JPanel panelI1 = null;

	/*
	 * Row 4
	 */
	private JPanel panelA4 = null;

	private JPanel panelA3 = null;

	private JPanel panelA2 = null;

	private JPanel panelA1 = null;

	/*
	 * Row 5
	 */
	private JPanel panelB4 = null;

	private JPanel panelB3 = null;

	private JPanel panelB2 = null;

	private JPanel panelB1 = null;

	/*
	 * Row 6
	 */
	private JPanel panelC4 = null;

	private JPanel panelC3 = null;

	private JPanel panelC2 = null;

	private JPanel panelC1 = null;

	/*
	 * Row 7
	 */
	private JPanel panelD4 = null;

	private JPanel panelD3 = null;

	private JPanel panelD2 = null;

	private JPanel panelD1 = null;

	private JRadioButton BinButton = null;

	private JRadioButton OctButton = null;

	private JRadioButton DecButton = null;

	private JRadioButton HexButton = null;

	private JLabel labelAddr = null;

	private JLabel labelNet = null;

	private JLabel labelBcast = null;

	private JLabel labelWild = null;

	private JLabel labelSub = null;

	private JLabel labelhe = null;

	private FNumber FNumberI4;

	private FNumber FNumberI3;

	private FNumber FNumberI2;

	private FNumber FNumberI1;

	private FNumber FNumberA4;

	private FNumber FNumberA3;

	private FNumber FNumberA2;

	private FNumber FNumberA1;

	private FNumber FNumberB4;

	private FNumber FNumberB3;

	private FNumber FNumberB2;

	private FNumber FNumberB1;

	private FNumber FNumberC4;

	private FNumber FNumberC3;

	private FNumber FNumberC2;

	private FNumber FNumberC1;

	private FNumber FNumberD4;

	private FNumber FNumberD3;

	private FNumber FNumberD2;

	private FNumber FNumberD1;

	private JMenuItem licenseMenu = null;

	public maskcalc() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getLicenseMenu() {
		if (licenseMenu == null) {
			licenseMenu = new JMenuItem();
			licenseMenu.setText("License");
			licenseMenu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jMenuHelpLicense_actionPerformed(e);
				}
			});
		}
		return licenseMenu;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maskcalc application = new maskcalc();
		application.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJJMenuBar());
		this.setSize(560, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("Network Mask Calculator");

		FNumberA4.setMode(DisplayMode.DEC);
		FNumberA3.setMode(DisplayMode.DEC);
		FNumberA2.setMode(DisplayMode.DEC);
		FNumberA1.setMode(DisplayMode.DEC);
		FNumberB4.setMode(DisplayMode.DEC);
		FNumberB3.setMode(DisplayMode.DEC);
		FNumberB2.setMode(DisplayMode.DEC);
		FNumberB1.setMode(DisplayMode.DEC);
		FNumberC4.setMode(DisplayMode.DEC);
		FNumberC3.setMode(DisplayMode.DEC);
		FNumberC2.setMode(DisplayMode.DEC);
		FNumberC1.setMode(DisplayMode.DEC);
		FNumberD4.setMode(DisplayMode.DEC);
		FNumberD3.setMode(DisplayMode.DEC);
		FNumberD2.setMode(DisplayMode.DEC);
		FNumberD1.setMode(DisplayMode.DEC);
		FNumberI4.setMode(DisplayMode.DEC);
		FNumberI3.setMode(DisplayMode.DEC);
		FNumberI2.setMode(DisplayMode.DEC);
		FNumberI1.setMode(DisplayMode.DEC);

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(getGridLayout());
			jContentPane.setBorder(new LineBorder(Color.WHITE, 3));
			jContentPane.add(getPanelOct4());
			jContentPane.add(getPanelOct3());
			jContentPane.add(getPanelOct2());
			jContentPane.add(getPanelOct1());
			jContentPane.add(getPanelMask());

			jContentPane.add(getPanelOct1_8());
			jContentPane.add(getPanelOct9_16());
			jContentPane.add(getPanelOct17_24());
			jContentPane.add(getPanelOct25_32());
			jContentPane.add(getPanelOctNull());

			jContentPane.add(getPanelI4());
			jContentPane.add(getPanelI3());
			jContentPane.add(getPanelI2());
			jContentPane.add(getPanelI1());
			jContentPane.add(getLabelAddr());

			jContentPane.add(getPanelA4());
			jContentPane.add(getPanelA3());
			jContentPane.add(getPanelA2());
			jContentPane.add(getPanelA1());
			jContentPane.add(getLabelNet());

			jContentPane.add(getPanelB4());
			jContentPane.add(getPanelB3());
			jContentPane.add(getPanelB2());
			jContentPane.add(getPanelB1());
			jContentPane.add(getLabelBcast());

			jContentPane.add(getPanelC4());
			jContentPane.add(getPanelC3());
			jContentPane.add(getPanelC2());
			jContentPane.add(getPanelC1());
			jContentPane.add(getLabelWild());

			jContentPane.add(getPanelD4());
			jContentPane.add(getPanelD3());
			jContentPane.add(getPanelD2());
			jContentPane.add(getPanelD1());
			jContentPane.add(getLabelSub());

			jContentPane.add(getBinButton());
			jContentPane.add(getOctButton());
			jContentPane.add(getDecButton());
			jContentPane.add(getHexButton());
			jContentPane.add(getLabelhe());

			spinnerOct4
					.addChangeListener(new javax.swing.event.ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							spinnerOct4_stateChanged(e);
						}
					});

			spinnerOct3
					.addChangeListener(new javax.swing.event.ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							spinnerOct3_stateChanged(e);
						}
					});

			spinnerOct2
					.addChangeListener(new javax.swing.event.ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							spinnerOct2_stateChanged(e);
						}
					});

			spinnerOct1
					.addChangeListener(new javax.swing.event.ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							spinnerOct1_stateChanged(e);
						}
					});

			spinnerMask
					.addChangeListener(new javax.swing.event.ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							spinnerMask_stateChanged(e);
						}
					});

			BinButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Button_actionPerformed(e);
				}
			});

			OctButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Button_actionPerformed(e);
				}
			});

			DecButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Button_actionPerformed(e);
				}
			});

			HexButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Button_actionPerformed(e);
				}
			});

			BinButton.setActionCommand("Bin");
			OctButton.setActionCommand("Oct");
			DecButton.setActionCommand("Dec");
			HexButton.setActionCommand("Hex");
			updateMask();
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getLicenseMenu());
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jMenuHelpAbout_actionPerformed(e);
				}
			});
		}
		return aboutMenuItem;
	}

	public void jMenuHelpLicense_actionPerformed(ActionEvent e) {
		license dlg = new license(this);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
				(frmSize.height - dlgSize.height) / 2 + loc.y);
		dlg.setModal(true);
		dlg.setVisible(true);
	}

	public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
		AboutBox dlg = new AboutBox(this);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
				(frmSize.height - dlgSize.height) / 2 + loc.y);
		dlg.setModal(true);
		dlg.setVisible(true);
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private GridLayout getGridLayout() {
		if (gridLayout == null) {
			gridLayout = new GridLayout(8, 5, 2, 2);
		}
		return gridLayout;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct4() {
		if (panelOct4 == null) {
			panelOct4 = new JPanel();
			panelOct4.add(getspinnerOct4());

		}
		return panelOct4;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct3() {
		if (panelOct3 == null) {
			panelOct3 = new JPanel();
			panelOct3.add(getspinnerOct3());

		}
		return panelOct3;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct2() {
		if (panelOct2 == null) {
			panelOct2 = new JPanel();
			panelOct2.add(getspinnerOct2());

		}
		return panelOct2;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct1() {
		if (panelOct1 == null) {
			panelOct1 = new JPanel();
			panelOct1.add(getspinnerOct1());

		}
		return panelOct1;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelMask() {
		if (panelMask == null) {
			panelMask = new JPanel();
			panelMask.add(new JLabel("/"), BorderLayout.CENTER);
			panelMask.add(getspinnerMask(), BorderLayout.EAST);
		}
		return panelMask;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct1_8() {
		if (panelOct1_8 == null) {
			panelOct1_8 = new JPanel(new BorderLayout());
			panelOct1_8.add(new JLabel("  1", SwingConstants.LEADING),
					BorderLayout.WEST);
			panelOct1_8.add(new JLabel("8  ", SwingConstants.TRAILING),
					BorderLayout.EAST);
			panelOct1_8.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelOct1_8;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct9_16() {
		if (panelOct9_16 == null) {
			panelOct9_16 = new JPanel(new BorderLayout());
			panelOct9_16.add(new JLabel("  9", SwingConstants.LEADING),
					BorderLayout.WEST);
			panelOct9_16.add(new JLabel("16  ", SwingConstants.TRAILING),
					BorderLayout.EAST);
			panelOct9_16.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelOct9_16;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct17_24() {
		if (panelOct17_24 == null) {
			panelOct17_24 = new JPanel(new BorderLayout());
			panelOct17_24.add(new JLabel("  17", SwingConstants.LEADING),
					BorderLayout.WEST);
			panelOct17_24.add(new JLabel("24  ", SwingConstants.TRAILING),
					BorderLayout.EAST);
			panelOct17_24.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelOct17_24;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOct25_32() {
		if (panelOct25_32 == null) {
			panelOct25_32 = new JPanel(new BorderLayout());
			panelOct25_32.add(new JLabel("  25", SwingConstants.LEADING),
					BorderLayout.WEST);
			panelOct25_32.add(new JLabel("32  ", SwingConstants.TRAILING),
					BorderLayout.EAST);
			panelOct25_32.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelOct25_32;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelOctNull() {
		if (panelOctNull == null) {
			panelOctNull = new JPanel();
		}
		return panelOctNull;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JRadioButton getBinButton() {
		if (BinButton == null) {
			BinButton = new JRadioButton("BIN");
			buttonGroup.add(BinButton);
		}
		return BinButton;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JRadioButton getOctButton() {
		if (OctButton == null) {
			OctButton = new JRadioButton("OCT");
			buttonGroup.add(OctButton);
		}
		return OctButton;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JRadioButton getDecButton() {
		if (DecButton == null) {
			DecButton = new JRadioButton("DEC");
			buttonGroup.add(DecButton);
			DecButton.setSelected(true);
		}
		return DecButton;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JRadioButton getHexButton() {
		if (HexButton == null) {
			HexButton = new JRadioButton("HEX");
			buttonGroup.add(HexButton);
		}
		return HexButton;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JLabel getLabelAddr() {
		if (labelAddr == null) {
			labelAddr = new JLabel("Address");
		}
		return labelAddr;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JLabel getLabelNet() {
		if (labelNet == null) {
			labelNet = new JLabel("Network");
		}
		return labelNet;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JLabel getLabelBcast() {
		if (labelBcast == null) {
			labelBcast = new JLabel("Broadcast");
		}
		return labelBcast;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JLabel getLabelWild() {
		if (labelWild == null) {
			labelWild = new JLabel("Wildcard");
		}
		return labelWild;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JLabel getLabelSub() {
		if (labelSub == null) {
			labelSub = new JLabel("Subnet");
		}
		return labelSub;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JLabel getLabelhe() {
		if (labelhe == null) {
			labelhe = new JLabel("");
		}
		return labelhe;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JSpinner getspinnerOct4() {
		if (spinnerOct4 == null) {
			spinnerOct4 = new JSpinner();
			spinnerMOct4 = new SpinnerNumberModel(0, 0, 255, 1);
			spinnerOct4.setModel(spinnerMOct4);
		}
		return spinnerOct4;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JSpinner getspinnerOct3() {
		if (spinnerOct3 == null) {
			spinnerOct3 = new JSpinner();
			spinnerMOct3 = new SpinnerNumberModel(0, 0, 255, 1);
			spinnerOct3.setModel(spinnerMOct3);
		}
		return spinnerOct3;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JSpinner getspinnerOct2() {
		if (spinnerOct2 == null) {
			spinnerOct2 = new JSpinner();
			spinnerMOct2 = new SpinnerNumberModel(0, 0, 255, 1);
			spinnerOct2.setModel(spinnerMOct2);
		}
		return spinnerOct2;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JSpinner getspinnerOct1() {
		if (spinnerOct1 == null) {
			spinnerOct1 = new JSpinner();
			spinnerMOct1 = new SpinnerNumberModel(0, 0, 255, 1);
			spinnerOct1.setModel(spinnerMOct1);
		}
		return spinnerOct1;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JSpinner getspinnerMask() {
		if (spinnerMask == null) {
			spinnerMask = new JSpinner();
			spinnerMMask = new SpinnerNumberModel(0, 0, 32, 1);
			spinnerMask.setModel(spinnerMMask);
			spinnerMask.setBounds(5, 5, 20, 20);
		}
		return spinnerMask;
	}

	/**
	 * This method initializes jPanelI4
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelI4() {
		if (panelI4 == null) {
			panelI4 = new JPanel();
			panelI4.add(getFNumberI4().getFNText());
			panelI4.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelI4;
	}

	/**
	 * This method initializes jPanelI3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelI3() {
		if (panelI3 == null) {
			panelI3 = new JPanel();
			panelI3.add(getFNumberI3().getFNText());
			panelI3.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelI3;
	}

	/**
	 * This method initializes jPanelI2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelI2() {
		if (panelI2 == null) {
			panelI2 = new JPanel();
			panelI2.add(getFNumberI2().getFNText());
			panelI2.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelI2;
	}

	/**
	 * This method initializes jPanelI1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelI1() {
		if (panelI1 == null) {
			panelI1 = new JPanel();
			panelI1.add(getFNumberI1().getFNText());
			panelI1.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelI1;
	}

	/**
	 * This method initializes jPanelA4
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelA4() {
		if (panelA4 == null) {
			panelA4 = new JPanel();
			panelA4.add(getFNumberA4().getFNText());
			panelA4.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelA4;
	}

	/**
	 * This method initializes jPanelA3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelA3() {
		if (panelA3 == null) {
			panelA3 = new JPanel();
			panelA3.add(getFNumberA3().getFNText());
			panelA3.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelA3;
	}

	/**
	 * This method initializes jPanelA2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelA2() {
		if (panelA2 == null) {
			panelA2 = new JPanel();
			panelA2.add(getFNumberA2().getFNText());
			panelA2.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelA2;
	}

	/**
	 * This method initializes jPanelA1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelA1() {
		if (panelA1 == null) {
			panelA1 = new JPanel();
			panelA1.add(getFNumberA1().getFNText());
			panelA1.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelA1;
	}

	/**
	 * This method initializes jPanelB4
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelB4() {
		if (panelB4 == null) {
			panelB4 = new JPanel();
			panelB4.add(getFNumberB4().getFNText());
			panelB4.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelB4;
	}

	/**
	 * This method initializes jPanelB3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelB3() {
		if (panelB3 == null) {
			panelB3 = new JPanel();
			panelB3.add(getFNumberB3().getFNText());
			panelB3.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelB3;
	}

	/**
	 * This method initializes jPanelB2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelB2() {
		if (panelB2 == null) {
			panelB2 = new JPanel();
			panelB2.add(getFNumberB2().getFNText());
			panelB2.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelB2;
	}

	/**
	 * This method initializes jPanelB1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelB1() {
		if (panelB1 == null) {
			panelB1 = new JPanel();
			panelB1.add(getFNumberB1().getFNText());
			panelB1.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelB1;
	}

	/**
	 * This method initializes jPanelC4
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelC4() {
		if (panelC4 == null) {
			panelC4 = new JPanel();
			panelC4.add(getFNumberC4().getFNText());
			panelC4.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelC4;
	}

	/**
	 * This method initializes jPanelC3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelC3() {
		if (panelC3 == null) {
			panelC3 = new JPanel();
			panelC3.add(getFNumberC3().getFNText());
			panelC3.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelC3;
	}

	/**
	 * This method initializes jPanelC2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelC2() {
		if (panelC2 == null) {
			panelC2 = new JPanel();
			panelC2.add(getFNumberC2().getFNText());
			panelC2.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelC2;
	}

	/**
	 * This method initializes jPanelC1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelC1() {
		if (panelC1 == null) {
			panelC1 = new JPanel();
			panelC1.add(getFNumberC1().getFNText());
			panelC1.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelC1;
	}

	/**
	 * This method initializes jPanelD4
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelD4() {
		if (panelD4 == null) {
			panelD4 = new JPanel();
			panelD4.add(getFNumberD4().getFNText());
			panelD4.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelD4;
	}

	/**
	 * This method initializes jPanelD3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelD3() {
		if (panelD3 == null) {
			panelD3 = new JPanel();
			panelD3.add(getFNumberD3().getFNText());
			panelD3.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelD3;
	}

	/**
	 * This method initializes jPanelD2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelD2() {
		if (panelD2 == null) {
			panelD2 = new JPanel();
			panelD2.add(getFNumberD2().getFNText());
			panelD2.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelD2;
	}

	/**
	 * This method initializes jPanelD1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelD1() {
		if (panelD1 == null) {
			panelD1 = new JPanel();
			panelD1.add(getFNumberD1().getFNText());
			panelD1.setBorder(BorderFactory.createEtchedBorder());
		}
		return panelD1;
	}

	/**
	 * This method initializes FNumberI4
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberI4() {
		if (FNumberI4 == null) {
			FNumberI4 = new FNumber();
		}
		return FNumberI4;
	}

	/**
	 * This method initializes FNumberI3
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberI3() {
		if (FNumberI3 == null) {
			FNumberI3 = new FNumber();
		}
		return FNumberI3;
	}

	/**
	 * This method initializes FNumberI2
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberI2() {
		if (FNumberI2 == null) {
			FNumberI2 = new FNumber();
		}
		return FNumberI2;
	}

	/**
	 * This method initializes FNumberI1
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberI1() {
		if (FNumberI1 == null) {
			FNumberI1 = new FNumber();
		}
		return FNumberI1;
	}

	/**
	 * This method initializes FNumberI4
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberA4() {
		if (FNumberA4 == null) {
			FNumberA4 = new FNumber();
		}
		return FNumberA4;
	}

	/**
	 * This method initializes FNumberA3
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberA3() {
		if (FNumberA3 == null) {
			FNumberA3 = new FNumber();
		}
		return FNumberA3;
	}

	/**
	 * This method initializes FNumberA2
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberA2() {
		if (FNumberA2 == null) {
			FNumberA2 = new FNumber();
		}
		return FNumberA2;
	}

	/**
	 * This method initializes FNumberA1
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberA1() {
		if (FNumberA1 == null) {
			FNumberA1 = new FNumber();
		}
		return FNumberA1;
	}

	/**
	 * This method initializes FNumberB4
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberB4() {
		if (FNumberB4 == null) {
			FNumberB4 = new FNumber();
		}
		return FNumberB4;
	}

	/**
	 * This method initializes FNumberB3
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberB3() {
		if (FNumberB3 == null) {
			FNumberB3 = new FNumber();
		}
		return FNumberB3;
	}

	/**
	 * This method initializes FNumberB2
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberB2() {
		if (FNumberB2 == null) {
			FNumberB2 = new FNumber();
		}
		return FNumberB2;
	}

	/**
	 * This method initializes FNumberB1
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberB1() {
		if (FNumberB1 == null) {
			FNumberB1 = new FNumber();
		}
		return FNumberB1;
	}

	/**
	 * This method initializes FNumberC4
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberC4() {
		if (FNumberC4 == null) {
			FNumberC4 = new FNumber();
		}
		return FNumberC4;
	}

	/**
	 * This method initializes FNumberC3
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberC3() {
		if (FNumberC3 == null) {
			FNumberC3 = new FNumber();
		}
		return FNumberC3;
	}

	/**
	 * This method initializes FNumberC2
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberC2() {
		if (FNumberC2 == null) {
			FNumberC2 = new FNumber();
		}
		return FNumberC2;
	}

	/**
	 * This method initializes FNumberC1
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberC1() {
		if (FNumberC1 == null) {
			FNumberC1 = new FNumber();
		}
		return FNumberC1;
	}

	/**
	 * This method initializes FNumberD4
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberD4() {
		if (FNumberD4 == null) {
			FNumberD4 = new FNumber();
		}
		return FNumberD4;
	}

	/**
	 * This method initializes FNumberD3
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberD3() {
		if (FNumberD3 == null) {
			FNumberD3 = new FNumber();
		}
		return FNumberD3;
	}

	/**
	 * This method initializes FNumberD2
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberD2() {
		if (FNumberD2 == null) {
			FNumberD2 = new FNumber();
		}
		return FNumberD2;
	}

	/**
	 * This method initializes FNumberD1
	 * 
	 * @return FNumber
	 */
	private FNumber getFNumberD1() {
		if (FNumberD1 == null) {
			FNumberD1 = new FNumber();
		}
		return FNumberD1;
	}

	private void spinnerOct4_stateChanged(ChangeEvent e) {
		/*
		 * 
		 */
		updateOct4();
	}

	private void spinnerOct3_stateChanged(ChangeEvent e) {
		/*
		 * 
		 */
		updateOct3();
	}

	private void spinnerOct2_stateChanged(ChangeEvent e) {
		/*
		 * 
		 */
		updateOct2();
	}

	private void spinnerOct1_stateChanged(ChangeEvent e) {
		/*
		 * 
		 */
		updateOct1();
	}

	private void spinnerMask_stateChanged(ChangeEvent e) {
		/*
		 * 
		 */
		updateMask();
	}

	private void Button_actionPerformed(ActionEvent e) {
		/*
		 * 
		 */

		if (e.getActionCommand().compareTo("Bin") == 0)
			setNewMode(DisplayMode.BIN);
		else if (e.getActionCommand().compareTo("Oct") == 0)
			setNewMode(DisplayMode.OCT);
		else if (e.getActionCommand().compareTo("Dec") == 0)
			setNewMode(DisplayMode.DEC);
		else
			setNewMode(DisplayMode.HEX);
	}

	private void setNewMode(int NewMode) {
		FNumberI4.setMode(NewMode);
		FNumberI3.setMode(NewMode);
		FNumberI2.setMode(NewMode);
		FNumberI1.setMode(NewMode);
		FNumberA4.setMode(NewMode);
		FNumberA3.setMode(NewMode);
		FNumberA2.setMode(NewMode);
		FNumberA1.setMode(NewMode);
		FNumberB4.setMode(NewMode);
		FNumberB3.setMode(NewMode);
		FNumberB2.setMode(NewMode);
		FNumberB1.setMode(NewMode);
		FNumberC4.setMode(NewMode);
		FNumberC3.setMode(NewMode);
		FNumberC2.setMode(NewMode);
		FNumberC1.setMode(NewMode);
		FNumberD4.setMode(NewMode);
		FNumberD3.setMode(NewMode);
		FNumberD2.setMode(NewMode);
		FNumberD1.setMode(NewMode);
	}

	private void UpdateMaskLengths() {
		MaskLeft = 0;
		MaskRight = 0;

		switch (spinnerMMask.getNumber().intValue()) {
		case 32:
			MaskRight = 0;
			break;
		case 31:
			MaskRight = 1;
			break;
		case 30:
			MaskRight = 3;
			break;
		case 29:
			MaskRight = 7;
			break;
		case 28:
			MaskRight = 15;
			break;
		case 27:
			MaskRight = 31;
			break;
		case 26:
			MaskRight = 63;
			break;
		case 25:
			MaskRight = 127;
			break;
		case 24:
			MaskRight = 255;
			break;
		case 23:
			MaskRight = 511;
			break;
		case 22:
			MaskRight = 1023;
			break;
		case 21:
			MaskRight = 2047;
			break;
		case 20:
			MaskRight = 4095;
			break;
		case 19:
			MaskRight = 8191;
			break;
		case 18:
			MaskRight = 16383;
			break;
		case 17:
			MaskRight = 32767;
			break;
		case 16:
			MaskRight = 65535;
			break;
		case 15:
			MaskRight = 131071;
			break;
		case 14:
			MaskRight = 262143;
			break;
		case 13:
			MaskRight = 524287;
			break;
		case 12:
			MaskRight = 1048575;
			break;
		case 11:
			MaskRight = 2097151;
			break;
		case 10:
			MaskRight = 4194303;
			break;
		case 9:
			MaskRight = 8388607;
			break;
		case 8:
			MaskRight = 16777215;
			break;
		case 7:
			MaskRight = 33554431;
			break;
		case 6:
			MaskRight = 67108863;
			break;
		case 5:
			MaskRight = 134217727;
			break;
		case 4:
			MaskRight = 268435455;
			break;
		case 3:
			MaskRight = 536870911;
			break;
		case 2:
			MaskRight = 1073741823;
			break;
		case 1:
			MaskRight = 2147483647;
			break;
		case 0:
			MaskRight = 4294967295L;
			break;
		}

		MaskLeft = 4294967295L - MaskRight;

	}

	private void updateOct1() {
		int i = Integer.parseInt(spinnerOct1.getValue().toString());
		UpdateMaskLengths();
		FNumberI1.setValue(i);
		FNumberA1.setValue((int) (i & (MaskLeft)));
		FNumberB1.setValue((int) (i | (255 & (MaskRight))));
		FNumberC1.setValue((int) (255 & (MaskRight)));
		FNumberD1.setValue((int) (255 & (MaskLeft)));
	}

	private void updateOct2() {
		int i = Integer.parseInt(spinnerOct2.getValue().toString());
		UpdateMaskLengths();
		FNumberI2.setValue(i);
		FNumberA2.setValue((int) (i & (MaskLeft >> 8)));
		FNumberB2.setValue((int) (i | (255 & (MaskRight >> 8))));
		FNumberC2.setValue((int) (255 & (MaskRight >> 8)));
		FNumberD2.setValue((int) (255 & (MaskLeft >> 8)));
	}

	private void updateOct3() {
		int i = Integer.parseInt(spinnerOct3.getValue().toString());
		UpdateMaskLengths();
		FNumberI3.setValue(i);
		FNumberA3.setValue((int) (i & (MaskLeft >> 16)));
		FNumberB3.setValue((int) (i | (255 & (MaskRight >> 16))));
		FNumberC3.setValue((int) (255 & (MaskRight >> 16)));
		FNumberD3.setValue((int) (255 & (MaskLeft >> 16)));
	}

	private void updateOct4() {
		int i = Integer.parseInt(spinnerOct4.getValue().toString());
		UpdateMaskLengths();
		FNumberI4.setValue(i);
		FNumberA4.setValue((int) (i & (MaskLeft >> 24)));
		FNumberB4.setValue((int) (i | (255 & (MaskRight >> 24))));
		FNumberC4.setValue((int) (255 & (MaskRight >> 24)));
		FNumberD4.setValue((int) (255 & (MaskLeft >> 24)));
	}

	private void updateMask() {
		UpdateMaskLengths();
		updateOct4();
		updateOct3();
		updateOct2();
		updateOct1();

	}
} // @jve:decl-index=0:visual-constraint="10,10"
