#!/bin/bash

CONTAINER_NAME="CM50258_cw2_dev"

if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    # if the container is running, exec into it
    docker exec -it $CONTAINER_NAME bash
elif [ "$(docker ps -aq -f status=exited -f name=$CONTAINER_NAME)" ]; then
    # if the container exists but stopped, start and exec into it
    docker start $CONTAINER_NAME
    docker exec -it $CONTAINER_NAME bash
else
    # if the container does not exist, create and start it
    docker run \
     -d \
     -it \
     -v "$(pwd):$(pwd)" -w "$(pwd)" \
     --name $CONTAINER_NAME \
    maven \
        tail -f /dev/null

    docker exec -it $CONTAINER_NAME bash -c "apt-get update && apt-get install make"
    docker exec -it $CONTAINER_NAME bash
fi

# mvn archetype:generate -DgroupId=com.yourdomain -DartifactId=cw2 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
# mvn compile test