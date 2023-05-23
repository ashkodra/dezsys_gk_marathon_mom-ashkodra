package sectionpark.model;

import java.io.Serializable;
public class CompetitionData implements Serializable {
    private int partyId;
    private String timing;

    public CompetitionData(int partyId, String timing) {
        this.partyId = partyId;
        this.timing = timing;
    }

    public int getPartyId() {
        return partyId;
    }

    public String getTiming() {
        return timing;
    }
}
