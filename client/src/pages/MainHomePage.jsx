import React from 'react';
import Weather from '../components/weather/Weather';



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
                <a href="#">추천 여행</a> &nbsp;&nbsp; | &nbsp;&nbsp;
                <a href="#">추천 경로</a>
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