#### MySql
In order to run the program, you need to create the following table

CREATE TABLE phone_calls (
    id INT AUTO_INCREMENT PRIMARY KEY,
    time VARCHAR(45),
    call_type VARCHAR(45),
    duration INT,
    phone_number VARCHAR(45),
    saved_contact TINYINT
);

-- creates user with prop privileges
CREATE USER 'phonecalls'@'%' IDENTIFIED BY 'phonecalls';

GRANT ALL PRIVILEGES ON * . * TO 'phonecalls'@'%';

#### endpoinds
POST - /api/phone-call
GET - /api/phone-call/xx
GET - /api/phone-call/duration/xx
PUT - /api/phone-call
