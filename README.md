# Pneuservice Information System

## Overview

This project is a tire management system developed for Pneuservice Ciccone AG. The system currently includes a core function to assign work tasks to employees using a calendar interface. It manages employee schedules efficiently and simplifies task allocation. The system is built with a back-end running on port 8081, a front-end using Angular running on port 4200, and a PostgreSQL database on port 5433.

![Screenshot 2024-09-30 alle 12 45 02 PM](https://github.com/user-attachments/assets/e97ed78c-540e-4fbc-8071-1c8528975cd0)

## Features

- Task Assignment: Assign specific tasks to employees via a calendar interface.
- Employee Management: View and manage employee work schedules.
- Future Expansion: The system is designed to be expandable, with potential features including inventory management, customer services, and a complete e-commerce platform (details in the project documentation).

## Installation and Setup

### 1. Clone the Repository
> git clone https://github.com/CRICRICode/Information-System cd pneuservice

### 2. Set Up the Database
The system uses PostgreSQL for database management. Make sure PostgreSQL is installed and configured properly.

- PostgreSQL Port: 5433
- Database Setup: Create a new database and update the necessary credentials in the configuration file (config.json or .env).

> psql -U your-username -p 5433 -c "CREATE DATABASE pneuservice_db;"

### 3. Configure the Environment

Set up the necessary environment variables for both the front-end and back-end. These variables include database connection details and server ports.

### 4. Install Dependencies

Navigate to the respective directories and install all required dependencies:

# For the backend

> cd backend npm install

# For the frontend

> cd ../frontend npm install

### 5. Start the Application

- Backend (API Server): 
  Run the following command from the `backend` folder:
> npm run start

- Frontend (UI Server): 
  Run the following command from the `frontend` folder, ensuring the UI is served on port 4200:
  > ng serve --port 4200
  
### 6. Access the Application

- UI: The frontend can be accessed at `http://localhost:4200`.
- API: The API server can be accessed on the port specified during setup (default: `http://localhost:8081`).

## Future Development

As mentioned in the documentation, the system is expected to be expanded in the future. Some of the key functionalities planned include:

- Inventory Management: Track stock levels and manage supply orders.
- Customer Services: Handle customer complaints and feedback.
- E-commerce Integration: Enable online tire purchases and booking services.

Please refer to the documentation for more detailed insights into the potential future developments and system requirements.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

