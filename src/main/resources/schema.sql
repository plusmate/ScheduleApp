CREATE TABLE schedule(
                        id INT AUTO_INCREMENT PRIMARY KEY ,
                        name VARCHAR(15) NOT NULL ,
                        content VARCHAR(255) ,
                        password VARCHAR(255) NOT NULL ,
                        created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);