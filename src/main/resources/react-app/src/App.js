import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          This is react APP being served as SSR to Spring boot Application.
        </p>
        <a
          className="App-link"
          href="https://github.com/nik10-mah/spring-react-ssr"
          target="_blank"
          rel="noopener noreferrer"
        >
          Got to GitHub Repository
        </a>
      </header>
    </div>
  );
}

export default App;
