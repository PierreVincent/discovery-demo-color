FROM newsweaver/smartstack-java

RUN apt-get update && apt-get install -y unzip

# Smartstack config
ADD smartstack/nerve.conf.json /etc/

# Dropwizard app
ADD build/distributions/color-service.zip /opt/
RUN unzip /opt/color-service.zip -d /opt

# Starting script
ADD smartstack/start.sh /opt/start.sh
ENTRYPOINT ["/opt/start.sh"]