package Problem2;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Application_Health_Checker {

	public static void main(String[] args) {
		             String[] appUrls = {
		            "https://www.google.com", 
		            "https://example.com/api/health", 
		            "http://localhost:8080/myapp"
		        };

		        for (String appUrl : appUrls) {
		            checkApplicationHealth(appUrl);
		        }
		    }

		    public static void checkApplicationHealth(String urlString) {
		        try {
		            URL url = new URL(urlString);
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("GET");
		            connection.setConnectTimeout(3000); 
		            connection.connect();

		            int responseCode = connection.getResponseCode();
		            
		            if (responseCode >= 200 && responseCode < 300) {
		                System.out.println("✅ " + urlString + " is UP (Status Code: " + responseCode + ")");
		            } else {
		                System.out.println("❌ " + urlString + " is DOWN (Status Code: " + responseCode + ")");
		            }
		        } catch (IOException e) {
		            System.out.println("❌ " + urlString + " is DOWN (Error: " + e.getMessage() + ")");
		        }
		    }

	}


