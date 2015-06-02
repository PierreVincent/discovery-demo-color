#!/bin/bash

if [[ $ZK_HOSTS ]]; then
    /opt/startNerve.sh &
    /opt/startSynapse.sh &
else
    echo "Missing env: ZK_HOSTS"
    exit 1
fi

npm start