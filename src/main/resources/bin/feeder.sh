#!/usr/bin/env bash

GIGA="/home/dixson/work/ie/gigaspaces-insightedge-enterprise-15.0.0"

PROJ_DIR="/home/dixson/work/proj36/savetogridexample"

export CLASSES_DIR="$PROJ_DIR/target/classes"

export CLASSPATH=$GIGA/lib/required/*

export CLASSPATH=$CLASSPATH:$CLASSES_DIR

export GS_LOOKUP_LOCATORS="localhost"
export GS_LOOKUP_GROUPS="xap-15.0.0"

java -Xms1g -Xmx1g -classpath "$CLASSPATH" com.samples.feeder.Main