import React from "react";
import { Link } from 'react-router-dom';
import '../../css/include/Nav.css';

function Nav() {
    return (
        <>
            <div className="homeNavbarAuth">
                <Link to="/">회원가입</Link>
                <Link to="/">로그인</Link>
            </div>
            <nav className="homeNavbar">
                <div className="homeNavbarLink">
                    <Link to="/">추천 여행</Link>
                    <Link to="/">추천 경로</Link>
                    <Link to="/">일정</Link>
                    <Link to="/">갤러리</Link>
                </div>
            </nav>
        </>
    );
}

export default Nav;
