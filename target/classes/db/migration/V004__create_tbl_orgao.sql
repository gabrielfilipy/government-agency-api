CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_ORGAO (
    orgao_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    endereco_cep VARCHAR(20),
    endereco_cidade_id UUID,
    CONSTRAINT fk_endereco_cidade FOREIGN KEY (endereco_cidade_id) REFERENCES TBL_CIDADE(cidade_id)
);