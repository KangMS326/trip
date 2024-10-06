import React, { useEffect } from "react";
import { fetchWeatherData } from "../../services/WeatherService";

function Weather () {
    console.log("Weather()");
    
    useEffect(() =>{
        const fetchWeather = async() => {
            console.log("[Weather] fechWeather ");

            try {
                if(navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(async (position) => {
                        const { latitude, longitude } = position.coords;
                        const data = await fetchWeatherData(latitude, longitude);
                        console.log(latitude, longitude,data, "데이터 들어오나???????");
                        //setWeatherData(data);
                    },
                    (err) => {
                        //setError("Error getting location: " + err.message);
                        console.log("Error getting location: " + err.message);
                    });
                }
            } catch (error) {
                console.log("error message",error);
            }
        }
        fetchWeather();
    },[]);


    return(
        <>
        
        </>
    );
}

export default Weather;