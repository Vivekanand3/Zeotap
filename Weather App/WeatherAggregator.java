create a hourly weather data for each city: import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
 
public class WeatherAggregator { 
    private Map<String, List<WeatherData>> cityWeatherData = new HashMap<>(); 
 
    // Add weather data for a city 
    public void addWeatherData(String city, WeatherData data) { 
        cityWeatherData.computeIfAbsent(city, k -> new ArrayList<>()).add(data); 
    } 
 
    // Generate daily weather summary (average, max, min) 
    public void generateDailySummary() { 
        for (String city : cityWeatherData.keySet()) { 
            List<WeatherData> dataList = cityWeatherData.get(city); 
            float avgTemp = 0, maxTemp = Float.MIN_VALUE, minTemp = Float.MAX_VALUE; 
            float avgHumidity = 0, maxHumidity = Integer.MIN_VALUE, minHumidity = 
Integer.MAX_VALUE; 
            float avgWindSpeed = 0; 
            String mainCondition = null; 
 
            for (WeatherData data : dataList) { 
                float tempCelsius = data.getMain().getTempCelsius(); 
                avgTemp += tempCelsius; 
                maxTemp = Math.max(maxTemp, tempCelsius); 
                minTemp = Math.min(minTemp, tempCelsius); 
 
                int humidity = data.getMain().getHumidity(); 
                avgHumidity += humidity; 
                maxHumidity = Math.max(maxHumidity, humidity); 
                minHumidity = Math.min(minHumidity, humidity); 
 
                avgWindSpeed += data.getWind().getSpeed(); 
 
                mainCondition = data.getWeather().get(0).getMain(); 
            } 
 
            int count = dataList.size(); 
            avgTemp /= count; 
            avgHumidity /= count; 
            avgWindSpeed /= count; 
 
            System.out.printf("Daily Summary for %s:%nAverage Temp: %.2f°C, Max Temp: %.2f°C, Min 
Temp: %.2f°C%n" + 
                            "Average Humidity: %.2f%%, Max Humidity: %d%%, Min Humidity: %d%%%nAverage 
Wind Speed: %.2f m/s%nCondition: %s%n%n", 
                    city, avgTemp, maxTemp, minTemp, avgHumidity, maxHumidity, minHumidity, 
avgWindSpeed, mainCondition); 
        } 
    } 
}