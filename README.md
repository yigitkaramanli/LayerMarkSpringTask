# Sorry For Being late
## Yiğit Karamanlı

### Startup

**1. Create MySql Database**

```bash
create database lyrmrk
```

* First time you run the program, tables will be created automatically. After first run of the program, make sure to change `spring.jpa.hibernate.ddl-auto` property in `src/main/resources/application.properties` from `create` to `update` to keep the data.

**2. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

### Author 

| Method | Url                                           | Description                                                                           | Sample Valid Request Body     |
|--------|-----------------------------------------------|---------------------------------------------------------------------------------------|-------------------------------|
| GET    | /api/author/getall                            | Get All Authors                                                                       |                               |
| DELETE | /api/author/delete/{id}                       | Delete Author With id                                                                 |                               |
| POST   | /api/author/create                            | Create Author                                                                         | [JSON](#authorcreate)         |
| POST   | /api/author/createAuthorWithBook              | Create Author and assign a Book to it                                                 | [JSON](#authorcreatewithbook) |
| GET    | /api/author/{id}                              | Get Author with id                                                                    |                               |
| GET    | /api/author/firstName/{firstName}             | Get Author with firstName (works with startsWith)                                     |                               |
| GET    | /api/author/lastName                          | Get Author with lastName (works with startsWith)                                      |            |
| GET    | /api/author/getPrecise/{firstName}/{lastName} | Get Author with firstName and lastName                                                |            |
| PUT    | /api/author/{author_id}/book/{book_id}        | Add Book with book_id to Author with author_id                                        |                               |
| DELETE | /api/author/{author_id}/book/{book_id}               | Remove Book with book_id from Author with author_id's books                           |                               |

### Book


| Method | Url                                    | Description                                                   | Sample Valid Request Body |
|--------|----------------------------------------|---------------------------------------------------------------|--------------------|
| GET    | /api/book/getall                       | Get All Books                                                 |                    |
| DELETE | /api/book/delete/{id}                  | Delete Book with id                                           |                    |
| POST   | /api/book/create                       | Create Book                                                   | [JSON](#bookcreate) |
| POST   | /api/author/createBookWithAuthor       | Create Book and assign Author with id to it                   | [JSON](#bookcreatewithauthor) |
| GET    | /api/book/{id}                         | Get Book with id                                              |                    |
| PUT    | /api/book/{book_id}/author/{author_id} | Add Author with author_id to Book with book_id's authors      |                    |
| DELETE | /api/book/{book_id}/author/{author_id} | Remove Author with author_id from Book with book_id's authors |                    |
| GET    | /api/book/findTitle/{title}            | Get Book from title (Works with Contains)                     |                    |
| GET    | /api/book/getByYear/{year}             | Get Books by year                                             |                    |
| GET    | /api/book/yearBefore/{year}            | Get Books before year                                         |                    |
| GET    | /api/book/yearAfter/{year}             | Get Books after year                                          |                    |

## Sample Valid JSON request Bodys

##### <a id= "createauthor"> Create Author -> /api/author/create </a>
```json
{
  "first_name" : "Erdem",
  "last_name" : "Gunay"
}
```

##### <a id= "authorcreatewithbook"> Create Author with Book -> /api/author/createAuthorWithBook </a>
```json
{
  "first_name" : "Erdem",
  "last_name" : "Gunay",
  "Book_id" : 1
}
```

##### <a id= "bookcreate"> Create Book -> /api/book/create </a>

```json
{
  "Title" : "LayerMark",
  "Year" : 2022
}
```
##### <a id= "bookcreatewithauthor"> Create Book with Author -> /api/book/createBookWithAuthor </a>

```json
{
  "Title" : "LayerMark",
  "Year" : 2022,
  "Author_id" : 1
}
```