
package wovilonapps.wheatherclient.io;

import java.io.Serializable;
import java.util.Date;

public class MyWeather implements Serializable {
    private double temp_max;
    private double temp_min;
    private String clouds;
    private String cloudsIconId;
    private Date date;
    private double windSpeed;
    private double windDirection;

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getTemp_max() {

        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public String getClouds() {
        return clouds;
    }

    public Date getDate() {
        return date;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setCloudsIconId(String cloudsIconId) {
        this.cloudsIconId = cloudsIconId;
    }

    public String getCloudsIconId() {

        return cloudsIconId;
    }
}
