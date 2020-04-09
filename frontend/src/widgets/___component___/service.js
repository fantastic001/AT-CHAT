import { API_URL } from "./../../config";
import axios from "axios"

export default class {{ component }}Service 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/{{ component}}/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/{{ component }}/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/{{ component }}/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/{{ component }}/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/{{ component }}/" + id);
    }
}
