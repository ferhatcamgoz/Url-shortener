
import TopBar from "./components/Topbar";
import Login from "./pages/Login";
import {HashRouter as Router, Route, Redirect, Switch} from "react-router-dom";
import Sign from "./pages/sign";
import Home from "./pages/Home";


function App() {
  return (
   <div>
     <Router>
      <TopBar/>
        <Switch> 
        <Route exact path="/" component={Home}/>
          <Route path="/login" component={Login}></Route>
          <Route path="/sign" component={Sign}></Route>
       </Switch>
     
     </Router>
    </div>
  );
}

export default App;
