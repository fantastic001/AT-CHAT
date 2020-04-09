import { API_URL } from "./../../config";
import axios from "axios"

export default class BuyerFavoriteItemService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/BuyerFavoriteItem/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/BuyerFavoriteItem/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/BuyerFavoriteItem/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/BuyerFavoriteItem/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/BuyerFavoriteItem/" + id);
    }
}