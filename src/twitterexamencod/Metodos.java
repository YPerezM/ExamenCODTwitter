package twitterexamencod;

import java.util.List;
import java.util.Scanner;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Clase que
 *
 * @author Administrador
 * @version 1.0
 */
public class Metodos {

    Twitter twitter;
    private Object sender;

    public Metodos() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("WJlRvBV4wBypu9toviAcZz0ai")
                .setOAuthConsumerSecret("DDjyPyjWIUwsBUb8gpaZio3mAmPa6fvSQH5Cwihw5x5yifk3Ap")
                .setOAuthAccessToken("2432074031-JEUtoBzbvar998zW3SPacHtfXh37IMLXrXWJMUP")
                .setOAuthAccessTokenSecret("k3scGjHKNalio57qRj6yQAGevKkwZRyOOyPdOshz1dT6t");

        twitter = new TwitterFactory(cb.build()).getInstance();
    }

    /**
     * Nos muestra la linea de tiempo
     */
    public void timeLine() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }

    /**
     * Busca tweets con el texto introducido
     */
    public void buscar() throws TwitterException {
        Query query = new Query();
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Crea y publica un tweet
     *
     * @param latestStatus
     */
    public void tweet(String latestStatus) throws TwitterException {
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
