import { API_URL } from "./../../config";
import axios from "axios"

export default class CityService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/City/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/City/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/City/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/City/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/City/" + id);
    }
}