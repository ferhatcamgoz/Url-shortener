import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { deleteUrl, getUrl,postUrl } from '../api/apiCalls';

const UrlList = () => {

    const [url,setUrl] =useState({content:[]});
    const [err,setErr] =useState();
    const [currnetUrl,setCurrnetUrl] =useState(""); 
    useEffect(()=>{

        loadUrl();
    },[])
    
    const onclick= async ()=>{
        const url={
            longUrl:currnetUrl
        }
       

        try{
            await postUrl(url);
            loadUrl();
        }
        catch(err){
            setErr("HATALI GİRİŞ")
        }
       
    }
  
    const loadUrl =async ()=>{
        try{
            const response = await getUrl();
            setUrl({content:[]})
            setUrl(previousUrl=>({
                
                content: [...response.data,...previousUrl.content]
            })
              
                )
            }
        
        catch (err){
            console.log(err)
        }
    }
  
    return (
        <div>
            <input  onChange={(event)=>{
                setCurrnetUrl( event.target.value) ;
                setErr(undefined);
            } }></input>
            <button onClick={onclick}>Kısalt</button>
            <h6>{err&&err}</h6>
           {url.content.map(url=>{
               return(
               <div >
                    <div className={"card p-1"}  >
                    <div className={"d-flex"} >
                    <div className={"flex-fill m-auto pl-2"}>
                    
                    <div key={url.id}>
                        
                       <a href ={url.shortUrl}>{url.shortUrl}</a></div>
            <div>{url.longUrl}</div>
            <button className={"btn btn-delete-link"} onClick={ async()=>{  
              await  deleteUrl(url.id);
                await loadUrl();
            }
                            }>
                            <i className={"material-icons"}>delete_outline</i>
                            </button>
                    </div>
                    </div>
                    </div>
          
            </div>
             )
           })}
            
        </div>
    );
};

export default UrlList;