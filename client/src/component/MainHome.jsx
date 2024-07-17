import React, { useEffect } from 'react';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';


const MainHome = () => {

    return(
        <BrowserRouter>
            <Routes>
                <Route path="/">HOME</Route>
            </Routes>
        </BrowserRouter>
    );

}

export default MainHome;