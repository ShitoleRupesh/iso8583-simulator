# ISO 8583 Payment Simulator - jPOS

**Author:** Rupesh Shitole  
**Domain:** Payments | ISO 8583 | jPOS | Backend

---

## 🔹 Overview
This project is a **full ISO 8583 payment simulator** built with jPOS.  
It includes:

- POS (Point of Sale) client simulation  
- Issuer simulator  
- ISO 8583 0100 / 0110 messages (authorization flow)  
- Configurable ISO packager (`iso87ascii.xml`)  

---

## 🔹 Features
- Generate and parse ISO 8583 messages  
- Handle multiple transaction types: **Authorization, Reversal**  
- Logs messages for audit and analysis  
- jPOS-based backend simulator  
- Ready for integration with payment switch  

---

## 🔹 Project Structure

jpos-demo/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── POSClient.java
│ │ │ └── SimpleIssuerSimulator.java
│ │ └── resources/
│ │ └── cfg/iso87ascii.xml
├── .gitignore
└── pom.xml


---

## 🔹 ISO 8583 Flow Diagram
```text
Card → POSClient → jPOS Switch → Issuer Simulator → Response → POS
