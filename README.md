Create a RESTful Spring Boot application that will represent a simple "Library" system with two main entities - User and Book. A user can have many books and a book can only belong to 1 user. A book can be free (allowed to be taken by other users) or taken (not allowed to be taken by other users)

 

Rest controllers should allow to:

- CRUD user

- CRUD book

- Take a book (a book will become taken by a certain user)

- Return book (a book will be free for another user to take)

- (Optional) Get information about the users and the books

they currently have

- Cover your code with tests

 

No UI is needed.

Use any ORM you like

Please try to complete this task within 4 days

Please provide a link to the git repository with a solution


HTTP methods: 

###
GET http://localhost:8007/library/books/ – display all books;

###
GET http://localhost:8007/library/books/{bookId} – disply book by selected id;

###
POST http://localhost:8007/library/books/add – save book in database (data get from JSON);
Content-Type: application/json
Accept: application/json

{
  "id": 444,
  "title": "One",
  "author": "Two",
  "publisher": "Three"
}

###
PUT http://localhost:8007/library/books/take/{bookId}}/{userId}}/ – book with "bookId" has been taken by user {userId};

###
PUT http://localhost:8007/library/books/return/{bookId}/{userId} – book with "bookId" has been returned by user {userId};

###
DELETE http://localhost:8007/library/books/delete/{id} – delete book by selected id;