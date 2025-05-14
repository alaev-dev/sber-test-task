CREATE TABLE IF NOT EXISTS message(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    content TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL
);

