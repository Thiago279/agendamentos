CREATE TABLE clients (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20)
);

CREATE TABLE schedules (
    id BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_schedules_client FOREIGN KEY (client_id) REFERENCES clients (id)
);
