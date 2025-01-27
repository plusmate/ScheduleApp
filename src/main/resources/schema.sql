CREATE TABLE IF NOT EXISTS schedule(
                        id INT AUTO_INCREMENT PRIMARY KEY ,
                        name VARCHAR(15) NOT NULL ,
                        content VARCHAR(255) ,
                        password VARCHAR(255) NOT NULL ,
                        created_date DATE NOT NULL,
                        updated_date DATE NOT NULL
);