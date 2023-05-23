package sectionpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sectionpark.model.TimingstationData;
import sectionpark.timingstation.MOMSender;
import sectionpark.timingstation.TimingstationService;

import java.util.Scanner;

@SpringBootApplication
public class MarathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarathonApplication.class, args);
        TimingstationService service = new TimingstationService();
        boolean continueLoop = true;
        Scanner scanner = new Scanner(System.in);
        String value = "";
        String timingstationID = "";
        while (continueLoop) {
            System.out.println("Enter TimingstationID: ");
            timingstationID = scanner.nextLine();
            TimingstationData data = service.getTimingstationData(timingstationID);
            MOMSender sender = new MOMSender(data);
            System.out.println("Do you want to continue? (yes/no)");
            value = scanner.nextLine();
            if (value.equals("no")) {
                continueLoop = false;
            }
        }
    }
}
