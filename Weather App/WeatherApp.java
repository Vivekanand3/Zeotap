Create the Main Java Class: Set up your Open Weather Map API URL and API key. 
 
public class WeatherApp { 
    private static final String API_KEY = "your_api_key"; // Replace with your OpenWeatherMap API 
key 
    private static final String BASE_URL = 
"http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s"; 
 
    public static void main(String[] args) { 
        String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"}; 
 
        for (String city : cities) { 
            String response = getWeatherData(city); 
            if (response != null) { 
                WeatherData weatherData = parseWeatherData(response); 
                if (weatherData != null) { 
                    displayWeatherData(city, weatherData); 
                } 
            } 
        } 
    } 
 
    // Fetch weather data for a city 
    private static String getWeatherData(String city) { 
        try { 
            String url = String.format(BASE_URL, city, API_KEY); 
            HttpClient client = HttpClient.newHttpClient(); 
            HttpRequest request = HttpRequest.newBuilder() 
                    .uri(URI.create(url)) 
                    .build(); 
            HttpResponse<String> response = client.send(request, 
HttpResponse.BodyHandlers.ofString()); 
 
            if (response.statusCode() == 200) { 
                return response.body(); 
            } else { 
                System.out.println("Failed to retrieve data for " + city); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return null; 
    } 
    // Parse JSON response to extract weather data 
    private static WeatherData parseWeatherData(String jsonResponse) { 
        Gson gson = new Gson(); 
        return gson.fromJson(jsonResponse, WeatherData.class); 
    } 
    // Display weather data in a readable format 
    private static void displayWeatherData(String city, WeatherData data) { 
        System.out.printf("City: %s%nTemperature: %.2f°C%nFeels Like: %.2f°C%nHumidity: 
%d%%%nWind Speed: %.2f m/s%nCondition: %s%n%n", 
                city, 
                data.getMain().getTempCelsius(), 
                data.getMain().getFeelsLikeCelsius(), 
                data.getMain().getHumidity(), 
                data.getWind().getSpeed(), 
                data.getWeather().get(0).getMain()); 
    } 
} 