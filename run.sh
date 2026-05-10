export APP_NAME=${PWD##*/}
docker build -t $APP_NAME  .
docker compose up -d
