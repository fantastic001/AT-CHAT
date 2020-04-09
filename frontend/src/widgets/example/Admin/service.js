import { API_URL } from "./../../config";
import axios from "axios"

export default class AdminService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Admin/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Admin/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Admin/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Admin/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Admin/" + id);
    }
}