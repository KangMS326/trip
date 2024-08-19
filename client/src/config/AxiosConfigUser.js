import axios from 'axios';

const API_BASE_URL_USER = process.env.REACT_APP_USER_API_URL;

const axiosInstanceUser = axios.create({
    baseURL: API_BASE_URL_USER,
    withCredentials: true,
});

export default axiosInstanceUser;
