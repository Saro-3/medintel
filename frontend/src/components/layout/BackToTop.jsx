import React, { useEffect, useState } from 'react'
import "../../css/layout/layout.css"

const BackToTop = () => {
    const [show, setShow] = useState(false);

    useEffect(() => {
        const handleScroll = () => {
            setShow(window.scrollY > 300);
        };

        window.addEventListener("scroll", handleScroll);
        return () => window.removeEventListener("scroll", handleScroll);
    }, []);

    const scrollToTop = () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth",
        });
    };

    if(!show) return null;
  return (
    <button className='back-to-top' onClick={scrollToTop}>
        ↑
    </button>
  )
}

export default BackToTop
