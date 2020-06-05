FROM jboss/wildfly
MAINTAINER "infoShare 4 fun shoppinglist"
RUN wildfly/bin/add-user.sh admin admin --silent
ADD webapp/target/shoppinglist-web.war wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]