# Service Discovery Demo - UI Service

This simple UI service consumes the color service to display colors

## Requirements

To run this Service you will only need [Docker](http://www.docker.com).

If you wish to make changes to the service and build your own images, you will also need:

* NodeJS / npm

## Docker Image

### Run this image

```
docker run -d -p 80:80 -e ZK_HOSTS=zookeeper1:2181 pierrevincent/discovery-demo-color-ui-service
```

Note: replace zookeeper1:2181 by one or more locations of Zookeeper nodes.

### Ports

| port | description |
| --- | --- |
| 80 | Web UI and API |

### Parameters

| parameter | description | example | required |
| --- | --- | --- | --- |
| ZK_HOSTS | Commas separated list of zookeeper nodes (host:port) | ZK_HOSTS=1.2.3.4:2181,1.2.3.5:2181 | yes |

### Base Image

This image is based on [newsweaver/smartstack-nodejs](https://registry.hub.docker.com/u/newsweaver/smartstack-nodejs).