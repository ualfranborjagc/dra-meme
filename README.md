# DRA-Meme
Esta separado en 2 repositorios:

El que esta sin docker funciona mejor, funciona el front y todo el backend
Por otro lado el que tiene docker, solo funciona el front y la database.

Comandos que he usando frecuentemente:

·Base de datos sin docker

docker pull postgres

docker run -d --name postgresql_database -e POSTGRES_USER=user -e POSTGRES_PASSWORD=pass -e POSTGRES_DB=db -p 5432:5432 -v data:/var/lib/pgsql/data postgres

·Backend

docker build -t backendimg:latest .

docker run --name backContainerdir -p 8081:8081 backendimg:latest

·Frontend

docker build -t frontend-img .

docker run --name frontContainer -p 80:80 frontend-img

·Docker-compose

docker compose up
