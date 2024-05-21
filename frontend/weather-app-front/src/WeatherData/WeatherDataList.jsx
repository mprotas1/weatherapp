import React, { useEffect, useState } from 'react';
import axios from 'axios';

const WeatherDataList = () => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Funkcja asynchroniczna do pobrania danych
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8085/weatherapp/data');
        setData(response.data);
      } catch (error) {
        setError(error);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []); // Pusty array [] oznacza, że useEffect wykona się tylko raz po montażu komponentu

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <div>
      <h1>Weather Data</h1>
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
};

export default WeatherDataList;