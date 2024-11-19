CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_ADDRESS (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    address_cep VARCHAR(20),
    address_city_id UUID,
    CONSTRAINT fk_city FOREIGN KEY (address_city_id) REFERENCES TBL_CITY(city_id)
);