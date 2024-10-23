Weather Data Class Structure:   
import java.util.List; 
public class WeatherData { 
private Main main; 
private Wind wind; 
private List<Weather> weather; 
public Main getMain() { 
return main; 
} 
public Wind getWind() { 
return wind; 
} 
public List<Weather> getWeather() { 
return weather; 
} 
} 
class Main { 
    private float temp; // Temperature in Kelvin 
    private float feels_like; // Feels like in Kelvin 
    private int humidity; 
 
    public float getTempCelsius() { 
        return temp - 273.15F; // Convert Kelvin to Celsius 
    } 
 
    public float getFeelsLikeCelsius() { 
        return feels_like - 273.15F; // Convert Kelvin to Celsius 
    } 
 
    public int getHumidity() { 
        return humidity; 
    } 
} 
 
class Wind { 
    private float speed; // Wind speed in m/s 
 
    public float getSpeed() { 
        return speed; 
    } 
} 
class Weather { 
    private String main; 
 
    public String getMain() { 
        return main; 
    } 
} 
