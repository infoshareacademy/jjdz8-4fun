## Docker -> life cicle

        sudo docker ps -a
        sudo docker start mysql-company
        sudo docker kill mysql-company
        sudo docker rm mysql-company

## Docker -> set-up

        sudo docker run -p 0.0.0.0:3308:3306 --name mysql-shoppingList -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=shoppingList -e MYSQL_USER=mysql -e MYSQL_PASSWORD=mysql -d mysql

## Docker compose

        docker-compose ps

## Docker compose -> up

        docker-compose up -d
        or 
        docker-compose up

## Docker compose -> stop

        docker-compose stop 
        or 
        Ctrl + Z

## Deployment of application via docker -> wildfly

        mvn clean package wildfly:deploy

## Redeployment of application via docker -> wildly

        mvn wildfly:redeploy

## Undeployment of application via docker -> wildly

        mvn wildfly:undeploy