import { API_URL } from "./../../config";
import axios from "axios"

export default class ItemReportService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/ItemReport/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/ItemReport/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/ItemReport/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/ItemReport/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/ItemReport/" + id);
    }
}