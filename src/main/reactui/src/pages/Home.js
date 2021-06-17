import React from 'react';
import { useSelector } from 'react-redux';
import UrlList from '../components/UrlList';

const Home = () => {
    const {isLoggedIn} =useSelector((store)=>({
        isLoggedIn : store.isLoggedIn
    }));
    return (
        <div>
             <div className="container">
            <div className={"row"}>
                <div className={"col"}>
                    {isLoggedIn&& <UrlList></UrlList>}
                    {!isLoggedIn&&
                    (
                        <h2>Giriş Ya da Kayıt Olunuz</h2>
                    )
                    }
                
            </div>
            </div>
            </div>
        </div>
    );
};

export default Home;