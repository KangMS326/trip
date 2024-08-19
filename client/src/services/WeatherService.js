import axiosInstanceUser from "../config/AxiosConfigUser";


export const axiosGetWaetherData = async() => {
    try {
        console.log("[WeatherService] axiosGetWaetherData()");
        
        const response = await axiosInstanceUser.get('/weather/getWeather');
        console.log('Weather data:', response.data);

        return response.data;

    } catch (error) {
        console.error('Failed to fetch weather data:', error);
        console.log(error);
    }
}