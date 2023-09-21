Docker image készítés
```shell
docker build -t <image name> .
```
Docker image indítása:
```shell
>docker run -d -p 8080:8080 <docker_image name>
```
Force delete docker image:
```shell
docker rmi -f <docker_id>
```