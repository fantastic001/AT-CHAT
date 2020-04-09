import { API_URL } from "./../../config";
import axios from "axios"

export default class ToAdminMessageService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/ToAdminMessage/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/ToAdminMessage/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/ToAdminMessage/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/ToAdminMessage/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/ToAdminMessage/" + id);
    }
}