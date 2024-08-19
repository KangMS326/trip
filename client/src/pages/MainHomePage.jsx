import React from 'react';
import Weather from '../components/weather/Weather';
import { Link } from 'react-router-dom';



const MainHomePage = () => {

    return(
        <>
            <div>
                <p>광고 이미지</p>
            </div>
            <div>
                <h3>날씨</h3>
                <Weather />
            </div>
            <div>
                <Link to="/">추천 여행</Link> &nbsp;&nbsp; | &nbsp;&nbsp;
                <Link to="/">추천 경로</Link>
            </div>
            <div>
                <p>
                    추천 여행 / 경로 컨텐츠 IMAGE
                </p>
            </div>
        </>
        
    );

}

export default MainHomePage;