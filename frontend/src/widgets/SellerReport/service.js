import { API_URL } from "./../../config";
import axios from "axios"

export default class SellerReportService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/SellerReport/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/SellerReport/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/SellerReport/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/SellerReport/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/SellerReport/" + id);
    }
}