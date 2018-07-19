#!/bin/bash
set -e;
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
PID_FILE=${DEPLOY_DIR}/pid;
if [ ! -f $PID_FILE ];then
	echo " echo $PID_FILE can not find , please check service is running !...";
	exit 0;
fi
CONF_DIR=$DEPLOY_DIR/conf

echo -e "Stopping ...\c"

PID=$(cat $PID_FILE);
cat ${PID_FILE} |xargs kill >>/dev/null
COUNT=0
while [ $COUNT -lt 1 ]; do
    echo -e ".\c"
    sleep 1
    COUNT=1
    PID_EXIST=`ps -f| grep $PID` | grep -v 'java';
    if [ -n "$PID_EXIST" ]; then
        COUNT=0
        break
    fi
done
rm -f ${PID_FILE}
echo "OK!"
echo "PID: $PID"
exit 0