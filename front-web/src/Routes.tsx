import { BrowserRouter, Switch, Route } from "react-router-dom";
import Orders from "./Orders";
import Home from "./Home";
import Navbar from "./Navbar";
import Footer from "./Footer";

export default function Routes(){
    return (
        <BrowserRouter>
            <Navbar />
            <Switch>
                <Route path="/orders">
                    <Orders />
                </Route>
                <Route path="/">
                    <Home />
                </Route>
            </Switch>
            <Footer />
        </BrowserRouter>
    )
}