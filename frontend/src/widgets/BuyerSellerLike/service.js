import { API_URL } from "./../../config";
import axios from "axios"

export default class BuyerSellerLikeService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/BuyerSellerLike/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/BuyerSellerLike/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/BuyerSellerLike/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/BuyerSellerLike/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/BuyerSellerLike/" + id);
    }
}