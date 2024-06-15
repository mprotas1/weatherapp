import React, { useEffect } from 'react';
import styles from './UpperPanel.module.css';
import userImage from "../assets/user-img.png";
import { useState } from 'react';

function UpperPanel({ firstName, lastName }) {
  const [currentTime, setCurrentTime] = useState(new Date());

  useEffect(() => {
    const timer = setInterval(() => {
      setCurrentTime(new Date());
    }, 1000);

    return () => clearInterval(timer);
  }, []);
  return (
    <div className={styles.upperPanel}>
        <div className={styles.infoHeader}>Weather info for: {currentTime.toLocaleString()}</div>
        <div className={styles.rightGroup}>
          <div className={styles.credentials}>Hello, {firstName} {lastName}</div>
          <img className={styles.userImage} src={userImage}/>
        </div>
    </div>
  );
}

export default UpperPanel;