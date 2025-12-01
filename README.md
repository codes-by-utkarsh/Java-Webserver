# Java Socket Servers --- Single Threaded, Multi-Threaded & ThreadPool

This repository contains three different Java server implementations
that demonstrate how concurrency models affect performance and
scalability:

-   **Single-Threaded Server**
-   **Multi-Threaded Server (New Thread per Client)**
-   **ThreadPool-Based Server (Fixed Executor Service)**

I tested all three by sending \~1500 Requests Per Second (RPS).\
👉 The **single-threaded server failed** at handling this load.\
👉 The **multi-threaded** and **thread-pool** versions handled it
smoothly.

------------------------------------------------------------------------

## 🚀 Project Overview

### 1. **Single-Threaded Server**

-   Uses **one thread** to accept and process client requests.
-   Blocks on each request.
-   Cannot accept new requests until the previous one completes.
-   **Fails under high load** (1500 RPS) because the thread becomes a
    bottleneck.

#### Why it is slow:

Client A --\> \[Thread is busy\] --\> Client B waits\
Client C waits\
Client D waits

### 2. **Multi-Threaded Server**

-   Creates a **new thread for every incoming client connection**.
-   Each client is processed independently.
-   Much faster than single-threaded, easily handles 1500 RPS.

### 3. **ThreadPool Server**

-   Uses an `ExecutorService` with a **fixed-size thread pool**.

-   Reuses worker threads instead of creating new ones.

-   Ideal trade-off between:

    -   Speed\
    -   Memory usage\
    -   Stability

------------------------------------------------------------------------

## 📊 Performance Summary

  Server Type       1500 RPS Test   Notes
  ----------------- --------------- -------------------------------
  Single-threaded   ❌ Fails        Blocks on each request
  Multi-threaded    ✔ Handles       Too many threads possible
  ThreadPool        ✔ Handles       Best performance + efficiency

------------------------------------------------------------------------

## 🛠️ Setup Instructions

### Prerequisites

-   Java 17+
-   Any IDE or terminal

### Running Servers

#### Single Threaded

    javac SingleThreadServer.java
    java SingleThreadServer

#### Multi Threaded

    javac MultiThreadServer.java
    java MultiThreadServer

#### ThreadPool Server

    javac ThreadPoolServer.java
    java ThreadPoolServer

------------------------------------------------------------------------

## 🔍 Load Testing

Use jtester GUI for testing the Server


------------------------------------------------------------------------
