package sectionpark.timingstation;

import sectionpark.model.CompetitionData;
import sectionpark.model.TimingstationData;

public class TimingstationSimulation {

	private double getRandomDouble(int inMinimum, int inMaximum) {

		double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
		double rounded = Math.round(number * 100.0) / 100.0;
		return rounded;

	}

	private int getRandomInt(int inMinimum, int inMaximum) {

		double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
		Long rounded = Math.round(number);
		return rounded.intValue();

	}

	public TimingstationData getData(String inTimingstationID) {

		TimingstationData data = new TimingstationData();
		data.setTimingstationID(inTimingstationID);
		data.setDistance(1);
		data.setAltitude(200);
		CompetitionData runner = new CompetitionData(1, getRandomTime());
		CompetitionData runner2 = new CompetitionData(2, getRandomTime());
		CompetitionData runner3 = new CompetitionData(3, getRandomTime());
		data.addRunner(runner);
		data.addRunner(runner2);
		data.addRunner(runner3);

		return data;
	}

	private String getRandomTime() {
		int hours = getRandomInt(0, 23);
		int minutes = getRandomInt(0, 59);
		int seconds = getRandomInt(0, 59);

		String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		return time;
	}
}
