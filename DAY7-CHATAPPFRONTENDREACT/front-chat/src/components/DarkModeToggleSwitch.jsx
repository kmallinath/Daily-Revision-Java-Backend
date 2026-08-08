import React from "react";
import { useState, useEffect } from "react";
import { GoSun } from "react-icons/go";
import { BsFillMoonFill } from "react-icons/bs";


const DarkModeToggleSwitch = ({className}) => {
    const [darkMode, setDarkMode] = useState(
        localStorage.getItem("theme") === "dark"
    );

    useEffect(() => {
        if (darkMode) {
            document.documentElement.classList.add("dark");
            localStorage.setItem("theme", "dark");
        } else {
            document.documentElement.classList.remove("dark");
            localStorage.setItem("theme", "light");
        }
    }, [darkMode]);

    return (
        <button onClick={() => setDarkMode(!darkMode)} className={className}>
            {darkMode ? <GoSun className="text-yellow-100" /> : <BsFillMoonFill />}
        </button>
    );
}

export default DarkModeToggleSwitch;