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
 * Copyright: Copyright Bob Goddard (c) 2002, 2003, 2004, 2005, 2006
 * @author Bob Goddard
 * @version 1.0
 */

package maskcalc;

import java.awt.*;
import java.lang.String;
import javax.swing.*;

public class FNumber extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FNumber() {
		init();
	}

	public void init() {
		FNText = new JLabel();
		FNText.setText("0");
		setMode(DisplayMode.DEC);
		add(FNText, BorderLayout.CENTER);
	}

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		FNText.setBounds(0, 0, width, height);
		FNText.setHorizontalAlignment(SwingConstants.TRAILING);
		FNText.setVerticalAlignment(SwingConstants.CENTER);
	}

	public void setValue(int Num) {
		Value = Num;
		setMode(CurrentMode);
	}

	public void setMode(int NewMode) {
		int L;
		String S = "";

		if (NewMode == DisplayMode.BIN) {
			S = Integer.toBinaryString(Value);
			L = S.length();

			while (L < 8) {
				S = '0' + S;
				L++;
			}

			S = S.substring(0, 4) + ' ' + S.substring(4, 8);
			CurrentMode = DisplayMode.BIN;
			FNText.setText(S);

		} else if (NewMode == DisplayMode.OCT) {
			S = Integer.toOctalString(Value);
			CurrentMode = DisplayMode.OCT;
			L = S.length();

			while (L < 3) {
				S = '0' + S;
				L++;
			}

			FNText.setHorizontalAlignment(SwingConstants.TRAILING);
			FNText.setText(S);
		} else if (NewMode == DisplayMode.DEC) {

			S = Integer.toString(Value);
			CurrentMode = DisplayMode.DEC;
			FNText.setHorizontalAlignment(SwingConstants.TRAILING);
			FNText.setText(S);

		} else if (NewMode == DisplayMode.HEX) {

			S = Integer.toHexString(Value);
			S = S.toUpperCase();
			CurrentMode = DisplayMode.HEX;
			L = S.length();

			while (L < 2) {
				S = '0' + S;
				L++;
			}

			FNText.setHorizontalAlignment(SwingConstants.TRAILING);
			FNText.setText(S);

		} else {
			System.out.println("oops, wrong mode sent");
		}
	}

	public int getValue() {
		return Value;
	}

	public int getMode() {
		return CurrentMode;
	}

	public JLabel getFNText() {
		return FNText;
	}

	private JLabel FNText;
	private int Value;
	private int CurrentMode;
}
