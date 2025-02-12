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

## 7. Browser Processing
Once the browser receives the HTTP response, it processes the content and renders the webpage. The steps are part of the **Critical Rendering Path (CRP)**, which prioritizes essential content for improved performance.

---

### **1. Receiving the Response and Parsing HTML**  
When the browser detects an **HTML document**, it begins parsing it **line by line** to construct the **DOM (Document Object Model)**.  
- The **DOM** represents the structure of the webpage as a tree of elements (`<html>`, `<body>`, `<div>`, etc.).  
- If the parser encounters references to **external resources** (CSS, JS, images), it sends separate HTTP requests to fetch them.  

**Example:**  
```html
<html>
  <body>
    <h1>Welcome</h1>
    <img src="image.jpg" />
    <script src="script.js"></script>
  </body>
</html>
```
While parsing this, the browser detects `image.jpg` and `script.js` and starts downloading them asynchronously.

---

### **2. Downloading and Processing Additional Resources**  
As the browser parses the HTML, it requests additional resources:  

#### **CSS Parsing and the CSSOM (CSS Object Model)**  
- The browser downloads external **CSS stylesheets** and inline styles.  
- It then constructs the **CSSOM (CSS Object Model)**, which defines how styles apply to elements.  
- Until the CSSOM is ready, the page **cannot be rendered** (since styles affect layout).  

**Example CSS:**  
```css
h1 { color: blue; }
img { width: 100px; }
```
Creates the CSSOM:  
```
h1 → color: blue
img → width: 100px
```

#### **JavaScript Execution and its Effect on Rendering**  
- JavaScript can modify the DOM and CSSOM, so by default, the browser **pauses HTML parsing** when encountering a `<script>` tag.  
- To **prevent blocking**, scripts should use:  
  - **`defer`** – Loads scripts in order but executes them after parsing the HTML.  
  - **`async`** – Loads scripts in parallel and executes them as soon as they are ready.  

**Example:**  
```html
<script src="script.js" defer></script>
```
Ensures `script.js` runs only after the DOM is fully built.

---

### **3. Constructing the Render Tree**  
Once the **DOM** and **CSSOM** are built, the browser combines them into the **Render Tree**, which:  
- Excludes elements that don’t affect visual output (`display: none`).  
- Determines how elements should appear based on CSS rules.  

Example Render Tree for:  
```html
<body>
  <h1>Welcome</h1>
  <p hidden>Hidden text</p>
</body>
```
Would be:  
```
<body>
 ├── <h1> (visible)
```
(The `<p>` is excluded since it's hidden.)

---

### **4. Layout (Reflow) – Calculating Element Positions**  
The **layout stage** (or **reflow**) calculates:  
- The **size and position** of elements based on styles and screen size.  
- **Relative positions**, considering margins, padding, and flex/grid layouts.  

If a script or CSS change affects the layout, the browser must recalculate it, which can impact performance.

---

### **5. Painting – Rendering Pixels on the Screen**  
- After layout is determined, the browser converts elements into **actual pixels** (painting).  
- This process applies colors, images, shadows, and borders.  

---

### **6. Compositing and Display**  
Since modern browsers **render pages in layers** (like Photoshop), they optimize **compositing**:  
- Elements are split into **separate layers** (e.g., animations, fixed headers).  
- The GPU merges these layers efficiently for a **smooth visual experience**.  

---

Additionally to optimize speed, browsers **prioritize visible content first** using techniques like:  
- **Lazy Loading (`loading="lazy"`)** – Loads images only when they appear in the viewport.  
- **Minimizing Render-Blocking Resources** – Using `defer` for scripts and `media="print"` for non-critical CSS.  
- **Optimized Paint Timing** – Prioritizing above-the-fold content to ensure quick page rendering.  



## Common Optimization Techniques
- Content Delivery Networks (CDNs)
- Browser caching
- Compression
- Connection pooling

**TODO:** Add space and time complexity analysis for different caching strategies

## Error Scenarios
- **TODO:**Complete the error scenarios

## Security Considerations
- **TODO:**Complete the security considerations

**TODO:** Add detailed explanation of common security vulnerabilities and prevention techniques

---

This document provides a high-level overview of how web requests work. Several sections marked with **TODO** need additional details and technical depth. Contributions are welcome!
