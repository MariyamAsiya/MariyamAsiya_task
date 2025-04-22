package Website;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Problem_1 {

	public static void main(String[] args) {
		String url="https://example.com";
		try {
			URL site=new URL(url);
			HttpURLConnection connection=(HttpURLConnection) site.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int code=connection.getResponseCode();
			if(code==200) {
				InputStream input =connection.getInputStream();
				BufferedReader reader=new BufferedReader(new InputStreamReader(input));
				String line;
				while((line=reader.readLine())!=null) {
					System.out.println(line);
				}
				reader.close();
			}
		}
			catch(Exception e){
			e.printStackTrace();
			}
			
	}
}


