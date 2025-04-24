package Problem2;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Log_File_Analizer {
		    public static void main(String[] args) throws IOException {
		        String logFilePath = "C:\\Users\\91638\\git\\repository\\WebsiteTest_Project\\logs\\access.log";

		        Map<String, Integer> ipCounter = new HashMap<>();
		        Map<String, Integer> pageCounter = new HashMap<>();
		        int error404Count = 0;

		        BufferedReader reader = new BufferedReader(new FileReader(logFilePath));
		        String line;

		        Pattern pattern = Pattern.compile("^(\\S+) .*? \\\"\\S+ (\\S+) .*?\\\" (\\d{3})");

		        while ((line = reader.readLine()) != null) {
		            Matcher matcher = pattern.matcher(line);
		            if (matcher.find()) {
		                String ip = matcher.group(1);
		                String page = matcher.group(2);
		                String status = matcher.group(3);

		                ipCounter.put(ip, ipCounter.getOrDefault(ip, 0) + 1);
		                pageCounter.put(page, pageCounter.getOrDefault(page, 0) + 1);
		                if (status.equals("404")) {
		                    error404Count++;
		                }
		            }
		        }
		        reader.close();

		        System.out.println("Total 404 Errors: " + error404Count);
		        System.out.println("Top IPs: " + getTop(ipCounter));
		        System.out.println("Top Pages: " + getTop(pageCounter));
		    }

		    public static List<Map.Entry<String, Integer>> getTop(Map<String, Integer> map) {
		        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
		        return list.subList(0, Math.min(5, list.size()));
		    }
		}

	


