import { API_URL } from "./../../config";
import axios from "axios"

export default class UserService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/User/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/User/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/User/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/User/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/User/" + id);
    }
}