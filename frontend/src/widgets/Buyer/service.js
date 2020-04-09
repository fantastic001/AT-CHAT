import { API_URL } from "./../../config";
import axios from "axios"

export default class BuyerService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Buyer/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Buyer/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Buyer/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Buyer/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Buyer/" + id);
    }
}