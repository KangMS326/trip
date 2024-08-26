import React, { useEffect } from "react";
import { axiosGetWeatherData } from "../../services/WeatherService";

function Weather () {
    console.log("Weather()");
    
    useEffect(() =>{
        const fechWeather = async() => {
            console.log("[Weather] fechWeather ");

            try {
                if(navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(async (position) => {
                        const { latitude, longitude } = position.coords;
                        const data = await axiosGetWeatherData(latitude, longitude);
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
        fechWeather();
    },[]);


    return(
        <>
        
        </>
    );
}

export default Weather;