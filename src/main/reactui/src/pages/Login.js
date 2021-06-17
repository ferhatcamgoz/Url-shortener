import React,{useState} from 'react';
import Input from "../components/input";
import  {useDispatch} from "react-redux";
import {loginHandler} from "../redux/actions";


const Login=(props) =>{

  const [userName,setUsername] = useState();
  const [password,setPassword] = useState();
  const [err,setErr] = useState();
 const  dispatch =useDispatch();
  

    const   onclick = async event =>{
        event.preventDefault();
        const creds ={
            userName,
            password
        }

        const {history } = props;
        const {push} =history;

        try {
          await  dispatch(loginHandler(creds));
            push("/");
        }
        catch (errors){
            setErr("ad veya şifre hatalı")
        }

    }
      
     

        const buttonEnabled = userName && password;
        return(
            <div className="container">
                <form>
                    <h1 className="text-center">{("Giriş Yap")}</h1>
                    <Input name ="userName" label= {("Adınız")} type="text"  onChange={(event)=> {
                        setErr(undefined);
                        setUsername( event.target.value)}} />
                    <Input name ="password" label= {("Şifreniz")}  type="password" onChange={(event) =>{
setPassword(event.target.value)
setErr(undefined)
                    } }  />
                    
                    <div className="text-center">
                        <button
                            onClick={onclick}
                            
                           
                        >Giriş Yap</button>
                        <h2>{err&&err}</h2>



                    </div>

                </form>
            </div>
        );


}



export default  Login;


