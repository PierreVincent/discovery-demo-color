FROM newsweaver/smartstack-nodejs

# Smartstack config
ADD smartstack/nerve.conf.json /etc/
ADD smartstack/synapse.conf.json /etc/

# Add Node app and npm dependencies
WORKDIR /app
ADD package.json /app/
RUN npm install
ADD . /app

ENV NODE_ENV production

# Starting script
ADD smartstack/start.sh /opt/start.sh
ENTRYPOINT ["/opt/start.sh"]