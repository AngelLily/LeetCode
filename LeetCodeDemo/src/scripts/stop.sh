#!/bin/sh
BASEDIR=`dirname $0`/..
BASEDIR=`(cd "$BASEDIR"; pwd)`
ROOTDIR=`dirname $BASEDIR`/..

if [ -z "$APP_CATE_NAME" ] ; then
    APP_CATE_NAME="sd-operation-platform"
fi

PIDPROC=`ps -ef | grep "$APP_CATE_NAME" | grep -v 'grep'| awk '{print $2}'`

if [ -z "$PIDPROC" ];then
 echo "java  is not running"
 exit 0
fi

echo "PIDPROC: "$PIDPROC
for PID in $PIDPROC
do
if kill -9 $PID
   then echo "process $ROOTDIR(Pid:$PID) was force stopped at " `date`
fi
done
echo stop finished.
