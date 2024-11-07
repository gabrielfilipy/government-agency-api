CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_ENDERECO (
    endereco_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    endereco_cep VARCHAR(20),
    endereco_cidade_id UUID,
    CONSTRAINT fk_cidade FOREIGN KEY (endereco_cidade_id) REFERENCES TBL_CIDADE(cidade_id)
);