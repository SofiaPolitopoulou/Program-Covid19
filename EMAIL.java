import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EMAIL {
	public static void send(final String from, final String password, String to, String sub, String msg) {
		// Get properties object
		System.out.printf("from %s to %s sub %s message %s%n", from, to, sub, msg);
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			// It starts the composition of a message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("covidinfong@gmail.com")); // from what account we send it
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // who receives our message
			message.setSubject(sub); // what is the subject of our message
			message.setText(msg); // what is our message
			// send message
			Transport.send(message);
			System.out.println("Message has been sent successfully!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
