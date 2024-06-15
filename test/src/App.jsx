import { useEffect } from 'react';
import { useState } from 'react';
import WeatherDataList from './components/WeatherDataList';
import UpperPanel from './components/UpperPanel';
import MeanValuePanel from './components/MeanValuePanel';

function App() {

  return(
    <div className="parent">
      <UpperPanel firstName="Michał" lastName="Protas" />
      <MeanValuePanel />
      <WeatherDataList/>
    </div>
  );
}

export default App;