import { API_URL } from "./../../config";
import axios from "axios"

export default class LoginService 
{
    constructor(self) 
    {
        this.self = self;
    }


    static login(x)
    {
        return axios.post(API_URL + "/Auth", x);
    }
    static info(x)
    {
        return axios.get(API_URL + "/Auth/info");
    }

}
