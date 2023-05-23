package sectionpark.timingstation;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import sectionpark.model.TimingstationData;

import javax.jms.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MOMSender {

    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "TimingstationData";

    public MOMSender(TimingstationData data) {

        System.out.println("Sender started.");

        // Create the connection.
        Session session = null;
        Connection connection = null;
        MessageProducer producer = null;
        Destination destination = null;

        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();

            // Create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic(subject);

            // Create the producer.
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            ObjectMessage message = session.createObjectMessage(data);

            producer.send(message);
            connection.stop();

        } catch (Exception e) {

            System.out.println("[MessageProducer] Caught: " + e);
            e.printStackTrace();

        } finally {

            try {
                producer.close();
            } catch (Exception e) {
            }
            try {
                session.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }

        }
        System.out.println("Sender finished.");

    } // end main

}
