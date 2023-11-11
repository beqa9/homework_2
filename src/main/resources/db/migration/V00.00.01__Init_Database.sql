
CREATE TABLE exel
(
    id serial PRIMARY KEY,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL,
    name varchar(255) NOT NULL,
    created_at timestamp
);
CREATE TABLE exel_history
(
    id serial PRIMARY KEY,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    name varchar(255) NOT NULL,
    created_at timestamp
);
CREATE TABLE users
(
    id serial PRIMARY KEY,
    email varchar(255) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    first_name varchar(255),
    last_name varchar(255),
    last_login_date timestamp,
    active boolean NOT NULL default true,
    changed_by integer references users(id),
    changed_at timestamp,
    created_by integer references users(id),
    created_at timestamp
);
CREATE TABLE vehicles
(
    id serial PRIMARY KEY,
    registration_number varchar(255) NOT NULL,
    driver_name varchar(255) NOT NULL,
    vehicle_type varchar(255) NOT NULL,
    length DOUBLE PRECISION NOT NULL,
    width DOUBLE PRECISION NOT NULL,
    height DOUBLE PRECISION NOT NULL,
    capacity DOUBLE PRECISION NOT NULL,
    status boolean NOT NULL
);
