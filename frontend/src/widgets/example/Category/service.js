import { API_URL } from "./../../config";
import axios from "axios"

export default class CategoryService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Category/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Category/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Category/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Category/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Category/" + id);
    }
}