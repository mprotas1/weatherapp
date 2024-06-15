import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import styles from './MeanValuePanel.module.css'
import weatherimage from "../assets/weather icon.png"

const api = axios.create({
    baseURL: "http://localhost:8085/weatherapp/data"
  });

function MeanValuePanel() {
    const [mean, setMean] = useState(0);
  
    const roundTemperatureValue = () => {
      return mean.toFixed(2);
    }

    useEffect(() => {
      api.get('/mean')
        .then(response => setMean(response.data))
        .catch(error => console.error('Error fetching posts:', error));
    }, []);

    return(
        <div className={styles.meanValuePanel}>
            <img className={styles.meanImage} src={weatherimage}/>
            <div className={styles.meanTitle}>Mean value is: {roundTemperatureValue()} °C</div>
        </div>
    );
}

export default MeanValuePanel;