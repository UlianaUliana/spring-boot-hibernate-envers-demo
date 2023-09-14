CREATE TABLE users (
    user_id serial PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_date timestamp with time zone DEFAULT current_timestamp,
    modified_date timestamp with time zone DEFAULT current_timestamp,
    created_by VARCHAR(255) NOT NULL,
    modified_by VARCHAR(255) NOT NULL
);

-- Create revinfo table
CREATE TABLE revinfo (
    rev SERIAL PRIMARY KEY,
    revtstmp BIGINT
);

-- Create users_aud table
CREATE TABLE users_aud (
                           user_id INTEGER NOT NULL,
                           first_name VARCHAR(50),
                           last_name VARCHAR(50),
                           rev INTEGER NOT NULL,
                           revtype INTEGER NOT NULL,
                           PRIMARY KEY (user_id, rev),
                           FOREIGN KEY (rev) REFERENCES revinfo (rev),
                           created_date timestamp with time zone,
                           modified_date timestamp with time zone,
                           created_by VARCHAR(255),
                           modified_by VARCHAR(255)
);