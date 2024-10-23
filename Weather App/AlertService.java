public class AlertService { 
 
    private static void checkForAlerts(WeatherData data) { 
        if (data.getMain().getTempCelsius() > 40) { 
            System.out.println("Heat alert! High temperature detected."); 
        } 
        if (data.getMain().getTempCelsius() < 5) { 
            System.out.println("Cold alert! Low temperature detected."); 
        } 
        // Add more alert conditions as needed 
    } 
 
    // You may include a method to call checkForAlerts with WeatherData 
} 