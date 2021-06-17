import axios from 'axios';

export var kayit= (body)=>{
   return axios.post("/kayit",body);
} 

export const login = creds => {
    console.log(creds)
    return axios.post("/auth", {},{auth:creds});
    
}
export  const setAutho =({userName,password, isLoggedIn})=>{
    if(isLoggedIn){

        const authvalue=`Basic ${btoa (userName+':'+password)}`
        axios.defaults.headers["Authorization"]=authvalue;
    }
    else {

        delete axios.defaults.headers["Authorization"];
    }
}

export  const getUrl =()=>{
   return axios.get("/url");
}

export  const postUrl =(url)=>{
    return axios.post("/url",url);
 }

 export  const deleteUrl =(id)=>{
    return axios.delete("/url/"+id);
 }