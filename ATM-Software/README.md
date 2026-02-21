# ATM-Software

This simple Java program simulates an ATM (Automated Teller Machine) interface. It allows a user to:

- Enter their first name
- Deposit money into an account
- Withdraw money from an account (with balance checks)
- View their current balance
- Exit the program with a final balance message

All interactions are performed via the console using standard input.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed (Java 11 or later recommended).
- A command-line terminal (Command Prompt, PowerShell, etc.).

### Running the Program

1. Open a terminal and navigate to the project directory:
   ```sh
   cd ATM-Software
   ```
2. Compile the source code:
   ```sh
   javac ATM.java
   ```
3. Run the compiled program:
   ```sh
   java ATM
   ```
4. Follow the on-screen prompts to interact with the ATM simulation.

### Notes

- The starting balance is set to `$567.95`. You can change this value by editing the `balance` field in `ATM.java`.
- The program performs basic input validation to ensure numerical entries for menu choices and amounts.

## Contributing

Feel free to fork the repository, improve the code, or add new features. Suggestions and pull requests are welcome!

## License

This project is provided for educational purposes. No license is specified.
