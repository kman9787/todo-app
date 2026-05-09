podman build -t kash-todo-app  .

podman run -d -p 8080:8080 --env-file ./env.list kash-todo-app
