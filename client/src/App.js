import './App.css';
import MainHomePage from './pages/MainHomePage';
import Test from './components/admin/test';
import Footer from './components/include/Footer';
import Header from './components/include/Header';
import Nav from './components/include/Nav';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      
      
        <BrowserRouter>
          <Header />
          <Nav />
          <Test />
            <div>
              <Routes>
                  <Route path='/' element={<MainHomePage/>}> </Route>
              </Routes>
            </div>
          <Footer />
        </BrowserRouter>
     

    </div>
  );
}

export default App;

