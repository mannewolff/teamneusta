package de.mwolff.fourwins.controller;

import de.mwolff.fourwins.model.FourWinModel;
import de.mwolff.fourwins.model.WinStrategy;

public class FourWinsController {

	FourWinModel model = new FourWinModel();
	WinStrategy strategy = new WinStrategy(model);

	char lastColor;

	public String move(String color, int column) {

		char actColor = convertColor(color);
		model.setCoin(actColor, column);
		lastColor = actColor;

		char won;
		won = strategy.isWin();
		if (won == 'R')
			return "Rot hat gewonnen.";
		else if (won == 'G')
			return "Gelb hat gewonnen.";

		if (lastColor == 'R')
			return "Gelb ist an der Reihe";
		else
			return "Rot ist an der Reihe";
	}

	private char convertColor(String color) {
		String first = color.substring(0, 1);
		if ("R".equals(first))
			return 'R';
		if ("G".equals(first))
			return 'G';
		return '*';
	}

	public String toString() {
		return model.toString();
	}
}
