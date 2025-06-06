import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import LogInPage from './pages/Login/LoginPage';

function App() {
  return (
    <Router>
      <Routes>
         <Route path="/login" element={<LogInPage />} />
      </Routes>
    </Router>
  );
}

export default App;
