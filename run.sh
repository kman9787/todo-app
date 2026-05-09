docker build -t kash-todo-app  .

docker run -d -p 8080:8080 --env-file ./env.list kash-todo-app