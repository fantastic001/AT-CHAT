#!/bin/sh

JS=""

function req() {
    method=$1
    path="$2"
    shift 2 
    data=""
    declare -A json
    while [ -n "$1" ]; do
        # echo "$1=$2"
        json["$1"]="$2"
        shift 2
    done
    keys="${!json[@]}"
    data="$(for key in $keys; do echo "\"$key\""; echo "\"${json[$key]}\""; done | jq -cn 'reduce inputs as $i ({}; . + { ($i): input })')"
    # echo $data
    if [ -z "$data" ]; then 
        curl -i -X $method -c cookies.txt -b cookies.txt -H "Content-Type: application/json" "localhost:5544/ChatAPI-web/rest$path" 
    else
        curl -i -X $method -c cookies.txt -b cookies.txt -H "Content-Type: application/json" -d $data "localhost:5544/ChatAPI-web/rest$path" 
    fi
}
function expect() {
    name="$1"
    shift
    ($* > /dev/null 2>&1) && echo "[  OK  ] $name" || echo "[ FAIL ] $name"
}
expect "hello world" curl localhost:5544/ChatAPI-web/rest/hello/say 

# set -x
expect "Registration" req POST /users/register username stefan password sekrit 

expect "User login" req POST "/users/login" \
    username stefan \
    password sekrit

expect "See online users" req GET /users/loggedIn 

