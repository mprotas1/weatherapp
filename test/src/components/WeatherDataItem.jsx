import styles from './WeatherDataItem.module.css';
import axios from 'axios';
import { format } from 'date-fns';

function WeatherDataItem({ data, onDelete }) {
    const handleDelete = async () => {
        try {
            await axios.delete("http://localhost:8085/weatherapp/data/" + data.id);
            onDelete(data.id);
        }
        catch(error) {
            console.log("Could not delete item with id: " + data.id);
        }
    }
 
    const roundTemperatureValue = () => {
      return data.temperature.toFixed(2);
    }

    const determineUnit = () => {
        if(data.unit === "C") {
          console.log("Got celsius!");
          return "°C";
        }
        else {
          return "°F";
        }
    }

    const formatDate = () => {
      let date = format(data.creationDateTime, 'yyyy/MM/dd kk:mm:ss')
      return date;
    }

    return (
      <li className={styles.weatherItem}>
        <div className={styles.item}>{data.id}</div>
        <div className={styles.item}>{roundTemperatureValue()} {determineUnit()}</div>
        <div className={styles.item}>{data.atmosphericPressure} hPa</div>
        <div className={styles.item}>{formatDate()}</div>
        <div className={styles.item}>
          <button className={styles.weather_edit_button}>
            Edit
          </button>
          <button className={styles.weather_delete_button}
                  onClick={handleDelete}>
                  Delete entry
          </button>
        </div>
      </li>
    );
}

export default WeatherDataItem;