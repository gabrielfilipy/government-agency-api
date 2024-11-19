CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_ORGANIZATION (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    address_cep VARCHAR(20),
    address_city_id UUID,
    CONSTRAINT fk_address_city_id FOREIGN KEY (address_city_id) REFERENCES TBL_CITY(id)
);