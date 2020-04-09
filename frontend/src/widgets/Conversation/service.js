import { API_URL } from "./../../config";
import axios from "axios"

export default class ConversationService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/Conversation/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/Conversation/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/Conversation/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/Conversation/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/Conversation/" + id);
    }
}