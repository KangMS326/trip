import axios from 'axios';

const API_BASE_URL_ADMIN = process.env.REACT_APP_ADMIN_API_URL;

const axiosInstanceAdmin = axios.create({
    baseURL: API_BASE_URL_ADMIN,
    withCredentials: true,
});

export default axiosInstanceAdmin;
