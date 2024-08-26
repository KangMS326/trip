import axiosInstanceUser from "../config/AxiosConfigUser";


export const axiosGetWeatherData = async(lat, lon) => {
    try {
        console.log("[WeatherService] axiosGetWeatherData()");
        console.log(lat, lon,"여기도????");
        
        const response = await axiosInstanceUser.post('/weather/getWeather', {
           '위도' : lat,
           '경도' : lon
        });
        console.log('Weather data:', response.data);

        return response.data;

    } catch (error) {
        console.error('Failed to fetch weather data:', error);
    }
}