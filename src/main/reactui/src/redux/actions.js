

import {kayit, login} from "../api/apiCalls";

export const  logoutSuccess = ()=>{
    return {
        type:"logout-success"
    };
}
export const  loginSuccess = authData=>{
    return {
        type:"login-success",
        payload:authData
    };
}

export const  loginHandler = (user) => {
    return async  dispatch =>{
        const creds ={
            username:user.userName,
            password:user.password
        }
        const response= await login(creds);
        const authData ={
            ... response.data,
            password:user.password
        }
 
        dispatch(loginSuccess(authData));
        console.log(user)
 
        return response;
     }
 }
 export const singupHangler= (user) =>{
     return async dispatch =>{
         const response = await kayit(user);
        
         await dispatch(loginHandler(user));
         return response;
     }
    }
 