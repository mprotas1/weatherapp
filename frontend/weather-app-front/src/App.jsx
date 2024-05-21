import WeatherDataList from "./WeatherData/WeatherDataList.jsx"
import WeatherData from "./WeatherData/WeatherData.js";
import Header from "./Page/Header.jsx";
import Footer from "./Page/Footer.jsx";

function App() {
  const weatherData = [
    new WeatherData(1, 20.5, "C", "2024-05-20T14:30:00Z"),
    new WeatherData(2, 22.5, "C", "2024-05-20T14:30:00Z"),
    new WeatherData(3, 34.5, "C", "2024-05-20T14:30:00Z"),
  ];

  return (
    <>
      <Header/>
      <WeatherDataList items={weatherData}/>
      <Footer/>
    </>
  )
}

export default App
