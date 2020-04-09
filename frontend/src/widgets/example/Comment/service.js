import { API_URL } from "./../../config";
import axios from "axios"

export default class CommentService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Comment/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Comment/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Comment/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Comment/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Comment/" + id);
    }
}