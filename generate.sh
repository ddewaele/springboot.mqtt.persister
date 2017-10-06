#!/bin/bash

function sendMsg {
       temp=$(( ( RANDOM % 30 )  + 1 ))
       now=$(date +%Y-%m-%dT%H:%M:%S%z)
       status=$[RANDOM % 2]

       mosquitto_pub -h localhost -t "ixortalk/msg/$1" -m "{\"temp\":${temp},\"status\":${status},\"date\":\"${now}\",\"raw\":\"0101470dd3c16e00640b0209d100\"}"

}

while :
do
    sendMsg "88-11-22-33-44-55-66-77"
    sendMsg "88-11-22-33-44-55-66-78"
    sendMsg "88-11-22-33-44-55-66-79"
    sendMsg "88-11-22-33-44-55-66-80"
	sleep 1
done

