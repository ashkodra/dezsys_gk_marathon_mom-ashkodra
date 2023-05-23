package sectionpark.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimingstationData implements Serializable {

	private String timingstationID;
	private String timestamp;

	private double distance;
	private String unitDistance;

	private double altitude;
	private String unitAltitude;

	private String unitCompetitionData;
	private List<CompetitionData> competitionData = new LinkedList<CompetitionData>();

	/**
	 * Constructor
	 */
	public TimingstationData() {
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		this.unitDistance = "m";
		this.unitAltitude = "hm";
		this.unitCompetitionData = "hh:mm:ss";
	}

	/**
	 * Setter and Getter Methods
	 */
	public String getTimingstationID() {
		return timingstationID;
	}

	public void setTimingstationID(String timingstationID) {
		this.timingstationID = timingstationID;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public void addRunner(CompetitionData runner) {
		competitionData.add(runner);
	}

	public List<CompetitionData> getCompetitionData() {
		return competitionData;
	}

	public String getUnitDistance() {
		return unitDistance;
	}

	public String getUnitAltitude() {
		return unitAltitude;
	}

	public String getUnitCompetitionData() {
		return unitCompetitionData;
	}

	public CompetitionData getCompetitionData(int id) {
		return competitionData.get(id);
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Timing Station Info: ID = %s, timestamp = %s, distance = %d",
				timingstationID, timestamp, distance);
		for (CompetitionData runner : competitionData) {
			info += String.format("PartyId: ID = %d, timing = %s", runner.getPartyId(),
					new SimpleDateFormat("HH:mm:ss").format(runner.getTiming()));
		}
		return info;
	}
}
