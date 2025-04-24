package Problem2;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;
public class System_Health_Monitoring {

	public static void main(String[] args) {
		 OperatingSystemMXBean osBean =(OperatingSystemMXBean)ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

	        double cpuLoad = osBean.getSystemCpuLoad() * 100;
	        long totalMemory = osBean.getTotalPhysicalMemorySize();
	        long freeMemory =  osBean.getFreePhysicalMemorySize();
	        double memoryUsage = ((double)(totalMemory - freeMemory) / totalMemory) * 100;

	        System.out.printf("CPU Load: %.2f%%\n", cpuLoad);
	        System.out.printf("Memory Usage: %.2f%%\n", memoryUsage);

	        if (cpuLoad > 80) {
	            System.out.println("ALERT: CPU usage above 80%!");
	        }

	        if (memoryUsage > 80) {
	            System.out.println("ALERT: Memory usage above 80%!");
	        }

	}

}
