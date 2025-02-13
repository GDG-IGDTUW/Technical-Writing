# The Journey of a Web Request

When you type a URL in your browser and press Enter, a fascinating journey begins. Let's break down this journey step by step.

## 1. DNS Resolution
- The browser first needs to find the actual IP address of the server
- It checks various DNS caches (browser, operating system, router)
- If not found in caches, it queries DNS servers
- Finally gets the IP address of the server

<!-- **TODO:** Add explanation of DNS cache hierarchy and time complexity of DNS lookups -->
### DNS Cache Hierarchy

DNS resolution involves multiple layers of caching. Each layer in the DNS cache hierarchy is checked sequentially, ensuring the fastest 
possible resolution by retrieving the IP address from the closest available cache.

Here is the working of the hierarchy-

**1. Browser Cache**
- The browser is the first place checked for a cached DNS entry. Browsers store DNS records for previously visited domains.
- This cache reduces the need for repetitive DNS lookups, enhancing performance.
- Time Complexity - O(1)
  
**2. Operating System (OS) Cache**
- If the IP address isn't found in the browser cache, the operating system's DNS cache is checked.
- The OS maintains the local cache of the DNS records retrieved by all the applications, including the browsers.
- Time Complexity - O(1)

**3. Router Cache**
 - If the IP address is not in the OS cache, the query is sent to the local router.
 - Many modern routers cache DNS records to speed up requests from devices on the same network.
 - Time Complexity - O(1)

**4. DNS Resolver Cache**
- If the OS cache doesn't have the record, the query is sent to the Recursive DNS Resolver Cache, usually managed by the ISP or a third-party provider (e.g. Google DNS).
- Time Complexity - O(1)
  
**5. Authoritative DNS Server**
-  If the DNS server does not contain the requested DNS record, the resolver queries the authoritative DNS server for the domain.
-  The authoritative DNS server provides the definitive IP address for the requested domain.
-  Time Complexity: O(n) where n is the number of hierarchical DNS servers queried
  
### Performance Impact

- **Cache Hits:** The closer the cache layer, the faster the resolution. For example, a hit in the browser cache is the fastest.
- **Cache Miss:** If no cache layer has the IP address, the query goes through the full DNS hierarchy, increasing latency.
- **TTL (Time To Live):** DNS records have a TTL value that determines how long they are cached. Short TTLs lead to more frequent cache misses.

## 2. Establishing TCP Connection
Establishing TCP Connection
When a browser initiates communication with a web server, it establishes a TCP (Transmission Control Protocol) connection to ensure reliable, ordered data transmission. This process consists of several key steps.

TCP Three-Way Handshake
The connection setup follows a three-way handshake, ensuring both client and server synchronize before data transmission begins:

1.SYN (Synchronize)
The client sends a SYN packet to the server, requesting a connection.
The packet includes an Initial Sequence Number (ISN) to track transmitted data.

2.SYN-ACK (Synchronize-Acknowledge)
The server responds with a SYN-ACK packet, acknowledging the client's request.
It also sends its own ISN to synchronize communication.

3.ACK (Acknowledge)
The client responds with an ACK packet, confirming the connection is established.
Data transfer begins.

Example of Three-Way Handshake:
Client → Server: SYN (ISN=1000)
Server → Client: SYN-ACK (ISN=5000, ACK=1001)
Client → Server: ACK (ACK=5001)


TCP Window Sizing and Flow Control:
TCP uses window sizing to manage how much data can be sent before receiving an acknowledgment, preventing network congestion and overwhelming the receiver.

1. TCP Sliding Window Mechanism
Each sender and receiver maintain a window size, indicating how much unacknowledged data can be in transit.
The receiver advertises a window size (Receiver Window, rwnd) to inform the sender of its available buffer space.
The sender adjusts the amount of data sent to avoid overwhelming the receiver.
2. Bandwidth-Delay Product (BDP)
The ideal window size is calculated based on network bandwidth and Round-Trip Time (RTT):
𝐵𝐷𝑃 = Bandwidth × RTT

A properly tuned window size improves throughput by maximizing link utilization.


Congestion Control Algorithms :
TCP congestion control mechanisms help prevent excessive packet loss and network congestion. The most widely used algorithm is AIMD (Additive Increase Multiplicative Decrease), which dynamically adjusts the transmission rate based on network conditions.

1. Additive Increase Phase (AI)
When no congestion is detected, TCP gradually increases the congestion window (cwnd) to maximize throughput.
The increase is linear, meaning TCP adds 1 Maximum Segment Size (MSS) per RTT.

2. Multiplicative Decrease Phase (MD)
When packet loss occurs (indicating congestion), TCP halves the congestion window (cwnd) to quickly reduce network load.
This exponential reduction helps prevent congestion collapse.

3. Phases of Congestion Control
Slow Start:
TCP starts with a small cwnd and increases it exponentially to quickly probe available bandwidth.
Congestion Avoidance:
Once a threshold is reached, growth shifts to linear (Additive Increase) to prevent network overload.
Fast Retransmit & Fast Recovery:
If 3 duplicate ACKs are received, TCP retransmits lost packets without waiting for a timeout.


How These Mechanisms Manage Data Flow & Congestion :
1.Prevents buffer overflow: The receiver’s advertised window (rwnd) ensures that the sender does not overwhelm it.
2.Optimizes bandwidth usage: Sliding window and BDP tuning maximize throughput efficiency.
3.Avoids congestion collapse: AIMD dynamically adjusts sending rates based on network conditions.
4.Maintains fairness: Multiplicative decrease ensures all network users get a fair share of bandwidth.



## 3. TLS Handshake (for HTTPS)
- After TCP connection, a secure channel needs to be established
- Client and server exchange certificates
- They negotiate encryption algorithms
- A secure connection is established

## 4. HTTP Request Formation
- Browser creates an HTTP request with the following components:
# HTTP Request Components

## HTTP Methods
HTTP methods define the intended action for a request:

### GET
- Retrieves resources from the server
- Cannot include a request body
- Data sent through URL parameters only
- Example: `GET /api/products`

### POST
- Submits data to create new resources
- Includes data in request body
- Example: `POST /api/users`

### PUT
- Updates existing resources completely
- Includes full resource in body
- Example: `PUT /api/users/123`

### DELETE
- Removes specified resources
- Typically no body needed
- Example: `DELETE /api/users/123`

## Headers
Headers provide essential metadata for request processing:

### Common Request Headers
- Host: Target host and port number
- Content-Type: Format of sent data
- Content-Length: Size of request body
- Authorization: Authentication credentials
- Accept: Expected response formats
- User-Agent: Client application info
- Cookie: Session data

Example header set:
```
Host: api.example.com
Content-Type: application/json
Content-Length: 128
Authorization: Bearer <token>
```

## Request Body
The body carries data in various formats based on Content-Type:

### Types
1. application/json
   - Structured data in JSON format
   - Used for API requests

2. application/x-www-form-urlencoded
   - Simple key-value pairs
   - Default for HTML forms

3. multipart/form-data
   - File uploads
   - Mixed content types

## URL Parameters
Query parameters in the URL for data transmission:

### Structure
- Start with question mark (?)
- Use key=value format
- Join multiple parameters with ampersand (&)
- Must be URL-encoded

Example: `/search?query=term&category=books&page=1`

## 5. Server Processing
- Request arrives at the server
- Server routes the request to appropriate handler
- Application logic processes the request
- Database queries may be executed
- Response is generated

## 6. Response Journey
- Server sends HTTP response
- **TODO:**Complete the response journey
- Data travels back through the network

## 7. Browser Processing
- Browser receives the response
- If HTML, begins parsing
- Downloads additional resources (CSS, JS, images)
- Renders the page

**TODO:** Add details about browser rendering pipeline and critical rendering path

## Common Optimization Techniques
- Content Delivery Networks (CDNs)
- Browser caching
- Compression
- Connection pooling

## Caching Strategies: Space and Time Complexity Analysis

1. Browser Cache
-Time Complexity: O(1) for lookup, O(n) for cache replacement.
-Space Complexity: O(n), where n is the number of cached entries.
-Trade-offs: High speed, but limited by local storage size.
-Best Use Case: Frequently accessed static assets (CSS, JS, images).

2. Server-Side Cache
-Time Complexity: O(1) for lookup, O(n) for eviction.
-Space Complexity: O(n), depending on allocated storage.
-Trade-offs: Reduces backend load, but must be carefully invalidated.
-Best Use Case: Dynamic content like API responses and database query results.

3. CDN Cache
-Time Complexity: O(1) for cache hit, O(n) for cache population.
-Space Complexity: O(n), based on network storage capacity.
-Trade-offs: Highly scalable, but propagation delays can occur.
-Best Use Case: Global distribution of static and media content.

## Error Scenarios
- **TODO:**Complete the error scenarios

## Security Considerations
- **TODO:**Complete the security considerations

**TODO:** Add detailed explanation of common security vulnerabilities and prevention techniques

---

This document provides a high-level overview of how web requests work. Several sections marked with **TODO** need additional details and technical depth. Contributions are welcome!
