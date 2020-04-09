import { API_URL } from "./../../config";
import axios from "axios"

export default class OrderService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Order/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Order/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Order/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Order/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Order/" + id);
    }
}