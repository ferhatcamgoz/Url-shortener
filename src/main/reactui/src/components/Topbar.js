import React, {Component, useEffect, useRef, useState} from 'react';

import {Link} from "react-router-dom";

import { useDispatch,useSelector } from 'react-redux';
import {logoutSuccess} from "../redux/actions";




const TopBar =props =>{



    
    const {isLoggedIn,userName}=useSelector(store=>({

            isLoggedIn:store.isLoggedIn,
            userName:store.userName,
          

    }));

        const menuArea = useRef(null);

        const [menuVisible, setMenuVisible] = useState(false);
        useEffect(() => {
            document.addEventListener('click', menuClickTracker);
            return () => {
                document.removeEventListener('click', menuClickTracker);
            };
        }, [isLoggedIn]);
        const menuClickTracker = event => {
            if (menuArea.current === null || !menuArea.current.contains(event.target)) {
                setMenuVisible(false);
            }
        };
        const dispatch = useDispatch();

        const onLogoutSuccess = () => {
            dispatch(logoutSuccess());
        };

                  let links =(
                        <ul className="navbar-nav ml-auto">
                            <li>
                                <Link className="nav-link" to="/login">
                                    {('Login')}
                                </Link>
                            </li>
                            <li>
                                <Link className="nav-link" to="/sign"> {('Sign Up')} </Link>
                            </li>
                        </ul>
                    );
                    if(isLoggedIn){
                        let dropDownClass = 'dropdown-menu p-0 shadow';
                        if (menuVisible) {
                            dropDownClass += ' show';
                        }

                        links=(
                            
                                  
                                    <div >
                                        
                                        <span  className="dropdown-item  d-flex p-2"   onClick ={onLogoutSuccess} style={{cursor:"pointer"}} >
                                            <i className="material-icons text-danger mr-2">power_settings_new</i>
                                            {userName}  {('Çıkış Yap')}
                                        </span >
                                    </div>

                        );}
                    return (
                        <div className="shadow-sm bg-light mb-2">
                            <nav className="navbar navbar-light container navbar-expand">
                                <Link className="navbar-brand" to="/">
                                    CamgözUrl

                                </Link>
                                {links}
                            </nav>

                        </div>

                    );

}

;

export default (TopBar);