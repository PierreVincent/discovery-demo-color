# Service Discovery Demo - Color Service

This color service picks a random color and always returns that same color.

## Requirements

To run this Service you will only need [Docker](http://www.docker.com).

If you wish to make changes to the service and build your own image, you will also need:

* Java 8
* Gradle

## Docker Image

### Run this image

```
docker run -d -e ZK_HOSTS=zookeeper1:2181 pierrevincent/discovery-demo-color-service
```

Note: replace zookeeper1:2181 by one or more locations of Zookeeper nodes.

### Ports

| port | description |
| --- | --- |
| 8080 | API |

### Parameters

| parameter | description | example | required |
| --- | --- | --- | --- |
| ZK_HOSTS | Commas separated list of zookeeper nodes (host:port) | ZK_HOSTS=1.2.3.4:2181,1.2.3.5:2181 | yes |

### Base Image

This image is based on [newsweaver/smartstack-java](https://registry.hub.docker.com/u/newsweaver/smartstack-java).