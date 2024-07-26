import './App.css';
import MainHome from './component/MainHome';
import Test from './component/admin/test';
import Footer from './component/include/Footer';
import Header from './component/include/Header';
import Nav from './component/include/Nav';
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
                  <Route path='/' element={<MainHome/>}> </Route>
              </Routes>
            </div>
          <Footer />
        </BrowserRouter>
     

    </div>
  );
}

export default App;

