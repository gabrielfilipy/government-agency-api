CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_CIDADE (
    cidade_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255),
    estado_id UUID,
    CONSTRAINT fk_estado FOREIGN KEY (estado_id) REFERENCES TBL_ESTADO(estado_id)
);
