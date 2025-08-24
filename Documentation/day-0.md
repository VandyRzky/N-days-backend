# API Specification

----

## Author Specification

### Register Author

- Endpoint: POST /api/author
- Request Body:
    ```json
    {
      "firstName": "firstName",
      "lastName": "lastName"
    }
    ```
- Response Body:
    ```json
    {
      "data": {
        "id": "id",
        "firstName": "firstName",
        "lastName": "lastName"
      },
      "error": null
    }
    ```
### Get All Author
- Endpoint: GET /api/author
- Response Body:

```json
{
  "data": [
    {
      "id": "id",
      "firstName": "firstName",
      "lastName": "lastName"
    },
    {
      "id": "id",
      "firstName": "firstName",
      "lastName": "lastName"
    }
  ],
  "error": null
}
```
### Update Author
- Endpoint: PATCH /api/author/{id}
- Request Body:
    ```json
    {
      "firstName": "firstName",
      "lastName": "lastName"
    }
    ```
- Response Body:
    ```json
    {
      "data": {
        "id": "id",
        "firstName": "firstName",
        "lastName": "lastName"
      },
      "error": null
    }
    ```
### Delete Author
- Endpoint: DELETE /api/author/{id}
- Response Body:

```json
{
  "data": "success",
  "error": null
}
```