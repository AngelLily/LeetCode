#!/bin/bash

set -o errexit

readonly BASEDIR=$(cd $(dirname $0) && pwd)/..                      # get script's father path
readonly APP_NAME="sdopt"                                   # app name
readonly JAVA_HOME="/export/servers/jdk1.8.0_20"                    # java home
readonly JAVA="$JAVA_HOME/bin/java"
readonly MAIN_MODULE="com.jd.git.chs.AppMain"      # main class

function get_pid
{
    pgrep -f "java .*$MAIN_MODULE"
}

function start
{
    CLASSPATH="$BASEDIR/conf/:$BASEDIR/lib/*"

    [[ -z $(get_pid) ]] || {
        echo "ERROR:  $APP_NAME already running" >&2
        exit 1
    }

    echo "Starting $APP_NAME ...."
    [[ -x ${JAVA} ]] || {
        echo "ERROR: no executable java found at $JAVA" >&2
        exit 1
    }
    cd ${BASEDIR}
    setsid "$JAVA" ${JAVA_OPTS} ${MEMORY_OPTS} \
        -classpath "$CLASSPATH" \
        -Dbasedir="$BASEDIR" \
        -Dfile.encoding="UTF-8" \
        ${MAIN_MODULE} \
        "$@" > /dev/null 2>&1 &

    sleep 0.5
    [[ -n $(get_pid) ]] || {
        echo "ERROR: $APP_NAME failed to start" >&2
        exit 1
    }
    echo "$APP_NAME is up runnig :)"

}

start "$@"
