package Problem2;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Automated_Backup_Solution {

	public static void main(String[] args) {
	            String sourceDir = "C:/source_folder";
		        String backupDir = "C:/backup_folder/backup_" +
		            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		        try {
		            Files.createDirectories(Paths.get(backupDir));

		            Files.walk(Paths.get(sourceDir))
		                .forEach(source -> {
		                    try {
		                        Path dest = Paths.get(backupDir, source.toString().substring(sourceDir.length()));
		                        if (Files.isDirectory(source)) {
		                            Files.createDirectories(dest);
		                        } else {
		                            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
		                        }
		                    } catch (IOException e) {
		                        e.printStackTrace();
		                    }
		                });

		            System.out.println("Backup completed successfully!");
		        } catch (IOException e) {
		            System.out.println("Backup failed.");
		            e.printStackTrace();
		        }
		    }
		

	

}
