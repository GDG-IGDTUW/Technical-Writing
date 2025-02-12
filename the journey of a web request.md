# The Journey of a Web Request

When you type a URL in your browser and press Enter, a fascinating journey begins. Let's break down this journey step by step.

## 1. DNS Resolution
- The browser first needs to find the actual IP address of the server
- It checks various DNS caches (browser, operating system, router)
- If not found in caches, it queries DNS servers
- Finally gets the IP address of the server

**TODO:** Add explanation of DNS cache hierarchy and time complexity of DNS lookups

## 2. Establishing TCP Connection
- The browser initiates a TCP connection with the server
- This happens through the famous three-way handshake:
  - **TODO:**Complete the three-way handshake

**TODO:** Add details about TCP window sizing and congestion control algorithms

## 3. TLS Handshake (for HTTPS)
- After TCP connection, a secure channel needs to be established
- Client and server exchange certificates
- They negotiate encryption algorithms
- A secure connection is established

## 4. HTTP Request Formation
- Browser creates an HTTP request with:
  - **TODO:**Complete the request formation

# Common HTTP Headers Guide

### General Request Headers
These headers provide basic information about the request and client preferences. They help establish the foundation of HTTP communication between client and server.
- `Host`: Specifies domain name and port number
- `User-Agent`: Browser/client identification and capabilities
- `Accept`: Media types the client can process
- `Accept-Language`: Preferred natural languages
- `Accept-Encoding`: Supported compression algorithms
- `Connection`: Connection management options

### Authentication Headers
Authentication headers handle security credentials and session management. They ensure secure communication and maintain user sessions across requests.
- `Authorization`: Credentials for HTTP authentication
- `Cookie`: Previously stored cookies
- `WWW-Authenticate`: Authentication method required
- `Proxy-Authorization`: Credentials for proxy authentication

### Content Headers
Content headers describe the message body and its properties. They help servers understand how to process the incoming data.
- `Content-Type`: Media type of the request body
- `Content-Length`: Size of the request body in bytes
- `Content-Encoding`: Encoding applied to the body
- `Content-Language`: Natural language of the body
- `Content-Disposition`: How to present the response

### Caching Headers
Caching headers control how responses are stored and reused. They optimize performance by reducing unnecessary server requests.
- `Cache-Control`: Directives for caching mechanisms
- `If-Match`: Conditional request based on ETag
- `If-None-Match`: Opposite of If-Match
- `If-Modified-Since`: Conditional request based on timestamp
- `If-Unmodified-Since`: Opposite of If-Modified-Since
- `ETag`: Resource version identifier

### Security Headers
Security headers protect against various web vulnerabilities. They enforce security policies and prevent common attack vectors.
- `Origin`: Where the request originated
- `Referer`: URL of the previous web page
- `Sec-Fetch-Dest`: Request destination
- `Sec-Fetch-Mode`: Request mode
- `Sec-Fetch-Site`: Cross-origin request type

### Custom Headers
Custom headers extend standard HTTP functionality. They're often used for application-specific features and proxy services.
- `X-Requested-With`: Identifies AJAX requests
- `X-Forwarded-For`: Client IP when using proxy
- `X-Forwarded-Proto`: Original protocol (HTTP/HTTPS)
- `X-Real-IP`: Original client IP address

## Response Headers

### Status Headers
Status headers provide information about the server and response status. They help clients understand how to handle the response.
- `Access-Control-Allow-Origin`: CORS permissions
- `Allow`: Valid methods for the resource
- `Server`: Software used by the server

### Location Headers
Location headers manage redirects and resource locations. They guide clients to the correct resource location.
- `Location`: URL for redirection
- `Refresh`: Seconds until automatic redirect

### Caching Response Headers
These headers help clients manage cached responses effectively. They provide information about resource freshness and validity.
- `Age`: Time in seconds response has been cached
- `Expires`: Date/time after which response is stale
- `Last-Modified`: Last modification date of resource
- `Vary`: Headers that affect the response

### Security Response Headers
Security response headers protect against client-side vulnerabilities. They enforce browser security features and prevent common attacks.
- `Content-Security-Policy`: Security policy directives
- `Strict-Transport-Security`: HTTPS enforcement
- `X-Content-Type-Options`: MIME type adherence
- `X-Frame-Options`: Frame embedding permissions
- `X-XSS-Protection`: Cross-site scripting filter

## 5. Server Processing
- Request arrives at the server
- Server routes the request to appropriate handler
- Application logic processes the request
- Database queries may be executed
- Response is generated

## 6. Response Journey
### **HTTP Response Journey**  

Once the server receives an HTTP request, it processes it and sends back a structured response. This journey involves several steps:  

#### **1. Server Processing the Request**  
The server receives the request, extracts relevant details (method, URL, headers, and body), and determines how to respond.  
- If the request targets a static file (e.g., HTML, CSS), the server retrieves it from storage.  
- If it requires database access, the server queries the database and processes the data.  
- If it involves business logic (e.g., user authentication), the server executes the required functions.  

#### **2. Generating the HTTP Response**  
The server constructs a response containing:  
- **Status Line** – Includes the HTTP version, status code (e.g., `200 OK`, `404 Not Found`), and status message.  
- **Headers** – Metadata about the response (e.g., `Content-Type`, `Content-Length`, `Set-Cookie`).  
- **Body (if applicable)** – The actual content being sent, such as an HTML page, JSON data, or a file.  

**Example Response:**  
```
HTTP/1.1 200 OK  
Content-Type: text/html  
Content-Length: 1024  

<html>
  <body>Welcome to the website!</body>
</html>
```

#### **3. Data Transmission Back to the Browser**  
Once generated, the response travels back through the network:  
- **Server sends the response** over **TCP/IP** using the same connection established by the request.  
- **Packets travel** across the internet, moving through routers, switches, and ISPs.  
- **The browser receives the response**, reassembles packets, and processes the data.  

#### **4. Browser Rendering the Response**  
Upon receiving the response, the browser:  
- Reads the **status code** to determine success or failure.  
- Interprets **headers** (e.g., caching rules, content type).  
- Displays **HTML/CSS/JavaScript** or executes required actions (e.g., redirecting, prompting a download).  

If additional resources (images, stylesheets, scripts) are needed, the browser sends new requests, repeating the process.
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

**TODO:** Add space and time complexity analysis for different caching strategies

## Error Scenarios
- **TODO:**Complete the error scenarios

## Security Considerations

Web applications are vulnerable to various security threats if proper precautions are not taken. Below are common security risks in the web request process and how to mitigate them.  

---

### **1. Cross-Site Scripting (XSS)**  
**Cause:**  
- Attackers inject malicious scripts into web pages viewed by other users.  
- This allows them to steal session cookies, deface content, or perform unauthorized actions.  

**Prevention:**  
- **Escape user input** before rendering it in HTML.  
- Use **Content Security Policy (CSP)** to block unauthorized scripts.  
- Sanitize input to remove malicious code.  

---

### **2. Cross-Site Request Forgery (CSRF)**  
**Cause:**  
- Attackers trick users into performing unintended actions on a site where they are authenticated (e.g., changing passwords, making transactions).  

**Prevention:**  
- Use **CSRF tokens** to verify legitimate requests.  
- Require **re-authentication** for sensitive actions.  
- Implement **SameSite cookies** to prevent cross-site request submissions.  

---

### **3. SQL Injection**  
**Cause:**  
- Attackers inject malicious SQL queries into input fields, allowing them to manipulate or access the database.  

**Prevention:**  
- Use **prepared statements and parameterized queries** to prevent query manipulation.  
- Sanitize and validate user inputs.  
- Restrict database permissions to minimize damage from an attack.  

---

### Importance of SSL/TLS Encryption 
**Purpose:**  
- Encrypts data transmitted between the client and server, preventing **Man-in-the-Middle (MITM) attacks**.  
- Ensures data integrity and confidentiality.  

**Best Practices:**  
- Always use **HTTPS** (SSL/TLS certificates).  
- Redirect HTTP traffic to HTTPS.  
- Enable **HSTS (HTTP Strict Transport Security)** to enforce secure connections.  

---

### Input Validation & Sanitization
**Importance:**  
- Prevents attacks like **XSS, SQL injection, and command injection** by filtering out harmful input.  

**Best Practices:**  
- Implement **whitelisting** (allow only expected input formats).  
- Use **server-side validation** alongside client-side checks.  
- Remove special characters that could be used in attacks.  

---

###Proper Session Management
**Risks:**  
- Poor session handling can lead to **session hijacking, fixation, or impersonation attacks**.  

**Prevention:**  
- Use **secure, HttpOnly, and SameSite cookies**.  
- Implement **session expiration and automatic logout** for inactive users.  
- Regenerate session IDs after login to prevent fixation attacks.  

---

This document provides a high-level overview of how web requests work. Several sections marked with **TODO** need additional details and technical depth. Contributions are welcome!
