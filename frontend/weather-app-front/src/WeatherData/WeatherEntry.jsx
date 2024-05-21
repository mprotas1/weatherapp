import React from 'react';
import styles from "./WeatherEntry.module.css"

function WeatherEntry({ entry }) {
  const { id, temperatureValue, temperatureUnit, creationTime } = entry;
  const formattedTime = new Date(creationTime).toLocaleString();

  return (
    <div className={styles.weatherEntry}>
      <time className={styles.time} dateTime={creationTime}>{formattedTime}</time>
      <p className={styles.temperature}>{temperatureValue} {temperatureUnit}&deg;</p>
      <button>Delete</button>
    </div>
  );
}

export default WeatherEntry;