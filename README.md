# Mapping Practice
This is a `Spring Boot` project for creating, reading, updating, and deleting `Student`, `Address`, `Book`, `Laptop`, and `Course`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages
![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")
---

## Browser / Tools

## ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")

## Models

- ### Student Properties
  - ```java
    @Id
    private String id;
    ```
  - ```java
    private String name;
    ```
  - ```java
    private String age;
    ```
  - ```java
    private String phoneNumber;
    ```
  - ```java
    private String branch;
    ```
  - ```java
    private String department;
    ```
  - ```java
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    ```
- ### Laptop Properties
  - ```java
    @Id
    private String id;
    ```
  - ```java
    private String name;
    ```
  - ```java
    private String brand;
    ```
  - ```java
    private Integer price;
    ```
  - ```java
    @OneToOne
    private Student student;
    ```
- ### Course Properties
  - ```java
    @Id
    private String id;
    ```
  - ```java
    private String title;
    ```
  - ```java
    private String description;
    ```
  - ```java
    private String duration;
    ```
  - ```java
    @ManyToMany
    List<Student> studentList;
    ```
- ### Book Properties
  - ```java
    @Id
    private String id;
    ```
  - ```java
    private String title;
    ```
  - ```java
    private String author;
    ```
  - ```java
    private String description;
    ```
  - ```java
    private String price;
    ```
  - ```java
    @ManyToOne
    private Student student;
    ```
- ### Address Properties
  - ```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ```
  - ```java
    private String landmark;
    ```
  - ```java
    private String zipcode;
    ```
  - ```java
    private String district;
    ```
  - ```java
    private String state;
    ```
  - ```java
    private String country;
    ```
## Dataflow
- ### End Points / Controllers
  - _Student_
    - `@PostMapping("student")`
    - `@GetMapping("student")`
    - `@PutMapping("student/{id}")`
    - `@DeleteMapping("student/{id}")`
  - _Laptop_
    - `@PostMapping("laptop")`
    - `@GetMapping("laptop")`
    - `@PutMapping("laptop/{lapId}")`
    - `@DeleteMapping("laptop/{laptopId}")`
  - _Course_
    - `@PostMapping("course")`
    - `@GetMapping("course")`
    - `@PutMapping("course/{courseId}")`
    - `@DeleteMapping("course/{courseId}")`
  - _Book_
    - `@PostMapping("book")`
    - `@GetMapping("book")`
    - `@PutMapping("book/{bookId}")`
    - `@DeleteMapping("book/{bookId}")`
  - _Address_
    - `@PostMapping("address")`
    - `@GetMapping("address")`
    - `@PutMapping("address/{addressId}")`
    - `@DeleteMapping("address/{addressId}")`
- ### Services
  - _Student_
    ```java
    public String saveStudent(Student student)
    ```
    ```java
    public List<Student> getAllStudents()
    ```
    ```java
    public String updateStudent(String id, Student updatedStudent)
    ```
    ```java
    public String deleteStudentById(String id)
    ```
    ```java
    public Student getStudentById(String studentId)
    ```
    ```java
    public boolean isStudentExist(String id)
    ```
  - _Laptop_
    ```java
    public String saveLaptop(Laptop laptop)
    ```
    ```java
    public List<Laptop> getAllLaptops()
    ```
    ```java
    public String updateLaptopById(String lapId, Laptop laptop)
    ```
    ```java
    public String deleteLaptopById(String laptopId)
    ```
  - _Course_
    ```java
    public String saveCourse(Course course)
    ```
    ```java
    public List<Course> getAllCourses()
    ```
    ```java
    public String updateCourseById(String courseId, Course course)
    ```
    ```java
    public String deleteCourseById(String courseId)
    ```
  - _Book_
    ```java
    public String saveBook(Book book)
    ```
    ```java
    public List<Book> getAllBooks()
    ```
    ```java
    public String updateBookById(String bookId, Book book)
    ```
    ```java
    public String deleteBookById(String bookId)
    ```
  - _Address_
    ```java
    public String saveAddress(Address address)
    ```
    ```java
    public List<Address> getAllAddresses()
    ```
    ```java
    public String updateAddressById(Long addressId, Address address)
    ```
    ```java
    public String deleteAddressById(Long addressId)
    ```
- ### Repositories
  - _Student_
    ```java
    public interface IStudentRepository extends ListCrudRepository<Student, String> {
    }
    ```
  - _Laptop_
    ```java
    public interface ILaptopRepository extends ListCrudRepository<Laptop, String> {
    }
    ```
  - _Course_
    ```java
    public interface ICourseRepository extends ListCrudRepository<Course, String> {
    }
    ```
  - _Book_
    ```java
    public interface IBookRepository extends ListCrudRepository<Book, String> {
    }
    ```
  - _Address_
    ```java
    public interface IAddressRepository extends ListCrudRepository<Address, Long> {
    }
    ```
- ### Database
  In this project for datasource I've used **`MySQL` Database** for persistant memory with `SpringDataJPA`.

---

## Datastructures

- `List<>`

---

## Summary

This API is a `Spring Boot` project that is about managing Students, Laptops, Courses, Books, and Addresses. We can create, read, update, and delete Students, Laptops, Courses, Books, and Addresses. In this project request is sent from the client on HTTP in JSON format or from path variable and stored in object then response is sent back from the server by JSON format to the client.
