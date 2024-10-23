private static final String FORECAST_URL = 
"http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s"; 
 
private static String getForecastData(String city) { 
    try { 
        String url = String.format(FORECAST_URL, city, API_KEY); 
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder() 
                .uri(URI.create(url)) 
                .build(); 
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
 
        if (response.statusCode() == 200) { 
            return response.body(); 
        } else { 
            System.out.println("Failed to retrieve forecast data for " + city); 
        } 
    } catch (Exception e) { 
        e.printStackTrace(); 
    } 
    return null; 
}