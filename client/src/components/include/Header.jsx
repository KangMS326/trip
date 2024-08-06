import React from "react";
import "../../css/include/Header.css";
import { Link } from "react-router-dom";

function Header () {

    return(
        <header >
            <div className="homeHeader">
                <Link to="/">
                    <img src="/img/logo.png" alt="여기모여" className="logoImg" />
                </Link>
            </div>
        </header>
    );
}
export default Header;