# iso8583-simulator
POS Simulator → Switch (jPOS) → Issuer Simulator → Response

# ISO8583 Simulator (jPOS-based)

A **jPOS-based ISO 8583 simulator** to test and simulate card payment transactions, including debit, credit, and prepaid cards. This project is designed for learning, testing, and switch simulation in banking/payment domains.

---

## Features

- Simulate **ISO 8583 messages** for financial transactions  
- Supports **authorization, reversal, and settlement flows**  
- Handles **Track 2 data, DE fields, and bitmaps**  
- Lightweight **Java-based** simulator using jPOS  
- Useful for **developers, testers, and banking professionals**  

---

## ISO 8583 Transaction Flow

```mermaid
flowchart LR
    A[Card Entry / Swipe / Insert] --> B[POS / ATM Terminal]
    B --> C[Acquirer / Payment Gateway]
    C --> D[ISO 8583 Message Creation]
    D --> E[Issuer Bank / Switch Simulator]
    E --> F[Authorization / Response]
    F --> B
    F --> G[Receipt Printed / Transaction Complete]


Flow description:

Card is inserted/swiped at terminal
Terminal sends transaction request to acquirer/payment gateway
Request is converted into ISO 8583 message (DE fields, bitmaps)
Issuer or simulator processes the message and returns response
Terminal receives response and completes transaction
