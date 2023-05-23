package sectionpark.timingstation;

import org.springframework.web.bind.annotation.RestController;

import sectionpark.MOMReceiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sectionpark.model.TimingstationData;

import java.util.ArrayList;

@RestController
public class TimingstationController {
    MOMReceiver receiver;

    /**
     * Constructor
     */
    public TimingstationController() {
        this.receiver = new MOMReceiver();
    }
    private static TimingstationData data;

    public static void setTimingstationData(TimingstationData inData) {
        data = inData;
    }

    @RequestMapping("/")
    public String timingstationMain() {
        String mainPage = "This is the timingstation application! (DEZSYS_MARATHON_REST) <br/><br/>" +
                "<a href='http://localhost:8080/timingstation/001/data'>Link to timingstation/001/data</a><br/>" +
                "<a href='http://localhost:8080/timingstation/001/xml'>Link to timingstation/001/xml</a><br/>";
        return mainPage;
    }

    @RequestMapping(value = "/timingstation/{timingstationID}/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TimingstationData> timingstationData(@PathVariable String timingstationID) {
        System.out.println("TimingstationData: " + data);
        return this.receiver.getData();
    }

    @RequestMapping(value = "/timingstation/{timingstationID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ArrayList<TimingstationData> timingstationXML(@PathVariable String timingstationID) {
        return this.receiver.getData();
    }

}