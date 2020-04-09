import { API_URL } from "./../../config";
import axios from "axios"

export default class FromAdminMessageService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/FromAdminMessage/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/FromAdminMessage/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/FromAdminMessage/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/FromAdminMessage/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/FromAdminMessage/" + id);
    }
}