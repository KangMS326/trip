import React, { useEffect } from "react";
import { axiosGetWaetherData } from "../../services/WeatherService";

function Weather () {
    console.log("Weather()");
    
    useEffect(() =>{
        axiosGetWaetherData();
    },[]);


    return(
        <>
        
        </>
    );
}

export default Weather;