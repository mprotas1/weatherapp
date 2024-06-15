import WeatherDataItem from "./WeatherDataItem";
import { useState, useEffect } from "react";
import axios from "axios";
import styles from './WeatherDataList.module.css';

const api = axios.create({
    baseURL: "http://localhost:8085/weatherapp/data",
    headers: {
      "Access-Control-Allow-Origin": '*'
    },
    withCredentials: false
  });

function WeatherDataList() {
  const [weatherDataList, setWeatherDataList] = useState([]);
  const [isDataFetched, setIsDataFetched] = useState(true);

  const handleDelete = (id) => {
    setWeatherDataList(weatherDataList.filter(item => item.id !== id));
  }

  useEffect(() => {
    api.get()
      .then(response => {
        setWeatherDataList(response.data);
        setIsDataFetched(true);
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
        setIsDataFetched(false);
      });
  }, 
  []);

  return(
    <div>
      {isDataFetched ? (
        <ul className={styles.weatherList}>
          <li className={styles.weatherHeader}>
            <div className={styles.headerItem}>ID</div>
            <div className={styles.headerItem}>Temperature</div>
            <div className={styles.headerItem}>Pressure</div>
            <div className={styles.headerItem}>Created on</div>
            <div className={styles.headerItem}>Additional actions</div>
          </li>
          {weatherDataList.map(weatherData => (
            <WeatherDataItem key={weatherData.id} data={weatherData} onDelete={handleDelete}/>
          ))}
        </ul>
      ) : (
        <div>
          Could not fetch data, please retry.
        </div>
      )}
    </div>
  );
}

export default WeatherDataList;