CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_CITY (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    state_id UUID,
    CONSTRAINT fk_state FOREIGN KEY (state_id) REFERENCES TBL_STATE(id)
);
