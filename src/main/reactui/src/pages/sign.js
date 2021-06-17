import {useState} from 'react';

import Input from "../components/input";


import {singupHangler} from "../redux/actions";
import {useDispatch} from "react-redux";
const Sign =(props)=> {
    const [form, setForm] = useState({
        userName:null,
        
        password:null,
        
    })
    const [err,setErr]=useState();

    
    const dispatch =useDispatch();


    const onChange = event=>{
        const {value, name}= event.target;
        setErr(undefined)
        

        setForm((previousForm)=>({... previousForm, [name]:value}));


    }
    const onClickKayit = async event => {
        event.preventDefault();
        const {history } = props;
        const {push} =  history;
        const {userName,password}=form;
        const body={
            userName,
            password
        }


        try{
           await dispatch(singupHangler(body))
                push("/");
        }
        catch (err){
            setErr("validasyon hataları var");


        }


    }



        
       
        
    
        return (
            <div className="container">
                <form>
                    <h1 className="text-center">{('Kayıt Ol')}</h1>
                    <Input name ="userName" label={("Adınız")} type="text"  onChange={onChange}/>
                    
                    <Input name ="password" label={("Şifreniz")} type="password"  onChange={onChange}/>
                    
                                     <div className="text-center">
                        <button  onClick={onClickKayit}
                                       
                                       
                        >{("Kayıt Ol")}</button>
                        <h2>{err&&err}</h2>

                    </div>

                </form>
            </div>


        );


}
export default (Sign);


