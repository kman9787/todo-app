export APP_NAME=${PWD##*/}
podman build -t $APP_NAME  .
podman compose up -d
