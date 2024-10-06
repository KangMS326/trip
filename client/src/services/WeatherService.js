import axiosInstanceUser from "../config/AxiosConfigUser";


export const fetchWeatherData = async(lat, lon) => {
    try {
        console.log("[WeatherService] fetchWeatherData()");
        console.log(lat, lon,"여기도????");
        
        const response = await axiosInstanceUser.post('/weather/shortTermForecast', {
           '위도' : lat,
           '경도' : lon
        });
        console.log('Weather data:', response.data);

        return response.data;

    } catch (error) {
        console.error('Failed to fetch weather data:', error);
    }
}