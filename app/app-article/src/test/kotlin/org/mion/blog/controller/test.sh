curl -X POST "http://localhost:8080/api/articles" \
--data '{"title": "hello", "content": "hello mongodb"}' \
--header "Content-Type: application/json"