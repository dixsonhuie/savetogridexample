#!/usr/bin/env bash

# Example to submit uber jar

GIGA="/home/dixson/work/ie/gigaspaces-insightedge-enterprise-15.0.0"
PROJ_DIR="/home/dixson/work/proj36/savetogridexample"

MASTER_URL="spark://localhost:7077"

$GIGA/insightedge/bin/insightedge-submit \
--master $MASTER_URL \
--deploy-mode cluster \
--name ReadFromGridExample \
--class com.samples.ie.ReadFromGridExample \
$PROJ_DIR/target/readfromgridexample-jar-with-dependencies.jar $MASTER_URL demo


