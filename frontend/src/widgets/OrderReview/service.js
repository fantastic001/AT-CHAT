import { API_URL } from "./../../config";
import axios from "axios"

export default class OrderReviewService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/OrderReview/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/OrderReview/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/OrderReview/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/OrderReview/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/OrderReview/" + id);
    }
}