# Custom Load Balancer

A custom load balancer implementation in Java using Spring Boot. This project supports different load balancing algorithms including consistent hashing and round-robin.

## Features

- **Consistent Hashing**: Distributes requests based on a consistent hash ring.
- **Round Robin**: Distributes requests in a round-robin fashion.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/custom-load-balancer.git
    cd custom-load-balancer
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

You can test the load balancer using Postman or any other HTTP client.

1. **Consistent Hashing**:
    - URL: `http://localhost:8080/api/route?key=testKey`
    - Method: `GET`

   Response example:
    ```
    Request for testKey is routed to server1
    ```

2. **Round Robin**:
    - Change the algorithm in `Main.java` to `ROUND_ROBIN` and restart the application.
    - URL: `http://localhost:8080/api/route?key=testKey`
    - Method: `GET`

   Response example:
    ```
    Request for testKey is routed to server2
    ```

## Contributing

Feel free to fork this repository and contribute by submitting a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.