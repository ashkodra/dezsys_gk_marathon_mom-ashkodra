package sectionpark;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import sectionpark.model.TimingstationData;

import java.util.ArrayList;

public class MOMReceiver extends Thread {

    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public ArrayList<TimingstationData> data;

    /**
     * Constructor
     */
    public MOMReceiver() {
        data = new ArrayList<TimingstationData>();
        this.start();
    }
    @Override
    public void run() {
        System.out.println("Receiver started.");
        // Create the connection.
        Session session = null;
        Connection connection = null;
        MessageConsumer consumer = null;
        Destination destination = null;

        try {

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connectionFactory.setTrustAllPackages(true);
            connection = connectionFactory.createConnection();
            connection.start();

            // Create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            destination = session.createTopic("TimingstationData");

            // Create the consumer
            consumer = session.createConsumer(destination);

            // Start receiving
            ObjectMessage message = (ObjectMessage) consumer.receive();
            while (message != null) {
                data.add((TimingstationData) message.getObject());
                System.out.println("Message received! ");
                System.out.println("Message: " + message.getObject().toString());
                message.acknowledge();
                message = (ObjectMessage) consumer.receive();
            }

            System.out.println("No more messages received. ");

            connection.stop();

        } catch (Exception e) {
            System.out.println("[MessageConsumer] Caught: " + e);
            e.printStackTrace();
        } finally {
            try {
                consumer.close();
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
        System.out.println("Receiver finished.");

    } // end main

    /**
     * Get the data
     * @return data
     */
    public ArrayList<TimingstationData> getData() {
        return data;
    }
}
