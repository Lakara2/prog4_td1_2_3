CREATE TABLE industry (
    id SERIAL PRIMARY KEY,
    industry_name VARCHAR(255) NOT NULL,
    industry_description VARCHAR(255),
    industry_slogan VARCHAR(255),
    industry_logo VARCHAR(255),
    NIF VARCHAR(20),
    STAT VARCHAR(20),
    RCS VARCHAR(20),
    industry_email VARCHAR(255),
    industry_address VARCHAR(255)
);

CREATE TABLE industry_phone (
    id SERIAL PRIMARY KEY,
    phone_number VARCHAR(20),
    industry_id BIGINT,
    FOREIGN KEY (industry_id) REFERENCES industry (id) ON DELETE CASCADE
);
