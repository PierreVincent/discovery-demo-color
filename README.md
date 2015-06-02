# Service Discovery Demo with Smartstack

This demo is an example of how to use Smartstack in Docker containers to enable Service Discovery between microservices.

## Requirements

To run this Demo you will only need [Docker](http://www.docker.com).

If you wish to make changes to the services and build your own images, you will also need:

* Java 8
* Gradle
* NodeJS / npm

## What does the demo do?

There are 2 services:

* [Color UI Service](color-ui-service), which displays colors (but doesn't know how to generate them itself) - using NodeJS and AngularJS
* [Color Service](color-service), which provides a random color selected at startup (but doesn't display it) - using Java (Dropwizard)

The idea is to allow these 2 services to work together, so that the Color UI Service can get a color from the Color Service and display it. When an instance of the Color service is started, it picks a color randomly and will always return that color when recieving a request. This allows to get a visual feedback as to which Color Service is being used by the UI.

## Running this Demo

### Start Zookeeper

Smartstack relied on Zookeeper as a key-value store to keep track of all the discovery information.

You can start use your own Zookeeper, or simply start it in container (and expose it to the host on port 2181):

```
docker run -d -p 2181:2181 jplock/zookeeper
```

### Start the Color UI Service

```
docker run -d -e ZK_HOSTS=192.168.59.103:2181 -p 80:80 pierrevincent/discovery-demo-color-ui-service
```

You should then be able to access the Color UI on http://192.168.59.103. The page should display that there is no color available, since there is no Color Service available yet.

Note: 192.168.59.103 is the default IP for the Docker Host if you are using boot2docker. You might have to replace it with your own in the ```docker run``` command.

### Start the Color Service

```
docker run -d -e ZK_HOSTS=192.168.59.103:2181 pierrevincent/discovery-demo-color-service
```

You should then start seeing a color appearing on the Color UI in your browser on http://192.168.59.103

### Play around

You can now try a few things to see how the Discovery takes care of changes:

* shut down a container that runs a Color Service
* start multiple containers of the Color Service
* access the Color UI service in multiple browser tabs
* ...

## Smartstack Docker images

[Smartstack](http://nerds.airbnb.com/smartstack-service-discovery-cloud/) is an open-source service discovery framework developed by Airbnb.

This demo relies on the following base smartstack images:

* [newsweaver/smartstack-java](https://registry.hub.docker.com/u/newsweaver/smartstack-java)
* [newsweaver/smartstack-nodejs](https://registry.hub.docker.com/u/newsweaver/smartstack-nodejs)

