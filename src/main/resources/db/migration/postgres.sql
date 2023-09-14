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
                           FOREIGN KEY (rev) REFERENCES revinfo (rev)
);

ALTER TABLE users
    ADD COLUMN created_date timestamp with time zone DEFAULT current_timestamp,
    ADD COLUMN modified_date timestamp with time zone DEFAULT current_timestamp,
    ADD COLUMN created_by VARCHAR(255) NOT NULL,
    ADD COLUMN modified_by VARCHAR(255) NOT NULL;

ALTER TABLE users_aud
    ADD COLUMN created_date timestamp with time zone DEFAULT current_timestamp,
    ADD COLUMN modified_date timestamp with time zone DEFAULT current_timestamp,
    ADD COLUMN created_by VARCHAR(255) NOT NULL,
    ADD COLUMN modified_by VARCHAR(255) NOT NULL;

ALTER TABLE users_aud
    ALTER COLUMN created_by DROP NOT NULL,
    ALTER COLUMN modified_by DROP NOT NULL;

ALTER TABLE users_aud
    ALTER COLUMN created_date DROP DEFAULT,
    ALTER COLUMN modified_date DROP DEFAULT;


-- Vertical query
SELECT *
FROM
    users_aud ua
JOIN
    revinfo ri ON ua.rev = ri.rev
WHERE
        user_id = 14;

-- Horisontal query
SELECT *
FROM
    users_aud ua
        JOIN
    revinfo ri ON ua.rev = ri.rev
WHERE
        ua.rev <= 352;