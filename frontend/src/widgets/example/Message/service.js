import { API_URL } from "./../../config";
import axios from "axios"

export default class MessageService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Message/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Message/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Message/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Message/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Message/" + id);
    }
}