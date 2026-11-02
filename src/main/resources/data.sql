DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    mail VARCHAR(250) NOT NULL,
    position VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

INSERT INTO employees (first_name, last_name, mail, position, password) 
VALUES
    ('Laurent', 'GINA', 'laurantGINA@gmail.com', 'Developer', 'laurent'),
    ('Sophie', 'KONFE', 'Sophiekonfe@gmail.com', 'Manager', 'Sophie'),
    ('Agathe', 'FEEL', 'Agathefee@gmail.com', 'Designer', 'laurent');