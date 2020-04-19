#!/bin/sh
curl localhost:5544/ChatAPI-web/rest/hello/say

curl -H "Content-Type: application/json" -d '{"username": "stefan", "password": "sekrit", "hostAlias": null}' localhost:5544/ChatAPI-web/rest/users/register

