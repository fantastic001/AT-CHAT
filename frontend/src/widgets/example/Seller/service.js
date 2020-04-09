import { API_URL } from "./../../config";
import axios from "axios"

export default class SellerService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Seller/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Seller/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Seller/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Seller/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Seller/" + id);
    }
}